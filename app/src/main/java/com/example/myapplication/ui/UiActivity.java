package com.example.myapplication.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.component.AlertLog;

import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class UiActivity extends BaseActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ui);

        EditText edit = findViewById(R.id.edit);
        setImg();

        //绑定事件
        findViewById(R.id.get_edit).setOnClickListener(this);
        findViewById(R.id.none_loading).setOnClickListener(this);
        findViewById(R.id.add_loading).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);


    }






    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.get_edit:
                EditText edit = findViewById(R.id.edit);
                String value = edit.getText().toString();

                Toast.makeText(this, value, Toast.LENGTH_LONG).show();
            break;
            case R.id.none_loading:
                ProgressBar progressBar = findViewById(R.id.loading);
                if( progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
                break;

            case R.id.add_loading:
                ProgressBar progressBar1 = findViewById(R.id.loading2);
                int num = progressBar1.getProgress();
                num = num+10;
                progressBar1.setProgress(num);
                break;
            case R.id.button12:
                AlertLog.show(this);
                break;


         }

    }

    void setImg(){
        //图片资源
        String url = "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690";
        Bitmap bitmap = getHttpBitmap(url);

        ImageView imageView = (ImageView)findViewById(R.id.img);
        imageView.setImageBitmap(bitmap);
    }

    /**
     * 获取网落图片资源
     * @param url
     * @return
     */
    public static Bitmap getHttpBitmap(String url){
        URL myFileURL;
        Bitmap bitmap=null;
        try{
            myFileURL = new URL(url);
            //获得连接
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
            conn.setConnectTimeout(6000);
            //连接设置获得数据流
            conn.setDoInput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //这句可有可无，没有影响
            //conn.connect();
            //得到数据流
            InputStream is = conn.getInputStream();
            //解析得到图片
            bitmap = BitmapFactory.decodeStream(is);
            //关闭数据流
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return bitmap;

    }
}
