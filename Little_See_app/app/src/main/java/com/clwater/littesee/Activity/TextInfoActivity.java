package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.webkit.WebViewClient;
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

public class TextInfoActivity  extends BaseWebActivity implements View.OnScrollChangeListener {

    @InjectView(R.id._toolbar)
    public Toolbar toolbar;
    @InjectView(R.id._info_image)
    public ImageView title_image;
    @InjectView(R.id._SV_space)
    public TextView _SV_space;
    @InjectView(R.id._info_web)
    public WebView webview;
    @InjectView(R.id._LL)
    public  LinearLayout linearLayout;
    @InjectView(R.id._titile)
    public TextView _title;
    @InjectView(R.id.myScrolView)
    public com.clwater.littesee.Weight.MyScrollView myscrollview;

    private String webText;
    private String webCss;
    private String webImage;
    private String webTitle;
    private String webUrl;
    private int _yold = 0;

    private AlertDialog prcessDialog;

    private String statu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.inject(this);



        activity = this;

        Intent intent = this.getIntent();
        webImage = intent.getStringExtra("webImage");
        webTitle = intent.getStringExtra("webTitle");
        webUrl = intent.getStringExtra("webUrl");
        statu = intent.getStringExtra("statu");


        initTitle();
        initNavigation();
        initUI();
        initWebView();
        initOtherInfo(webImage , webTitle);
       // initProcessDialog();

        if (statu.equals("zhihu")) {
            initWebViewInfo_zhihu(webUrl);
            if (webText != null) {
                String data = WebUtils.buildHtmlWithCss(webText, webCss, false);
                webview.loadDataWithBaseURL(WebUtils.BASE_URL, data, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL_ZHIHU);
            }
        }else if (statu.equals("haoqixin")){
            //webview.loadUrl(webUrl);
         //   webview.loadUrl("javascript:e = document.evaluate(\"html/body/div[2]/div[1]/div[1]/div[1]\", document, null, XPathResult.ANY_TYPE, null);e.style.display=\"none\";");
            initWebViewInfo_haoqixin(webUrl);
            Log.d("gzb" , webUrl);
            if (webText != null) {
                String css = "";
                String[] csss = new String[2];
                csss[0] = "http://m.qdaily.com/assets/mobile/common.css";
                csss[1] = "http://m.qdaily.com/assets/mobile/articles/show.css";
                String data = WebUtils.buildHtmlWithCsss(webText, csss, false);
                webview.loadDataWithBaseURL(WebUtils.BASE_URL, data, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL_HAOQIXIN);
            }
        }


    }

    private void initProcessDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dlalog_process,null);
        prcessDialog = new AlertDialog.Builder(this).create();
        prcessDialog.show();
        prcessDialog.getWindow().setContentView(layout);
        prcessDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    destoryParentActivity();
                }
                return false;
            }
        });
    }

    private void destoryParentActivity() {
        this.finish();
    }

    private void initOtherInfo(String webImage , String webTitle) {
        ImageLoader.getInstance().displayImage(webImage ,title_image, AppConfig.imageOptions());
        _title.setText(webTitle);
    }

    private void initWebViewInfo_zhihu(String url) {
        String re = OkHttp_LS.okhttp_get(url);
        if ( (re != null) && (!re.equals("ok http  get error")) && (!re.equals(""))){
            webText = WebUtils.getWebText_zhihu(re);
            webCss = WebUtils.getWebCss_zhihu(re);
//            prcessDialog.dismiss();
        }else {
            initWebViewInfo_zhihu(url);
        }
    }

    private void initWebViewInfo_haoqixin(String url) {
        String re = OkHttp_LS.okhttp_get(url);
        if ( (re != null) && (!re.equals("ok http  get error")) && (!re.equals(""))){
            //webText = re;
            webText = WebUtils.getWebText_haoqixin(re);
           // webCss = WebUtils.getWebCss_haoqixin(re);
           // prcessDialog.dismiss();
        }else {
            initWebViewInfo_haoqixin(url);
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
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
        webview.setWebChromeClient(new WebChromeClient());
    }


    private void initUI() {
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) title_image.getLayoutParams();
        relativeParams.height = height * 4  / 10;
        title_image.setLayoutParams(relativeParams);
        relativeParams = (RelativeLayout.LayoutParams) _SV_space.getLayoutParams();
        relativeParams.height = height * 4  / 10 - 20;
        _SV_space.setLayoutParams(relativeParams);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(TextInfoActivity.this));

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
        if (statu.equals("zhihu")) {
            toolbar.setTitle("知乎日报");
        }else if(statu.equals("haoqixin")){
            toolbar.setTitle("好奇心日报");
        }
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_back);
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
            LinearLayout.LayoutParams rp = (LinearLayout.LayoutParams) _title.getLayoutParams();
            rp.gravity = Gravity.TOP;
            _title.setLayoutParams(rp);
        }else {
            LinearLayout.LayoutParams rp = (LinearLayout.LayoutParams) _title.getLayoutParams();
            rp.gravity = Gravity.BOTTOM;
            _title.setLayoutParams(rp);
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
