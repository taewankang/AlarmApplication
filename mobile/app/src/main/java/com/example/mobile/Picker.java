package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;

public class Picker extends AppCompatActivity {
    NumberPicker numberPicker;
    String[] noon = new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        noon[0] = "오전"; noon[1] = "오후";
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(1);
        numberPicker.setDisplayedValues(noon);

    }
}
