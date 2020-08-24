package com.example.myapplication.component;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class AlertLog {


    public static void show(Activity activity){
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle("警告");
        dialog.setMessage("不要偷懒");

        dialog.setCancelable(false);
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog.show();
    }
}
