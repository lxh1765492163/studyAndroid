package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;


//MainActivity实现接口OnClickListener ， MainActivity实例就是OnClickListener实例的意思
public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
    }





    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id){
            case R.id.button:
                Toast.makeText(this, "button", Toast.LENGTH_LONG).show();
                break;
            case R.id.button1:
                Toast.makeText(this, "button1", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Toast.makeText(this, "button2", Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                Toast.makeText(this, "销毁activity", Toast.LENGTH_LONG).show();
                this.finish();
                break;
            case R.id.button4:
                Toast.makeText(this, "显示跳转", Toast.LENGTH_LONG).show();
                //第一个参数为context  第二个为活动的acivity
                // Second.class什么意思
                Intent intent = new Intent(this, Second.class);
                startActivity(intent);
                break;
            case R.id.button5:

                //隐士跳转的作用 , 可以控制系统的一些其他的程序
                Toast.makeText(this, "隐士跳转", Toast.LENGTH_LONG).show();

                //隐士他跳转需要action 和 category都匹配中才能跳转 ， 否则会报错
                // 每个Intent只能指定一个action , 但是可以指定多个category
                Intent intent2 = new Intent("android.intent.action.Second");

                //category 默认 android.intent.category.DEFAULT
                // Intent指定category
                intent2.addCategory("android.intent.action.Second");

                startActivity(intent2);
                break;
            case R.id.button6:
                Toast.makeText(this, "隐士打开系统浏览器跳转", Toast.LENGTH_LONG).show();


                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse("https://www.cnblogs.com/"));
                startActivity(intent3);
                break;
            case R.id.button7:
                Toast.makeText(this, "隐士打开电话", Toast.LENGTH_LONG).show();


                Intent intent4 = new Intent(Intent.ACTION_DIAL);
                intent4.setData(Uri.parse("tel:10086"));
                startActivity(intent4);
                break;
            case R.id.button8:
                Toast.makeText(this, "", Toast.LENGTH_LONG).show();

                Intent intent5 = new Intent(this, Second.class);
                intent5.putExtra("value", "123456789");
                startActivity(intent5);
                break;
        }
    }




    /**
     * onCreateOptionsMenu创建的菜单 ， 入口是在标题栏右上角上的三个点
     * 菜单有待自定义 ！！！！！！！！！！！！！！！！！！！！！！！！！！！
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单每一项点击事件
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
           case R.id.add_item:
               Toast.makeText(MainActivity.this, "menu  add", Toast.LENGTH_LONG).show();
           break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "menu  remove", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}
