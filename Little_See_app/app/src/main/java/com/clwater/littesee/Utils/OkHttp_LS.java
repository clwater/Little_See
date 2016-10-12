package com.clwater.littesee.Utils;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;



/**
 * Created by gengzhibo on 16/10/9.
 */

public class OkHttp_LS {

    private String TAG ="Little_See";
    private static String result_get;
    private static String result_post;
    private static InputStream result_image;

    public static String okhttp_get(String url){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    result_get = "ok http  get error";
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    result_get = response.body().string();
                }
            });
        } catch (Exception e) {
            result_get = "ok http  get error";
        }
        return  result_get;
    }

    public static String okhttp_post(String url, RequestBody formBody) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).post(formBody).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    result_post = "ok http  post error";
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    result_post = response.body().string();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            result_post = "ok http  post error";
        }

        return result_post;

    }


    public static InputStream okhttp_getImage(String url){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    result_image = null;
                }
                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    result_image = response.body().byteStream();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            result_image = null;
        }
        return result_image;

    }


}
