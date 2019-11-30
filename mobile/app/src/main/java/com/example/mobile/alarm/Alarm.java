package com.example.mobile.alarm;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.mobile.AlarmManage;
import com.example.mobile.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static android.content.Context.MODE_PRIVATE;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.view.View.inflate;

public class Alarm extends Fragment {
    private final int ADDALARM = 0;
    private final int RESULT_OK = -1;
    Button add, more, alarm_add_button;
    TextView alarm_textView;
    LinearLayout add_button_linearLayout, linearLayout;
    List<AlarmManage> list = new ArrayList<>();
    Context context;
    View view2;
//    SharedPreferences sharedPreferences;

    public View onCreateView(LayoutInflater inflate, ViewGroup container, Bundle savedinstanceState){
        View view = inflate.inflate(R.layout.alarm, container, false);
        add = (Button)view.findViewById(R.id.add);
        more = (Button)view.findViewById(R.id.more);
        alarm_textView = (TextView)view.findViewById(R.id.alarm_textView);
        add_button_linearLayout = (LinearLayout)view.findViewById(R.id.add_button_linearLayout);
        linearLayout = (LinearLayout)view.findViewById(R.id.linearlayout);
        alarm_add_button = (Button)view.findViewById(R.id.alarm_add_button);
        context = container.getContext();
//        sharedPreferences = context.getSharedPreferences("Alarm", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();

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
        for(AlarmManage alarmManage : list){
            add_list(alarmManage.getNoon(), alarmManage.getHour(), alarmManage.getMin(), alarmManage.getMemo(), alarmManage.getDate());
        }
        if(list.size() == 0){
            alarm_textView.setVisibility(GONE);
            add.setVisibility(GONE);
            add_button_linearLayout.setVisibility(VISIBLE);
        }else{
            add.setVisibility(VISIBLE);
            add_button_linearLayout.setVisibility(GONE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(list.size() != 0)
            linearLayout.removeAllViews();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    public void addAlarm(){
        Intent intent = new Intent(getContext(), AddAlarm.class);
        startActivityForResult(intent, ADDALARM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADDALARM){
            if(resultCode == RESULT_OK) {
                int noon = data.getIntExtra("noon", 0); //오전, 오후
                int hour = data.getIntExtra("hour", 0) + 1; //시간 설정
                int min = data.getIntExtra("minute", 0); //분 설정
                String memo = data.getStringExtra("memo");          //memo 설정
                String today = data.getStringExtra("today");        //선택 요일 / 날짜 설정

                AlarmManage alarmManage = new AlarmManage(noon, hour, min, memo, today);
                list.add(alarmManage);

            }
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
        list.sort(new Comparator<AlarmManage>(){
            @Override
            public int compare(AlarmManage alarmManage1, AlarmManage alarmManage2){
                if(alarmManage1.getLeftTime() < alarmManage2.getLeftTime())
                    return 1;
                else if(alarmManage1.getLeftTime() == alarmManage2.getLeftTime())
                    return 0;
                else
                    return -1;
            }
        });
    }

    public void getLeftTime(){

    }
}
