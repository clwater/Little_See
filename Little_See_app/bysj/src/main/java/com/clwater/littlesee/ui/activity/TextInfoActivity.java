package com.clwater.littlesee.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clwater.littlesee.R;
import com.clwater.littlesee.utils.Bean.DiaryBean;

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
    @BindView(R.id.textview_textinfo_titile)
    public TextView textview_textinfo_titile;
    @BindView(R.id.myScrolView)
    public com.clwater.littlesee.weight.MyScrollView myscrollview;
    @BindView(R.id.view_space)
    public View view_space;


    private int baseheight = 40;



    DiaryBean.DateBean diaryBean = new DiaryBean.DateBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);


        Intent intent =this.getIntent();
        diaryBean = (DiaryBean.DateBean) intent.getSerializableExtra("diary");

        init();

        initToolbar(diaryBean.getIndexclass());
        initImage(diaryBean.getImage());
        initTitle(diaryBean.getTitle());
        initWebView(diaryBean.getAddress());



    }




    private void init(){
        int defaultMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,baseheight,getResources().getDisplayMetrics());
        view_space.setLayoutParams(new LinearLayout.LayoutParams(view_space.getWidth() , defaultMargin));
        myscrollview.setOnScrollChangeListener(this);
    }
    private void initTitle(String title) {
        textview_textinfo_titile.setText(title);
    }

    private void initWebView(String address) {

        webview.loadUrl(address);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void initImage(String image) {
        Glide.with(this).load(image).into(title_image);
    }

    private void initToolbar(String indexclass) {
        toolbar.setTitle(indexclass);
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
        _y = _y / 4;
        baseheight = baseheight - _y;
        int defaultMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,baseheight,getResources().getDisplayMetrics());
        if (baseheight > 40 ){
            baseheight = 40;
        }

        if (baseheight <= 0){
            toolbar.setAlpha(0);
        }else {
            toolbar.setAlpha(1f);
        }
        //Log.d("gzb" , "" + _y);
        view_space.setLayoutParams(new LinearLayout.LayoutParams(view_space.getWidth() , defaultMargin));
    }

}
