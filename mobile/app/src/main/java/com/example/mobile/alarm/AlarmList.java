package com.example.mobile.alarm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mobile.R;

import java.util.zip.Inflater;

public class AlarmList extends AppCompatActivity {
    @Override
    public void onCreate(Bundle onInstanceState){
        super.onCreate(onInstanceState);
        setContentView(R.layout.alarm_list);

    }
}
