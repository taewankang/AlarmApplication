package com.example.mobile.alarm;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.mobile.R;

public class Alarm extends Fragment {
    Button add, more;
    public View onCreateView(LayoutInflater inflate, ViewGroup container, Bundle savedinstanceState){
        View view = inflate.inflate(R.layout.alarm, container, false);
        add = (Button)view.findViewById(R.id.add);
        more = (Button)view.findViewById(R.id.more);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddAlarm.class);
                startActivityForResult(intent, 0);
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
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

    }
}
