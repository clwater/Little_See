package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

public class ZhuHuInfoActivity  extends BaseWebActivity{

    @InjectView(R.id.mv_toolbar)
    public Toolbar toolbar;
    @InjectView(R.id.zh_info_image)
    public ImageView title_image;
    @InjectView(R.id.zh_SV_space)
    public TextView zh_SV_space;
    @InjectView(R.id.zh_info_web)
    public WebView webview;

    private String webText;
    private String webCss;
    private String webImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihuinfo);
        ButterKnife.inject(this);

        activity = this;

        webImage = "https://avatars3.githubusercontent.com/u/14257964?v=3&s=466";

        initTitle();
        initNavigation();
        initUI();
        initWebView();
        initWebViewInfo("http://daily.zhihu.com/story/8817495");


        if (webText != null) {
            String data = WebUtils.buildHtmlWithCss(webText, webCss, false);
            webview.loadDataWithBaseURL(WebUtils.BASE_URL, data, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL);
        }

        ImageLoader.getInstance().displayImage(webImage ,title_image, AppConfig.imageOptions());



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
        //LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) zh_SV_space.getLayoutParams();
        relativeParams.height = height * 4  / 10;
        zh_SV_space.setLayoutParams(relativeParams);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ZhuHuInfoActivity.this));

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
