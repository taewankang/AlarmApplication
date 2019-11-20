package com.example.mobile.alarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.mobile.R;

public class AddAlarm extends AppCompatActivity {
    ImageView monday_imageView, tuesday_imageView, wednesday_imageView, thursday_imageView, friday_imageView,
    saturday_imageView, sunday_imageView;
    boolean[] day_arr = new boolean[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        monday_imageView = (ImageView)findViewById(R.id.monday_imageView);
        tuesday_imageView = (ImageView)findViewById(R.id.tuesday_imageView);
        wednesday_imageView = (ImageView)findViewById(R.id.wednesday_imageView);
        thursday_imageView = (ImageView)findViewById(R.id.thursday_imageView);
        friday_imageView = (ImageView)findViewById(R.id.friday_imageView);
        saturday_imageView = (ImageView)findViewById(R.id.saturday_imageView);
        sunday_imageView = (ImageView)findViewById(R.id.sunday_imageView);
        for(int i=0; i<7; i++)
            day_arr[i] = false;
    }

    public void click_sunday(View view) {
        if(day_arr[0] == false)
            sunday_imageView.setVisibility(View.VISIBLE);
        else
            sunday_imageView.setVisibility(View.INVISIBLE);
        day_arr[0] = !day_arr[0];
    }

    public void click_monday(View view) {
        if (day_arr[1] == false)
            monday_imageView.setVisibility(View.VISIBLE);
        else
            monday_imageView.setVisibility(View.INVISIBLE);
        day_arr[1] = !day_arr[1];
    }

    public void click_saturday(View view) {
        if(day_arr[6] == false)
            saturday_imageView.setVisibility(View.VISIBLE);
        else
            saturday_imageView.setVisibility(View.INVISIBLE);
        day_arr[6] = !day_arr[6];
    }

    public void click_friday(View view) {
        if(day_arr[5] == false)
            friday_imageView.setVisibility(View.VISIBLE);
        else
            friday_imageView.setVisibility(View.INVISIBLE);
        day_arr[5] = !day_arr[5];
    }

    public void click_thursday(View view) {
        if(day_arr[4] == false)
            thursday_imageView.setVisibility(View.VISIBLE);
        else
            thursday_imageView.setVisibility(View.INVISIBLE);
        day_arr[4] = !day_arr[4];
    }

    public void click_wednesday(View view) {
        if(day_arr[3] == false)
            wednesday_imageView.setVisibility(View.VISIBLE);
        else
            wednesday_imageView.setVisibility(View.INVISIBLE);
        day_arr[3] = !day_arr[3];
    }

    public void click_tuesday(View view) {
        if(day_arr[2] == false)
            tuesday_imageView.setVisibility(View.VISIBLE);
        else
            tuesday_imageView.setVisibility(View.INVISIBLE);
        day_arr[2] = !day_arr[2];
    }

    public void cancel(View view) {
        finish();
    }

    public void save(View view) {

    }

    public void Dialog_calendar(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());
    }
}
