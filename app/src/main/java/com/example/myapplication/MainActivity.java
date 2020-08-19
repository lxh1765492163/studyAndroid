package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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


        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
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

        }
    }




    /**
     * onCreateOptionsMenu创建的菜单 ， 入口是在标题栏右上角上的三个点
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
