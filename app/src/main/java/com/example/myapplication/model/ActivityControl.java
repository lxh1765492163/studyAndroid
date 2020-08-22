package com.example.myapplication.model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户控制所以的activity随时进行退出等操作
 */
public class ActivityControl {
    public static List<Activity> activitys = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activitys.add(activity);
    }

    public static void removeActivity(Activity activity){
        activitys.remove(activity);
    }

    public static void finshAll(){
        for(Activity activity:activitys ){
            //将List中活动的activity都关闭
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

