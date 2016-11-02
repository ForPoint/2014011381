package com.forpoint.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/7.
 */

public class MyService extends Service {
    private static final String TAG="myServiceTag";
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.v(TAG,"onCreate()");
        Toast.makeText(MyService.this,"onCreate()",Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG,"onStartCommand()");
        int n=intent.getIntExtra("num",0);
        Toast.makeText(MyService.this,"random int is:"+n,Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.v(TAG,"onDestroy()");
        Toast.makeText(MyService.this,"onDestroy()",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG,"onBind()");

        Toast.makeText(MyService.this,"onBind()",Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG,"onUnbind()");

        Toast.makeText(MyService.this,"onUnbind()",Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }
}
