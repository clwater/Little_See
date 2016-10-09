package com.clwater.littesee;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.EventLog;
import android.util.Log;
import android.widget.ImageView;

import com.clwater.littesee.Utils.EventBus.EventBus_test;
import com.clwater.littesee.Utils.OkHttp_LS;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private String TAG ="Little_See";

    @InjectView(R.id.ijimage)
    public ImageView ijimage;

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
        InputStream image =OkHttp_LS.okhttp_getImage("https://avatars3.githubusercontent.com/u/14257964?v=3&s=466");

        saveimage(image);

    }

    private void saveimage(InputStream image) {
        InputStream is = null;
        FileOutputStream fos = null;
        byte[] buffer = new byte[1024];
        int lenght = 0;
        File f=new File("a.jpg");
        inputstreamtofile(is, f);
        EventBus.getDefault().post(new EventBus_test() );

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowDataEvent(EventBus_test EventBus_test) {
        String path= "a.jpg";
        Bitmap bm = BitmapFactory.decodeFile(path);
        ijimage.setImageBitmap(bm);//不会变形

    }

    public static void inputstreamtofile(InputStream ins,File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestory(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);


    }

}
