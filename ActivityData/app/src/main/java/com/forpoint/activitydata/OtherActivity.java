package com.forpoint.activitydata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent=getIntent();
        String s1=intent.getStringExtra("1");
        String s2=intent.getStringExtra("2");
        String s3=intent.getStringExtra("3");
        Integer i1=intent.getIntExtra("4",100);
        Toast.makeText(this,s1+s2+s3+i1,Toast.LENGTH_LONG).show();

    }

}
