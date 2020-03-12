package com.mju.edu.coolweather;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
        intent.putExtra("weatherId", preferences.getString("LastCity","CN101230607"));
        startActivity(intent);
        finish();
    }
}
