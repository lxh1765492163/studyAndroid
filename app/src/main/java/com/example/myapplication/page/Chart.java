package com.example.myapplication.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ChartAdapter;
import com.example.myapplication.model.ChartMsg;
import com.example.myapplication.ui.BaseActivity;
import com.example.myapplication.ui.Lists;

import java.util.ArrayList;
import java.util.List;



public class Chart extends BaseActivity {

    private List<ChartMsg> arr = new ArrayList<ChartMsg>();
    private ChartAdapter chartAdapter;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);


        initChartMsg();
        initList();

        initSend();

    }




    /**
     *
     */
    public void initChartMsg(){
        arr.add(new ChartMsg("how are you", 0));
        arr.add(new ChartMsg("how are you", 0));
        arr.add(new ChartMsg("yes i d", 1));
    }



    /**
     *
     */
    public void initList(){

        chartAdapter = new ChartAdapter(Chart.this, R.layout.chartitem, arr );
        listview = findViewById(R.id.chart_list);
        listview.setAdapter(chartAdapter);

    }

    public void initSend(){
        Button button = findViewById(R.id.send_msg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMsg();
            }
        });
    }


    public void getMsg (){
        EditText editText = findViewById(R.id.edit_msg);
        String value = editText.getText().toString();


        if( !TextUtils.isEmpty(value)  ){
            arr.add(new ChartMsg(value, 0));

            editText.setText("");

            listview.setAdapter(chartAdapter);
        }

    }

}
