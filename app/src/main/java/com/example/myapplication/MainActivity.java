package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);


        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
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

        }
    }
}
