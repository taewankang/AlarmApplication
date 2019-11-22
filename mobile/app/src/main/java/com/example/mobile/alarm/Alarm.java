package com.example.mobile.alarm;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
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
import static android.view.View.inflate;

public class Alarm extends Fragment {
    Button add, more, alarm_add_button;
    TextView alarm_textView;
    LinearLayout add_button_linearLayout, linearLayout;
    List<String> list = new ArrayList<>();
    Context context;
    View view2;
    public View onCreateView(LayoutInflater inflate, ViewGroup container, Bundle savedinstanceState){
        View view = inflate.inflate(R.layout.alarm, container, false);
        add = (Button)view.findViewById(R.id.add);
        more = (Button)view.findViewById(R.id.more);
        alarm_textView = (TextView)view.findViewById(R.id.alarm_textView);
        add_button_linearLayout = (LinearLayout)view.findViewById(R.id.add_button_linearLayout);
        linearLayout = (LinearLayout)view.findViewById(R.id.linearlayout);
        alarm_add_button = (Button)view.findViewById(R.id.alarm_add_button);
        context = container.getContext();
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
                alertDialog.show();
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
        view2 = getView();
        if(list.size() == 0){
            alarm_textView.setVisibility(GONE);
//            add.setVisibility(GONE);
        }else{
            add.setVisibility(VISIBLE);
//            add_button_linearLayout.setVisibility(GONE);
        }
    }

    public void addAlarm(){
        Intent intent = new Intent(getContext(), AddAlarm.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            add_button_linearLayout.setVisibility(GONE);
            add.setVisibility(VISIBLE);
            int noon = data.getIntExtra("noon", 0);
            int hour = data.getIntExtra("hour", 0);
            int min = data.getIntExtra("minute", 0);
            String memo = data.getStringExtra("memo");
            String today = data.getStringExtra("today");
            add_list(noon, hour, min, memo, today);
            add.setVisibility(VISIBLE);
        }
    }

    public void add_list(int noon, int hour, int min, String memo, String date){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        view2 = layoutInflater.inflate(R.layout.alarm_list, null, false);
        TextView alarm_list_time = (TextView)view2.findViewById(R.id.time);
        TextView alarm_list_noon = (TextView)view2.findViewById(R.id.noon);
        TextView alarm_list_memo = (TextView)view2.findViewById(R.id.memo);
        TextView alarm_list_date = (TextView)view2.findViewById(R.id.date);
        if(noon == 0)
            alarm_list_noon.setText("오전");
        else
            alarm_list_noon.setText("오후");
        alarm_list_time.setText(hour + " : " + min);
        alarm_list_memo.setText(memo);
        alarm_list_date.setText(date);

        alarm_list_time.setGravity(Gravity.CENTER_VERTICAL);
        alarm_list_noon.setGravity(Gravity.CENTER_VERTICAL);
        alarm_list_memo.setGravity(Gravity.CENTER_VERTICAL);
        alarm_list_date.setGravity(Gravity.CENTER_VERTICAL);

        params.bottomMargin=50;
        view2.setLayoutParams(params);
        linearLayout.addView(view2);
    }
}
