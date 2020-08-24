package com.example.myapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.TestBean;

//MainActivity实现接口OnClickListener ， MainActivity实例就是OnClickListener实例的意思
public class MainActivity extends BaseActivity implements OnClickListener {

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
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
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
            case R.id.button9:
                Toast.makeText(this, "返回且传值到首页", Toast.LENGTH_LONG).show();

                Intent intent6 = new Intent(this, Three.class);
                startActivityForResult(intent6, 1);

                break;
            case R.id.button10:
                Toast.makeText(this, "生命周期", Toast.LENGTH_LONG).show();

                Intent intent7 = new Intent(this, LifeActivity.class);
                startActivity(intent7);

                break;
            case R.id.button11:
                Toast.makeText(this, "ui练习", Toast.LENGTH_LONG).show();

                Intent intent8= new Intent(this, UiActivity.class);
                startActivity(intent8);

                break;
            case R.id.button12:
                Intent intent9= new Intent(this, Login.class);
                startActivity(intent9);

                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) return;
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");

                    //注意强转下类型
                    TestBean returnData2 = (TestBean) data.getSerializableExtra("data_return2");

                    Toast.makeText(this, returnData2.toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(this, returnData, Toast.LENGTH_LONG).show();
                }
                break;

        }
    }


    /**
     * onCreateOptionsMenu创建的菜单 ， 入口是在标题栏右上角上的三个点
     * 菜单有待自定义 ！！！！！！！！！！！！！！！！！！！！！！！！！！！
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单每一项点击事件
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
