package com.example.myapplication.component;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.example.myapplication.R;




public class Title extends LinearLayout implements OnClickListener {
    public  Title (Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);


        TextView back = findViewById(R.id.title_back);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.title_back:
                //返回 ????????????????????????????????????????
                ((Activity) getContext()).finish();
                break;
        }
    }
}
