package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.XmlResourceParser;
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
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.OkHttp_LS;
import com.clwater.littesee.Utils.WebUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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


    String testtext ;


    boolean pd = true;

    String[] scc;
    String css;





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




        testanalisus();



        scc = new String[10];
        scc[0]  = css;
        Log.d("gzb" , "scc[0]:" + scc[0]);
//        http://daily.zhihu.com/story/8876124

        if (testtext != null) {

            String data = WebUtils.buildHtmlWithCss(testtext, scc, false);

            webview.loadDataWithBaseURL(WebUtils.BASE_URL, data, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL);

        }

    }

    private void testanalisus() {
        String url = "http://daily.zhihu.com/story/8817495";

        String re = OkHttp_LS.okhttp_get(url);
        String _re = re;

        if (re != null) {
            int  _strat = re.indexOf("<div class=\"content-inner\">");
            int _end = re.lastIndexOf("<div class=\"question\">");

            testtext = re.substring(_strat , _end);

            String link = _re.substring(_re.indexOf("/css/share.css?") , _re.lastIndexOf("<script src=\"http://static.daily.zhihu.com/js/modernizr-2.6.2.min.js\"></script>"));
            link = link.trim();
            link = link.substring("/css/share.css?v=".length() , link.length() - "\">".length() );

            css = "http://news-at.zhihu.com/css/news_qa.auto.css?v=" + link;


        }else {
            testanalisus();
        }


//        int start_index = re.indexOf("<div class=\"main-wrap\">");
//        Logger.d("" + start_index);




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
