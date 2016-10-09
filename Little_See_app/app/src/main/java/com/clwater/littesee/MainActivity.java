package com.clwater.littesee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class MainActivity extends AppCompatActivity {
    private String TAG ="Little_See";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Little_See" , "Little_See");

        okHttp_asynchronousGet();
    }

    private void okHttp_asynchronousGet(){
        try {
            Log.i(TAG,"main thread id is "+Thread.currentThread().getId());
            String url = "https://api.github.com/";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {

                }

                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    // 注：该回调是子线程，非主线程
                    Log.i(TAG,"callback thread id is "+Thread.currentThread().getId());
                    Log.i(TAG,response.body().string());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
