package com.forpoint.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/7.
 */
public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String strMsg=intent.getStringExtra("broadcastmsg");
        Toast.makeText(context,strMsg,Toast.LENGTH_LONG).show();
    }
}
