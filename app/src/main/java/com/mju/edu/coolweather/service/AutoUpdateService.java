package com.mju.edu.coolweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.mju.edu.coolweather.WeatherActivity;

public class AutoUpdateService extends Service {
    private LocalBroadcastManager manager;
    public AutoUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
//        preferences.getString("LastCity", "CN101230607")
        Log.e("autoupdateservice","服务启动");
        manager=LocalBroadcastManager.getInstance(this);
        Intent intent1=new Intent("com.mju.edu.coolweather.LOCAL_BROADCAST");
        manager.sendBroadcast(intent);
        AlarmManager manager= (AlarmManager) getSystemService(ALARM_SERVICE);
        int gap=1000*10;
        long triggerTime= SystemClock.elapsedRealtime()+gap;
        Intent i=new Intent(this,AutoUpdateService.class);
        PendingIntent pi=PendingIntent.getService(this,0,i,0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }
}
