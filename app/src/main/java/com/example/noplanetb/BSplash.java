package com.example.noplanetb;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

public class BSplash extends Activity {
    private CircularImageView cohete;
    private  TextView tituloSplash, pieSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView fondoPlaneta = (ImageView) findViewById(R.id.backplanet);
        cohete = (CircularImageView) findViewById(R.id.circularCohete);
        tituloSplash = findViewById(R.id.txtTituloSplash);
        pieSplash = findViewById(R.id.txtPieSplash);

        Glide.with(this)
                .load(R.drawable.planetearth)
                .apply(new RequestOptions()

//                        .override(50, 50)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(fondoPlaneta);


        animaciones(true);

        abrimosApp(true);



    }

    private void abrimosApp(boolean b) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BSplash
                        .this, BLogin.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void animaciones(boolean locationPermission) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation myanim = AnimationUtils.loadAnimation(BSplash.this, R.anim.slideup);
                cohete.startAnimation(myanim);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fadeIn = AnimationUtils.loadAnimation(BSplash.this, R.anim.fadein);
                tituloSplash.startAnimation(fadeIn);
                tituloSplash.setVisibility(View.VISIBLE);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fadeIn = AnimationUtils.loadAnimation(BSplash.this, R.anim.fadein);
                pieSplash.startAnimation(fadeIn);
                pieSplash.setVisibility(View.VISIBLE);
            }
        }, 1000);

    }

}
