package com.example.waterloohack.gymhero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.os.AsyncTask;
import android.view.MenuItem;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class MyActivity extends AppCompatActivity  implements View.OnClickListener {


    //final String msgId = getValue(R.id.upstream_message_id);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void onClick(final View view) {

        final GoogleCloudMessaging gcm =
                GoogleCloudMessaging.getInstance(getApplicationContext());
        if (view == findViewById(R.id.btnSend)) {
            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {
                    String msg = "";
                    try {
                        Bundle data = new Bundle();
                        data.putString("my_message", "Hello World");
                        data.putString("my_action","SAY_HELLO");
                        Integer msgId = 123;
                        //String id = Integer.toString(msgId.incrementAndGet());
                        gcm.send("738712038248" + "@gcm.googleapis.com", "", data);
                        msg = "Sent message";
                    } catch (IOException ex) {
                        msg = "Error :" + ex.getMessage();
                    }
                    return msg;
                }

                @Override
                protected void onPostExecute(String msg) {
                   // mDisplay.append(msg + "\n");
                }
            }.execute(null, null, null);
        } /*else if (view == findViewById(id.clear)) {
           // mDisplay.setText("");
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == id.) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


}

