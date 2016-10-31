package com.forpoint.callintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    public void onOpenClick(View view){
        //Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
        //Intent intent =new Intent();
        //intent.setAction("AnotherActivity");
        //intent.addCategory("android.intent.category.DEFAULT");
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("schemodemo://edu.bistu/path"));
        startActivity(intent);
    }

    public void onCallClick(View view){

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this,"无打电话权限",Toast.LENGTH_SHORT).show();
            return;
        }
        EditText editText = (EditText)findViewById(R.id.edit);
        String phonenumber = editText.getText().toString();
        String encodedPhonenumber = null;
        try {
            encodedPhonenumber = URLEncoder.encode(phonenumber, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + encodedPhonenumber)));

    }
}
