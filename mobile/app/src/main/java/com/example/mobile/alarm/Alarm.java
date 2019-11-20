package com.example.mobile.alarm;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.mobile.R;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Alarm extends Fragment {
    Button add, more, alarm_add_button;
    TextView alarm_textView;
    LinearLayout linearLayout;
    List<String> list = new ArrayList<>();
    public View onCreateView(LayoutInflater inflate, ViewGroup container, Bundle savedinstanceState){
        View view = inflate.inflate(R.layout.alarm, container, false);
        add = (Button)view.findViewById(R.id.add);
        more = (Button)view.findViewById(R.id.more);
        alarm_textView = (TextView)view.findViewById(R.id.alarm_textView);
        linearLayout = (LinearLayout)view.findViewById(R.id.linearLayout);
        alarm_add_button = (Button)view.findViewById(R.id.alarm_add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAlarm();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setMessage("삭제");
                alertDialog.setMessage("추가");
            }
        });

        alarm_add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addAlarm();
            }
        });
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        if(list.size() == 0){
            alarm_textView.setVisibility(GONE);
            add.setVisibility(GONE);
        }else{
            add.setVisibility(VISIBLE);
            linearLayout.setVisibility(GONE);
        }
    }

    public void addAlarm(){
        Intent intent = new Intent(getContext(), AddAlarm.class);
        startActivityForResult(intent, 0);
    }
}
