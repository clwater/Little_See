package com.clwater.littlesee.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yszsyf on 17/3/16.
 */

public class OkHttpUtils {

    public static String okhttp_get(String url) {
        OkHttpClient client = new OkHttpClient();
        String result = "";

        try {
            result = run(url , client);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    static String run(String url , OkHttpClient client) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


}