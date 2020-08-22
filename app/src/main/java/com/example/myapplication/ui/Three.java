package com.example.myapplication.ui;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.TestBean;

public class Three extends BaseActivity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);

        findViewById(R.id.go_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case  R.id.go_back:
                backValue();
                break;
        }
    }

    @Override
    public void onBackPressed(){
        backValue();
    }

    public void backValue(){
        TestBean testBean = new TestBean();
        Intent intent = new Intent();

        testBean.setName("骆小红");
        testBean.setAge(30);
        testBean.setWeight("55g");

        intent.putExtra("data_return", "helow  MainActivity");
        intent.putExtra("data_return2", testBean);

        //向上一个活动页返回数据
        setResult(RESULT_OK, intent);

        finish();
    }

    public static class Life3Activity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.life3);
            Log.i(TAG, "life2 onCreate called.");
        }

        String TAG = "title";
        //Activity创建或者从后台重新回到前台时被调用
        @Override
        protected void onStart() {
            super.onStart();
            Log.i(TAG, "life2 onStart called.");
        }

        //Activity从后台重新回到前台时被调用
        @Override
        protected void onRestart() {
            super.onRestart();
            Log.i(TAG, "life2 onRestart called.");
        }

        //Activity创建或者从被覆盖、后台重新回到前台时被调用
        @Override
        protected void onResume() {
            super.onResume();
            Log.i(TAG, "life2 onResume called.");
        }

        //Activity窗口获得或失去焦点时被调用,在onResume之后或onPause之后
        /*@Override
        public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
            Log.i(TAG, "onWindowFocusChanged called.");
        }*/

        //Activity被覆盖到下面或者锁屏时被调用
        @Override
        protected void onPause() {
            super.onPause();
            Log.i(TAG, "life2 onPause called.");
            //有可能在执行完onPause或onStop后,系统资源紧张将Activity杀死,所以有必要在此保存持久数据
        }

        //退出当前Activity或者跳转到新Activity时被调用
        @Override
        protected void onStop() {
            super.onStop();
            Log.i(TAG, "life2 onStop called.");
        }

        //退出当前Activity时被调用,调用之后Activity就结束了
        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i(TAG, "life2 onDestory called.");
        }
    }
}
