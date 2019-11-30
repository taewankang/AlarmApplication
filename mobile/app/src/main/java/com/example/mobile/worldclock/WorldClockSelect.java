package com.example.mobile.worldclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mobile.R;

public class WorldClockSelect extends AppCompatActivity {
    Spinner continent, country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_clock_select);
        continent = (Spinner)findViewById(R.id.continent);
        country = (Spinner)findViewById(R.id.country);
        String continent_name = continent.getSelectedItem().toString();
        continent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] country_array;
                if(i == 1){
                    country_array = getResources().getStringArray(R.array.europe);
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_world_clock_select, country_array);
                    country.setAdapter(arrayAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("superdroid", "country: " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("superdroid", "onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("superdroid", "onPause");
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED);
        finish();
    }

    public void cancel(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED);
        finish();
    }

    public void save(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK);
        finish();
    }
}
