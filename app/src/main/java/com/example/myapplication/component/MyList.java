package com.example.myapplication.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.TestBean;

import java.util.List;

public class MyList extends ArrayAdapter<TestBean> {
    private int resourceId;
    public MyList(Context context, int textViewResourceId, List<TestBean> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        TestBean testBean = getItem(position); //获取当前TestBean实例

        //在xml 转换为view对象时 ， LyoutInflater
        View view;
        ViewHolder viewHolder;
        //onvertView 参数，这个参数用于将之前加载喊得布局进行缓存，以便之后可以进行重用
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.age = (TextView) view.findViewById(R.id.fruit_image);
            viewHolder.name = (TextView) view.findViewById(R.id.fruit_name);

            view.setTag(viewHolder);
        } else {
            view = convertView;


            //为什么需要强制转 ， 怎么查看当前返回的是个什么类型的数据
            viewHolder = (ViewHolder) view.getTag();
        }

        int age = testBean.getAge();
        String name = testBean.getName();

        viewHolder.age.setText(""+age);
        viewHolder.name.setText(name);


        return view;
    }


    class ViewHolder {
        TextView age;
        TextView name;
    }
}
