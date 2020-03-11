package com.mju.edu.coolweather.utils;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
//        Log.e("httputil",address);
        OkHttpClient client=new OkHttpClient();
//        Log.e("httputil",client.toString());
        Request request=new Request.Builder().url(address).build();
//        Log.e("httputil",request.toString());
        client.newCall(request).enqueue(callback);

    }
}
