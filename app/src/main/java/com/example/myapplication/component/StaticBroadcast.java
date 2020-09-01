package com.example.myapplication.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class StaticBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals("123456")){
            Toast.makeText(context, "收到广播", Toast.LENGTH_SHORT).show();
        }
    }

}
