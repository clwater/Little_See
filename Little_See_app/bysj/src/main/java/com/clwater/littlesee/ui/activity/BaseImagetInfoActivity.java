package com.clwater.littlesee.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.clwater.littlesee.R;
import com.clwater.littlesee.eventbus.EventBus_RunInBack;
import com.clwater.littlesee.eventbus.EventBus_RunInFront;
import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.clwater.littlesee.utils.Bean.ImageBean;
import com.clwater.littlesee.utils.Bean.NewsBean;
import com.clwater.littlesee.utils.OkHttpUtils;
import com.clwater.littlesee.utils.WebUtils;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yszsyf on 17/3/17.
 */

public class BaseImagetInfoActivity extends AppCompatActivity  {

    @BindView(R.id.toolbar) public Toolbar toolbar;

    @BindView(R.id.image_imageinfo_image) ImageView image_imageinfo_image;



    String _indexclass, _text, _address;
    public static PackageManager pm;
    public static final int PERMISSION_READ_STORAGE = 1005;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        Intent intent = this.getIntent();
        if (intent.getStringExtra("index").equals("image")) {
            ImageBean.DateBean imageBean = new ImageBean.DateBean();
            imageBean = (ImageBean.DateBean) intent.getSerializableExtra("class");
            _indexclass = imageBean.getIndexclass();
            _address = imageBean.getAddress();
            _text = imageBean.getText();
        }

        initTitle(_indexclass);
        initImage(_address);
        pm = getPackageManager();

    }

    private void initTitle(String indexclass) {
        toolbar.setTitle(indexclass);
    }

    private void initImage(String address) {
        address = address + "_1920x1200.jpg";
        Glide.with(this).load(address).into(image_imageinfo_image);


        image_imageinfo_image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {

                    boolean permission = (PackageManager.PERMISSION_GRANTED == pm.checkPermission("android.permission.READ_EXTERNAL_STORAGE", "com.clwater.littlesee"));

                    ActivityCompat.requestPermissions(BaseImagetInfoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_READ_STORAGE);

                    if (permission) {
                        Toast.makeText(BaseImagetInfoActivity.this, "保存到本地了,可以在本地相册中看到", Toast.LENGTH_SHORT).show();
                        saveImage();
                    } else {
                        Toast.makeText(BaseImagetInfoActivity.this, "你还没有授予读取SD卡读取文件的权限,请选择允许后重新长按图片保存", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    saveImage();
                }



                return false;
            }
        });

    }


    private void saveImage() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File directory = new File(externalStorageDirectory,"LittleSee");
        if (!directory.exists())
            directory.mkdir();
//        BitmapDrawable mDrawable = (BitmapDrawable) image_imageinfo_image.getDrawable();


//        Bitmap drawingCache = mDrawable.getBitmap();
        Bitmap drawingCache = ((GlideBitmapDrawable)image_imageinfo_image.getDrawable().getCurrent()).getBitmap();

        try {
            File file = new File(directory, new Date().getTime() + ".jpg");
            //File file = new File(directory,  "a.jpg");
            FileOutputStream fos = new FileOutputStream(file);
            drawingCache.compress(Bitmap.CompressFormat.JPEG,100,fos);
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            getApplicationContext().sendBroadcast(intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("gzb" , "saveimage error");
        }
    }
}




