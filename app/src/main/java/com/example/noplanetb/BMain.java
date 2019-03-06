package com.example.noplanetb;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BMain extends AppCompatActivity {
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = findViewById(R.id.myswipe);
        refreshLayout.setOnRefreshListener(mOnRefreshListener);

    }

        protected SwipeRefreshLayout.OnRefreshListener
                mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh() {
                Toast toast0 = Toast.makeText(BMain.this, "going swipeREFRESH", Toast.LENGTH_LONG);
                        toast0.show();
                refreshLayout.setRefreshing(false);
            }
        };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void showAlertDialogButtonClicked(BMain view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

//        builder.setView(getLayoutInflater().inflate(R.layout.dialog_view, null));

        builder.setTitle("Has clicado el corazon");
        builder.setMessage("¿Y ahora que?");
        builder.setIcon(R.drawable.ic_action_name);

        // add the buttons
        builder.setPositiveButton("Go to GIF", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Go to ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //    creamos una lista de eventos para los items del menu del AppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "going Settings", Toast.LENGTH_LONG);
            toast.show();
        } else if (id == R.id.camera) {

            showAlertDialogButtonClicked(BMain.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
