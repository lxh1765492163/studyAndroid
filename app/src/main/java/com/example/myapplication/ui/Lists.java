package com.example.myapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.component.MyList;
import com.example.myapplication.model.TestBean;


import java.util.ArrayList;
import java.util.List;


public class Lists extends BaseActivity{

    private List<TestBean> fruitList = new ArrayList<TestBean>();



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list);

        //初始化数据
        init();

        Log.d("aaaa", fruitList.toString());

        //渲染视图
        renderListView();


    }

    public void renderListView (){

        MyList myList = new MyList(Lists.this, R.layout.list_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(myList);

        //绑定事件
        addE();
    }


    //    添加事件
    public void addE (){
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TestBean fruit = fruitList.get(position);
                Toast.makeText(Lists.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void init(){
        for(int i = 0; i < 2; i++){
            fruitList.add(new TestBean("a", 20));
            fruitList.add(new TestBean("b", 21));
            fruitList.add(new TestBean("c", 22));
            fruitList.add(new TestBean("d", 23));
            fruitList.add(new TestBean("e", 24));
            fruitList.add(new TestBean("f", 25));
            fruitList.add(new TestBean("g", 26));
        }
    }



}
