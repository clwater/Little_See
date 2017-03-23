package com.clwater.littlesee.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
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
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clwater.littlesee.R;
import com.clwater.littlesee.eventbus.EventBus_RunInBack;
import com.clwater.littlesee.eventbus.EventBus_RunInFront;
import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.clwater.littlesee.utils.OkHttpUtils;
import com.clwater.littlesee.utils.WebUtils;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yszsyf on 17/3/17.
 */

public class BaseTextInfoActivity extends AppCompatActivity implements View.OnScrollChangeListener {

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
    private String showText;

    private Snackbar snackbar;


    DiaryBean.DateBean diaryBean = new DiaryBean.DateBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        Intent intent =this.getIntent();
        diaryBean = (DiaryBean.DateBean) intent.getSerializableExtra("diary");

        init();
        initToolbar(diaryBean.getIndexclass());
        initImage(diaryBean.getImage());
        initTitle(diaryBean.getTitle());
        initWebView(diaryBean.getIndexclass() , diaryBean.getAddress() );

        showDialogPor();
    }




    private void init(){
        int defaultMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,baseheight,getResources().getDisplayMetrics());
        view_space.setLayoutParams(new LinearLayout.LayoutParams(view_space.getWidth() , defaultMargin));
        myscrollview.setOnScrollChangeListener(this);
    }
    private void initTitle(String title) {
        textview_textinfo_titile.setText(title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    private void initWebView(String diaryBeanAddress, String address) {
        initWebViewConfig();
        Log.d("gzb" , "diaryBeanAddress: " + diaryBeanAddress + "  address:  " + address);
        EventBus.getDefault().post(new EventBus_RunInBack("textinfoinback" , diaryBeanAddress , address));


    }

    private void showZhiHu(String address) {
        showText = OkHttpUtils.okhttp_get(address);
//        Log.d("gzb" , showText);
        showText = showText.replace("\n" , "");
        showText = showText.replace("\r" , "");
        showText = showText.replace("\t" , "");
        showText = GetUseTextZhiHu(showText);
        String[] Csss = new String[]{"http://daily.zhihu.com/css/share.css?v=5956a"};
        showText = WebUtils.buildWithCss(showText , Csss);
        EventBus.getDefault().post(new EventBus_RunInFront("showZhihiText"));
    }

    private void showHaoQiXin(String address) {
        showText = OkHttpUtils.okhttp_get(address);
//        Log.d("gzb" , showText);
        showText = showText.replace("\n" , "");
        showText = showText.replace("\r" , "");
        showText = showText.replace("\t" , "");
        showText = GetUseTextHaoQinXin(showText);

        String[] Csss = new String[]{"http://m.qdaily.com/assets/mobile/common.css", "http://m.qdaily.com/assets/mobile/articles/show.css"};
//        String[] Csss = new String[]{"http://www.qdaily.com/assets/web/common-fb47b35ba95f91c7f57eed4ef3e01d68a567749051a0065301993277e0c65999.css" ,
//                                     "http://www.qdaily.com/assets/web/articles/show-95c002a30d0f02840e7bbb65d9f0a0563f2cabedfadcb4795da01bdb5a82ec61.css"};
        showText = WebUtils.buildWithCss(showText , Csss);

        Log.d("gzb" , showText);
        EventBus.getDefault().post(new EventBus_RunInFront("showHaoqixinText"));
    }


//    private String GetUseTextHaoQinXin(String showText) {
//
//
//        Pattern pattern = Pattern.compile("<div class=\"article-detail-bd\">.*?<div class=\"article-detail-ft\">");
//        Matcher matcher = pattern.matcher(showText);
//        StringBuffer buffer = new StringBuffer();
//        while (matcher.find()){
//            buffer.append(matcher.group());
//        }
//
//        return  buffer.toString();
//
////        return "";
//    }



    public static String GetUseTextHaoQinXin(String re){
        String text = re.substring(re.indexOf("<div class=\"article-detail-bd\">") , re.lastIndexOf("article-detail-ft"));
        //re.indexOf("<body ") , re.lastIndexOf("</html>")  );
        text = text.replace("data-src" , "src");
        text = text.replace("class=\"lazyload\"" , "class=\"lazyload\" style=\"max-width: 96%\"");
        text = text.replace("class=\"excerpt\"" , "style=\"\n" +
                "    position: relative;\n" +
                "    margin-top: 15px;\n" +
                "    margin-top: .75rem;\n" +
                "    padding: 25px 0;\n" +
                "    padding: 1.25rem 0;\n" +
                "    color: #9c9c9c;\n" +
                "    text-align: center;\n" +
                "\"");
        text = text.replace("class=\"article-detail-bd\"" , "style=\"padding-left: 10px ;padding-top: 10px\"");
        text = text.replace("题图来自" , "<b>题图来自</b>");
        text = text.replace("<p" , "<p style=\"font-size: 20px\"");
        return  text;
    }

    private String GetUseTextZhiHu(String showText) {


        Pattern pattern = Pattern.compile("<div class=\"question\">.*?<div class=\"view-more\">");
        Matcher matcher = pattern.matcher(showText);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()){
             buffer.append(matcher.group());
        }

        return  buffer.toString();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void webViewtextShow(EventBus_RunInFront e){
        if (e.getTag().equals("showZhihiText")){
            webview.loadDataWithBaseURL(WebUtils.BASE_URL, showText, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL_ZHIHU);
        }else if (e.getTag().equals("showHaoqixinText")){
            webview.loadDataWithBaseURL(WebUtils.BASE_URL, showText, WebUtils.MIME_TYPE, WebUtils.ENCODING, WebUtils.FAIL_URL_HAOQIXIN);
        }

        snackbar.dismiss();
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void textInfoActivityBack(EventBus_RunInBack e){
        if (e.getTag().equals("textinfoinback")){
            String diaryBeanAddress = e.getTag2();
            String address = e.getTag3();

            if (diaryBeanAddress.equals("知乎日报")){
                showZhiHu(address);
            }else if (diaryBeanAddress.equals("好奇心日报")){
                address = address.replace("www.qdaily.com" , "m.qdaily.com/mobile");
                showHaoQiXin(address);
            }
        }
    }


    private void initWebViewConfig() {
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
        settings.setDisplayZoomControls(true);
        webview.setWebChromeClient(new WebChromeClient());

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
            baseheight = -1;
            toolbar.setAlpha(0);
        }else {
            toolbar.setAlpha(1f);
        }
        //Log.d("gzb" , "" + _y);
        view_space.setLayoutParams(new LinearLayout.LayoutParams(view_space.getWidth() , defaultMargin));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void showDialogPor() {
        snackbar = Snackbar.with(this)
                .type(SnackbarType.MULTI_LINE)
                .duration(Snackbar.SnackbarDuration.LENGTH_INDEFINITE)
                .text("loading...");
        SnackbarManager.show(snackbar);
    }
}
