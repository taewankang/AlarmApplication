package com.example.mobile;

import java.io.Serializable;

public class AlarmManage implements Serializable {
    private int noon, hour, min;
    private String memo, date;
    public AlarmManage(int noon, int hour, int min, String memo, String date){
        super();
        this.noon = noon;
        this.hour = hour;
        this.min = min;
        this.memo = memo;
        this.date = date;
    }

    public int getNoon(){return noon;}
    public int getHour(){return hour;}
    public int getMin(){return min;}
    public String getMemo(){return memo;}
    public String getDate(){return date;}
}
