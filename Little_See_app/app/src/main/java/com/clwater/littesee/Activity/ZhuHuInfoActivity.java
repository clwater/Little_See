package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static java.security.AccessController.getContext;

/**
 * Created by gengzhibo on 16/10/11.
 */

public class ZhuHuInfoActivity  extends BaseWebActivity{

    @InjectView(R.id.mv_toolbar)
    public Toolbar toolbar;
    @InjectView(R.id.zh_info_image)
    public ImageView title_image;
    @InjectView(R.id.zh_SV_space)
    public TextView zh_SV_space;
    @InjectView(R.id.zh_info_web)
    public WebView webview;


    boolean pd = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihuinfo);
        ButterKnife.inject(this);

        activity = this;

        initTitle();
        initNavigation();
        initUI();
        initWebView();


    }

    private void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        //settings.setUseWideViewPort(true);造成文字太小
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCachePath(getCacheDir().getAbsolutePath() + "/webViewCache");
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.setWebChromeClient(new WebChromeClient());

        //webview.loadDataWithBaseURL();

        webview.loadUrl("http://daily.zhihu.com/story/8874308");



        webview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url)
            {
//                String fun="javascript:alert(\"aaa\") ";
//                view.loadUrl(fun);


                if (pd == true) {



//                    final String insertJavaScript = "javascript:window.onload=function(){ " +
//                            "document.getElementsByClassName('img-wrap')[0].style.display='none'; " +
//                            "document.getElementsByClassName('img-wrap')[0].style.display='none';}";
//
//                    webview.loadUrl(insertJavaScript);
                     webview.loadUrl("javascript:document.getElementsByClassName(\"img-wrap\").style.width=\"20px\";");
                    webview.loadUrl("javascript:alert(\"aaaa\")");
                    Logger.d("11111");


//                   // String fun2 = "javascript:alert(\"aaaaa\")";
//
//                    String fun2 = "javascript:\n" +
//                            "var aaaa = document.getElementsByClassName(\"img-wrap\"); alert(aaaa)\n" ;
//
//                    // String fun2 = "javascript:document.getElementsByClassName(\"img-wrap\").style.visibility='hidden'";
//                    view.loadUrl(fun2);
//
//                    //Logger.d("2");
                    pd = false;
                }



                super.onPageFinished(view, url);
            }
        });



    }




    private void initUI() {
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();


        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) title_image.getLayoutParams();
        relativeParams.height = height * 4  / 10;
        title_image.setLayoutParams(relativeParams);

        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) zh_SV_space.getLayoutParams();
        linearParams.height = height * 4  / 10;
        zh_SV_space.setLayoutParams(linearParams);



        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ZhuHuInfoActivity.this));
        ImageLoader.getInstance().displayImage("https://avatars3.githubusercontent.com/u/14257964?v=3&s=466",title_image, AppConfig.imageOptions());

    }

    private void initNavigation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

    private void initTitle() {
        toolbar.setTitle("知乎日报");
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_nv);
        ab.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
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
