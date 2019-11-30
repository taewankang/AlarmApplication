package com.example.mobile.worldclock;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mobile.R;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorldClock extends Fragment {
    private static final int RESULT_OK = -1;
    private final int AddWorldClock = 1;
    TextView current_time_textView;
    DateFormat hour_min = new SimpleDateFormat("HH:mm");
    DateFormat noon = new SimpleDateFormat("a");
    Button add;
    String time_string = "", noon_string = "";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.world_clock, container, false);
        current_time_textView = (TextView)view.findViewById(R.id.current_time_textView);
        time_string = hour_min.format(Calendar.getInstance().getTime());
        noon_string = noon.format(Calendar.getInstance().getTime());
        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WorldClockSelect.class);
                startActivityForResult(intent, AddWorldClock);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == AddWorldClock){
            if(resultCode == RESULT_OK) {
                Log.d("superdroid", "back");
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        String current_time = "현지 시각\n" + noon_string + " " + time_string + "\n";
        current_time_textView.setText(current_time);
    }
}
