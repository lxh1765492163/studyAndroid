package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
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
