package com.forpoint.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/7.
 */


public class MyService extends Service {
    //logcat tag
    private static final String TAG="myServiceTag";

    //onBind返回的IBinder接口对象
    private LocalBinder myBinder=new LocalBinder();

    //计算器binder
    public class LocalBinder extends Binder{
        MyService getService() {
            return MyService.this;
        }
    }


    public MyService() {
    }

    public int add(int x,int y){
        return x+y;
    }

    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate()");
        Toast.makeText(MyService.this, "onCreate()", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "onStartCommand()");
        Toast.makeText(MyService.this, "onStartCommand()", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy()");
        Toast.makeText(MyService.this, "onDestroy()", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "onBind()");
        Toast.makeText(MyService.this, "onBind()", Toast.LENGTH_SHORT).show();
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG, "onUnbind()");
        Toast.makeText(MyService.this, "onUnbind()", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(TAG, "onRebind()");
        Toast.makeText(MyService.this, "onRebind()", Toast.LENGTH_SHORT).show();
        super.onRebind(intent);
    }
}
