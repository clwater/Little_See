package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.Gravity;
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
import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.OkHttp_LS;
import com.clwater.littesee.Utils.WebUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by gengzhibo on 16/10/11.
 */

public class ZhuHuInfoActivity  extends BaseWebActivity implements View.OnScrollChangeListener {

    @InjectView(R.id.mv_toolbar)
    public Toolbar toolbar;
    @InjectView(R.id.zh_info_image)
    public ImageView title_image;
    @InjectView(R.id.zh_SV_space)
    public TextView zh_SV_space;
    @InjectView(R.id.zh_info_web)
    public WebView webview;
    @InjectView(R.id.zh_LL)
    public  LinearLayout linearLayout;
    @InjectView(R.id.zh_titile)
    public TextView zh_title;
    @InjectView(R.id.myScrolView)
    public com.clwater.littesee.Weight.MyScrollView myscrollview;

    private String webText;
    private String webCss;
    private String webImage;
    private String webTitle;
    private String webUrl;
    private int _yold = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihuinfo);
        ButterKnife.inject(this);

        activity = this;

        Intent intent = this.getIntent();
        webImage = intent.getStringExtra("webImage");
        webTitle = intent.getStringExtra("webTitle");
        webUrl = intent.getStringExtra("webUrl");

        initTitle();
        initNavigation();
        initUI();
        initWebView();
        initOtherInfo(webImage , webTitle);
        initWebViewInfo(webUrl);


        if (webText != null) {
            String data = WebUtils.buildHtmlWithCss(webText, webCss, false);
            webview.loadDataWithBaseURL(WebUtils.BASE_URL, data, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL);
        }


    }

    private void initOtherInfo(String webImage , String webTitle) {
        ImageLoader.getInstance().displayImage(webImage ,title_image, AppConfig.imageOptions());
        zh_title.setText(webTitle);
    }

    private void initWebViewInfo(String url) {
        String re = OkHttp_LS.okhttp_get(url);
        if (re != null) {
            webText = WebUtils.getWebText(re);
            webCss = WebUtils.getWebCss(re);
        }else {
            initWebViewInfo(url);
        }
    }

    private void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCachePath(getCacheDir().getAbsolutePath() + "/webViewCache");
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setDisplayZoomControls(false);
        webview.setWebChromeClient(new WebChromeClient());
    }


    private void initUI() {
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) title_image.getLayoutParams();
        relativeParams.height = height * 4  / 10;
        title_image.setLayoutParams(relativeParams);
        relativeParams = (RelativeLayout.LayoutParams) zh_SV_space.getLayoutParams();
        relativeParams.height = height * 4  / 10 - 20;
        zh_SV_space.setLayoutParams(relativeParams);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ZhuHuInfoActivity.this));

        myscrollview.setOnScrollChangeListener(this);

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

    private void changeTitlePositation(boolean bool) {
        TransitionManager.beginDelayedTransition(linearLayout);
        if(bool){
            LinearLayout.LayoutParams rp = (LinearLayout.LayoutParams) zh_title.getLayoutParams();
            rp.gravity = Gravity.TOP;
            zh_title.setLayoutParams(rp);
        }else {
            LinearLayout.LayoutParams rp = (LinearLayout.LayoutParams) zh_title.getLayoutParams();
            rp.gravity = Gravity.BOTTOM;
            zh_title.setLayoutParams(rp);
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


    @Override
    public void onScrollChange(View v, int x, int y, int oldx, int oldy) {
        int _y = y - oldy;
        if ( (_y > 20) || (_y < -20) ){
            if ((((_yold >= 0) && (_y <= 0)) || ((_yold <= 0) && (_y >= 0)))) {
                if (_y > 0) {
                    changeTitlePositation(true);
                } else {
                    changeTitlePositation(false);
                }
            }
            _yold = _y;
        }
    }


}
