package com.clwater.littesee.Utils;

import android.util.Log;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;



/**
 * Created by gengzhibo on 16/10/9.
 */

public class OkHttp_LS {

    private String TAG ="Little_See";
    private static String result;

    public static String okhttp_get(String url){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    result = "ok http  get error";
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    result = response.body().string();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            result = "ok http  get error";
        }finally {
            return result;
        }
    }

    public static String okhttp_post(String url, RequestBody formBody) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).post(formBody).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    result = "ok http  post error";
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    result = response.body().string();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            result = "ok http  post error";
        }finally {
            return result;
        }
    }


}
