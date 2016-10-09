package com.clwater.littesee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.EventLog;
import android.util.Log;
import android.widget.ImageView;

import com.clwater.littesee.Utils.OkHttp_LS;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class MainActivity extends AppCompatActivity {
    private String TAG ="Little_See";

    @InjectView(R.id.ijimage)
    public ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
//        Log.d("gzb" , "Little_See");
//        RequestBody formBody = new FormBody.Builder()
//                .add("username", "1")
//                .add("password", "2")
//                .build();
//        Log.d("gzb" ,    OkHttp_LS.okhttp_post("http://120.27.53.146:5000/api/login" , formBody));
    }

}
