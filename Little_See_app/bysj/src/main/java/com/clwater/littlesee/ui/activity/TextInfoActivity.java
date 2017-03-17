package com.clwater.littlesee.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clwater.littlesee.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yszsyf on 17/3/17.
 */

public class TextInfoActivity  extends AppCompatActivity implements View.OnScrollChangeListener {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.imageview_textinfo_image)
    public ImageView title_image;
    @BindView(R.id.textview_sv_space)
    public TextView textview_sv_space;
    @BindView(R.id.webview_textinfo_web)
    public WebView webview;
//    @BindView(R.id.linerarlayout_ll)
//    public LinearLayout linearLayout;
    @BindView(R.id.textview_textinfo_titile)
    public TextView textview_textinfo_titile;
    @BindView(R.id.myScrolView)
    public com.clwater.littlesee.weight.MyScrollView myscrollview;
    @BindView(R.id.view_space)
    public View view_space;


    private int baseheight = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);


        initToolbar();
        initImage();
        initTitle();
        initWebView();
        init();
    }


    private void init(){
        myscrollview.setOnScrollChangeListener(this);
    }
    private void initTitle() {
        textview_textinfo_titile.setText("ttitititititi");
    }

    private void initWebView() {

        webview.loadUrl("https://www.baidu.com/s?wd=%E5%B0%8F%E8%AF%B4&rsv_spt=1&rsv_iqid=0xb187e3ac0004a2a9&issp=1&f=3&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=8&rsv_sug1=4&rsv_sug7=100&rsv_sug2=0&prefixsug=xiaosh&rsp=0&inputT=2702&rsv_sug4=3890");

        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void initImage() {
        Glide.with(this).load("http://pic1.zhimg.com/57dcafd1593d396423b88f0a6c4fdae4.jpg").into(title_image);
    }

    private void initToolbar() {
        toolbar.setTitle("asdasd");
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

    @Override
    public void onScrollChange(View v, int x, int y, int oldx, int oldy) {
        int _y = y - oldy;  //项下划动时 _y > 0

        Log.d("gzb" , "" + _y);
        view_space.setLayoutParams(new LinearLayout.LayoutParams(view_space.getWidth() , 0));


    }




}
