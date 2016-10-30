package com.forpoint.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG="MyActivity";
    String text ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"onCreate()");
        textView = (TextView)findViewById(R.id.text);
        text = textView.getText().toString();
        text += '\n' + "onCreate()";
        textView.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy()");
        text = textView.getText().toString();
        text += '\n' + "onDestroy()";
        textView.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause()");
        text = textView.getText().toString();
        text += '\n' + "onPause()";
        textView.setText(text);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"onRestart()");
        text = textView.getText().toString();
        text += '\n' + "onRestart()";
        textView.setText(text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume()");
        text = textView.getText().toString();
        text += '\n' + "onResume()";
        textView.setText(text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart()");
        text = textView.getText().toString();
        text += '\n' + "onStart()";
        textView.setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop()");
        text = textView.getText().toString();
        text += '\n' + "onStop()";
        textView.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
