package com.example.mobile.alarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.mobile.R;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import static android.app.DatePickerDialog.*;
import static java.lang.Integer.parseInt;

public class AddAlarm extends AppCompatActivity {
    ImageView monday_imageView, tuesday_imageView, wednesday_imageView, thursday_imageView, friday_imageView,
    saturday_imageView, sunday_imageView;
    boolean[] day_arr = new boolean[7];
    LocalDate localDate = LocalDate.now();
    int current_year;
    int current_month;
    int current_day;
    TextView today;
    String today_text = "", selected_day_string = "";
    String[] minute_arr =new String[60];
    NumberPicker noon, hour, minute;
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
        today = (TextView)findViewById(R.id.today);

        current_year = localDate.getYear();
        current_month = localDate.getMonthValue();
        current_day = localDate.getDayOfMonth();
        today_text = "오늘-" + current_month + "월 " + current_day + "일";
        today.setText(today_text);

        noon = (NumberPicker)findViewById(R.id.noon);
        hour = (NumberPicker)findViewById(R.id.hour);
        minute = (NumberPicker)findViewById(R.id.minute);

        noon.setDisplayedValues(new String[]{"오전", "오후"});
        noon.setMinValue(0);
        noon.setMaxValue(1);

        hour.setDisplayedValues(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
        hour.setMinValue(0);
        hour.setMaxValue(11);

        for(int i=0; i<60; i++){
            minute_arr[i] = Integer.toString(i);
        }
        minute.setDisplayedValues(minute_arr);
        minute.setMinValue(0);
        minute.setMaxValue(59);
        for(int i=0; i<7; i++)
            day_arr[i] = false;
    }

    public void click_sunday(View view) {
        if(day_arr[0] == false)
            sunday_imageView.setVisibility(View.VISIBLE);
        else
            sunday_imageView.setVisibility(View.INVISIBLE);
        day_arr[0] = !day_arr[0];
        selected_day();
    }

    public void click_monday(View view) {
        if (day_arr[1] == false)
            monday_imageView.setVisibility(View.VISIBLE);
        else
            monday_imageView.setVisibility(View.INVISIBLE);
        day_arr[1] = !day_arr[1];
        selected_day();
    }

    public void click_saturday(View view) {
        if(day_arr[6] == false)
            saturday_imageView.setVisibility(View.VISIBLE);
        else
            saturday_imageView.setVisibility(View.INVISIBLE);
        day_arr[6] = !day_arr[6];
        selected_day();
    }

    public void click_friday(View view) {
        if(day_arr[5] == false)
            friday_imageView.setVisibility(View.VISIBLE);
        else
            friday_imageView.setVisibility(View.INVISIBLE);
        day_arr[5] = !day_arr[5];
        selected_day();
    }

    public void click_thursday(View view) {
        if(day_arr[4] == false)
            thursday_imageView.setVisibility(View.VISIBLE);
        else
            thursday_imageView.setVisibility(View.INVISIBLE);
        day_arr[4] = !day_arr[4];
        selected_day();
    }

    public void click_wednesday(View view) {
        if(day_arr[3] == false)
            wednesday_imageView.setVisibility(View.VISIBLE);
        else
            wednesday_imageView.setVisibility(View.INVISIBLE);
        day_arr[3] = !day_arr[3];
        selected_day();
    }

    public void click_tuesday(View view) {
        if(day_arr[2] == false)
            tuesday_imageView.setVisibility(View.VISIBLE);
        else
            tuesday_imageView.setVisibility(View.INVISIBLE);
        day_arr[2] = !day_arr[2];
        selected_day();
    }

    public void cancel(View view) {
        finish();
    }

    public void save(View view) {

    }

    public void selected_day(){
        String str = "";
        if(day_arr[0] == true)
            str += "일, ";
        if(day_arr[1] == true)
            str += "월, ";
        if(day_arr[2] == true)
            str += "화, ";
        if(day_arr[3] == true)
            str += "수, ";
        if(day_arr[4] == true)
            str += "목, ";
        if(day_arr[5] == true)
            str += "금, ";
        if(day_arr[6] == true)
            str += "토, ";
        if(str.length() > 1)
            str = str.substring(0, str.length() - 2);
        if(str == "")
            today.setText(today_text);
        else
            today.setText(str);
    }

    public void Dialog_calendar(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new OnDateSetListener(){
            String date = "";
            @Override
           public void onDateSet(DatePicker view, int year, int month, int day){
                date = (month + 1) + "월 " + day + "일 ";
                today.setText(date);
            }
        }, current_year, current_month, current_day);
        datePickerDialog.show();
    }
}
