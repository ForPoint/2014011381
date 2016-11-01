package com.forpoint.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int intCount = 0;
    TextView txtCount ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView textView = (TextView) findViewById(R.id.txtContent);
        txtCount = (TextView)findViewById(R.id.txtCount);

        final Handler handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                textView.setText(msg.arg1+"");
                txtCount.setText(msg.arg2+"");
            }
        };


        final Runnable myWorker = new Runnable() {
            @Override
            public void run() {

                int progress = 0;
                while(progress <= 100){
                    Message msg = new Message();
                    msg.arg2 = intCount;
                    msg.arg1 = progress;
                    handler.sendMessage(msg);
                    progress += 10;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                intCount--;
                Message msg = handler.obtainMessage();//同 new Message();
                msg.arg1 = -1;

                handler.sendMessage(msg);
            }
        };

        Button button = (Button) findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread workThread = new Thread(null, myWorker, "WorkThread");
                txtCount = (TextView)findViewById(R.id.txtCount);
                intCount++;
                txtCount.setText(Integer.toString(intCount));
                workThread.start();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
