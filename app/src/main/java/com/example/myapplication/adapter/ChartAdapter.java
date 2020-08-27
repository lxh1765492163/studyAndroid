package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.myapplication.R;
import com.example.myapplication.model.ChartMsg;

import java.util.List;

public class ChartAdapter extends ArrayAdapter<ChartMsg> {
    private int resourceId;
    public ChartAdapter(Context context, int textViewResourceId, List<ChartMsg> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // ArrayAdapter<ChartMsg>  必须在类的后面加泛型？？？？？？？？？？？？？
        ChartMsg chartMsg = getItem(position);

        //在xml 转换为view对象时 ， LyoutInflater
        View view;
        ChartAdapter.ViewHolder viewHolder;
        //onvertView 参数，这个参数用于将之前加载喊得布局进行缓存，以便之后可以进行重用
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            viewHolder = new ChartAdapter.ViewHolder();
            viewHolder.leftContent = view.findViewById(R.id.chart_left);
            viewHolder.rightContent = view.findViewById(R.id.chart_right);
            viewHolder.leftLayout = view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = view.findViewById(R.id.right_layout);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            //为什么需要强制转 ， 怎么查看当前返回的是个什么类型的数据
            viewHolder = (ChartAdapter.ViewHolder) view.getTag();
        }


        if( chartMsg.getType() == ChartMsg.SEND){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftContent.setText(chartMsg.getContent());

        }else if(chartMsg.getType() == ChartMsg.RECEIVED){
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightContent.setText(chartMsg.getContent());
        }

        return view;
    }

    class ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftContent;
        TextView rightContent;

    }
}
