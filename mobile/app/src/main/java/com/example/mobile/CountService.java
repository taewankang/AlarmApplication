package com.example.mobile;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CountService extends Service {
    private Thread thread;
    private DateFormat noon = new SimpleDateFormat("a");
    private DateFormat hour = new SimpleDateFormat("HH");
    private DateFormat minute = new SimpleDateFormat("mm");
    private DateFormat second = new SimpleDateFormat("ss");
    int time;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);
        if(noon.format(Calendar.getInstance().getTime()) == "오후")
            time += 43200;
        time += Integer.parseInt(hour.format(Calendar.getInstance().getTime())) * 3600;
        time += Integer.parseInt(minute.format(Calendar.getInstance().getTime())) * 60;
        time += Integer.parseInt(second.format(Calendar.getInstance().getTime()));

        if(thread == null){
            thread = new Thread("counting"){
              public void run(){
                  while(true){
                      Log.d("superdroid", "time: " + time + "");
                      time++;
                      try{
                          Thread.sleep(1000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
            };
        }

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
