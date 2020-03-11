package com.mju.edu.coolweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        Map<String, ?> all = preferences.getAll();
        for (String key:all.keySet()){
            if(key.startsWith("CN")){
                Intent intent=new Intent(MainActivity.this,WeatherActivity.class);
                intent.putExtra("weatherId",key);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
