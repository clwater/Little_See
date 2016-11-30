package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
                Toast.makeText(MainActivity.context, "保存到本地了,可以在本地相册中看到", Toast.LENGTH_SHORT).show();
                //saveImage(imageName);
                return false;
            }
        });
        photoview_image_imageview.setMaxScale(5);
        MainActivity.imageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.context));
        ImageLoader.getInstance().displayImage(url, photoview_image_imageview, AppConfig.imageOptions());

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


