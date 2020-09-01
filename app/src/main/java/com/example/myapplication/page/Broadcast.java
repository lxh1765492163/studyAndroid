package com.example.myapplication.page;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ui.BaseActivity;

public class Broadcast extends BaseActivity implements View.OnClickListener {

    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast);

        Button button = findViewById(R.id.send_broadcast);
        button.setOnClickListener(this);

        IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    public void onClick (View view){
        int id = view.getId();

        switch (id) {
            case R.id.send_broadcast:
                Intent intent = new Intent();
                intent.setAction("123456");
                intent.addCategory("aaa");
                //Toast.makeText(this, "自定义广播", Toast.LENGTH_LONG).show();
                sendBroadcast(intent);
                break;
        }

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    private class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {


            ConnectivityManager connectivityManager = (ConnectivityManager)
            getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


            if( networkInfo !=null && networkInfo.isAvailable() ){
                Toast.makeText(context, "网络存在！！！！！！", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context, "网络不存在！！！！！", Toast.LENGTH_LONG).show();
            }
        }

    }
}
