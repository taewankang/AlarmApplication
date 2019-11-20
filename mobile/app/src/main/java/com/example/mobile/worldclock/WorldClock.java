package com.example.mobile.worldclock;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mobile.R;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorldClock extends Fragment {
    TextView current_time_textView;
    DateFormat hour_min = new SimpleDateFormat("HH:mm");
    DateFormat noon = new SimpleDateFormat("a");
    String time_string = "", noon_string = "";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.world_clock, container, false);
        current_time_textView = (TextView)view.findViewById(R.id.current_time_textView);
        time_string = hour_min.format(Calendar.getInstance().getTime());
        noon_string = noon.format(Calendar.getInstance().getTime());
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        String current_time = "현지 시각\n" + noon_string + " " + time_string + "\n";
        current_time_textView.setText(current_time);
    }
}
