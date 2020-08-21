package com.example.myapplication.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.TestBean;

public class Three extends AppCompatActivity implements OnClickListener {
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
}
