package com.example.myapplication.ui;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class Second extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent =getIntent();
        String msg=intent.getStringExtra("value");

        //有值就设置文字 ， 没有就不设置 ， 待优化！！！！！！！！！！！！！！！！！！！！！！！！
        TextView tvTest = findViewById(R.id.text_value);
        tvTest.setText(msg);

    }
}
