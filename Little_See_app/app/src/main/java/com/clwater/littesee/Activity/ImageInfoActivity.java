package com.clwater.littesee.Activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.library.PhotoView;
import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.MainActivity;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.HttpUtils.OkHttp_LS;
import com.clwater.littesee.Utils.WebUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

//import android.support.annotation.Nullable;

/**
 * Created by gengzhibo on 16/10/11.
 */

public class ImageInfoActivity extends BaseWebActivity  {

    @InjectView(R.id._toolbar)
    public Toolbar toolbar;
    public PhotoView photoview_image_imageview;
    public String url;
    public String imageName;
    Activity _activity;
    public static PackageManager pm;
    public static final int PERMISSION_READ_STORAGE = 1005;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.inject(this);
        _activity = this;
        initTitle();
        initNavigation();

        Intent intent = getIntent();
        url = intent.getStringExtra("href");
        String[] _url = url.split("/");
        imageName = _url[_url.length - 1];

        initPhoto();
        pm = getPackageManager();

    }

    private void initTitle() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_back);
        ab.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.finish();
            }
        });
    }

    private void initPhoto() {
        photoview_image_imageview = (PhotoView) findViewById(R.id.photoview_image_imageview);
        photoview_image_imageview.enable();
        photoview_image_imageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {

                    boolean permission = (PackageManager.PERMISSION_GRANTED == ImageInfoActivity.pm.checkPermission("android.permission.READ_EXTERNAL_STORAGE", "com.clwater.littesee"));

                    ActivityCompat.requestPermissions(ImageInfoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_READ_STORAGE);

                    if (permission) {
                        Toast.makeText(MainActivity.context, "保存到本地了,可以在本地相册中看到", Toast.LENGTH_SHORT).show();
                        saveImage();
                    } else {
                        Toast.makeText(MainActivity.context, "你还没有授予读取SD卡读取文件的权限,请选择允许后重新长按图片保存", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    saveImage();
                }



                return false;
            }
        });
        photoview_image_imageview.setMaxScale(5);
        MainActivity.imageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.context));
        ImageLoader.getInstance().displayImage(url, photoview_image_imageview, AppConfig.imageOptions());

    }

    private void saveImage() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File directory = new File(externalStorageDirectory,"LittleSee");
        if (!directory.exists())
            directory.mkdir();
        BitmapDrawable mDrawable =  (BitmapDrawable) photoview_image_imageview.getDrawable();
        Bitmap drawingCache = ((BitmapDrawable) photoview_image_imageview.getDrawable()).getBitmap();

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


    private void initNavigation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }



}


