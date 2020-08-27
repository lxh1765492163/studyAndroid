package com.example.myapplication.model;

public class ChartMsg {

    private String content;
    private int type;

    public static final int SEND = 0;
    public static final int RECEIVED = 1;

    public ChartMsg(String content, int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }
}
