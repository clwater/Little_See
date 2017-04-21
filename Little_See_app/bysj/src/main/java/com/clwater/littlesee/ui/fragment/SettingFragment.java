package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.clwater.littlesee.Application;
import com.clwater.littlesee.R;
import com.clwater.littlesee.database.BaseControl;
import com.clwater.littlesee.ui.activity.AboutActivity;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.ui.activity.DebugActivity;
import com.clwater.littlesee.utils.glide.GlideCatchUtil;
import com.litesuits.orm.LiteOrm;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;


import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.clwater.littlesee.utils.FileHelp.getFolderSize;
import static com.clwater.littlesee.utils.FileHelp.getFormatSize;

/**
 * Created by yszsyf on 17/2/26.
 */


//设置
public class SettingFragment extends Fragment {


    @BindView(R.id.textview_setting_debug) TextView textview_setting_debug;

    @BindView(R.id.textview_setting_class_image) TextView textview_setting_class_image;
    @BindView(R.id.textview_setting_class_news) TextView textview_setting_class_news;
    @BindView(R.id.textview_setting_class_diary) TextView textview_setting_class_diary;

    @BindView(R.id.textview_setting_aboutme) TextView textview_setting_aboutme;
    @BindView(R.id.textview_setting_cache) TextView textview_setting_cache;
    @BindView(R.id.textview_setting_cacheinfo) TextView textview_setting_cacheinfo;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this , view);

        init();

        return view;
    }

    private void init() {
        initchche();
    }

    private void initchche() {
        String imageCache = getCacheSize();
        String sqlCache = getSqlChaheSize();

        textview_setting_cacheinfo.setText("图片缓存:" + imageCache + " 其他缓存:" + sqlCache);
    }

    private String getSqlChaheSize() {

        String  url = Application.getInstance().getCacheDir().toString();
        url = url.replace("cache" , "databases");

        try {
            return getFormatSize(getFolderSize(new File(url) ) );
        } catch (Exception e) {
            e.printStackTrace();
            return "获取失败";
        }

    }



    public String getCacheSize() {
        try {
              return  GlideCatchUtil.getInstance().getCacheSize();
        } catch (Exception e) {
            e.printStackTrace();
            return "获取失败";
        }
    }

    
    public void clearCache(){
        clearGildeChahe();
        clearSqlCache();
        initchche();
    }

    private void clearSqlCache() {
        LiteOrm liteOrm = BaseControl.Initialize(this.getContext());
        liteOrm.deleteDatabase();
    }

    private boolean clearGildeChahe() {
        return GlideCatchUtil.getInstance().clearCacheDiskSelf();
    }

    @OnClick(R.id.textview_setting_cache)
    public void textview_setting_cache_onclick(){

        Snackbar snackbar = Snackbar.with(SettingFragment.this.getContext()) // context
                        .text("确定要删除的?") // text to display
                        .actionLabel("确定") // action button label
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {
                                clearCache();
                            }
                        });

        SnackbarManager.show(snackbar);
    }


    @OnClick(R.id.textview_setting_debug)
    public void onclick_textview_serting_debug(){
        startActivity(new Intent(getActivity() , DebugActivity.class));
    }

    @OnClick(R.id.textview_setting_class_image)
    public void textview_setting_class_image_onclick(){
        Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
        intent.putExtra("index" , "image" );
        startActivity(intent);

    }
    @OnClick(R.id.textview_setting_class_news)
    public void textview_setting_class_news_onclick(){
        Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
        intent.putExtra("index" , "news" );
        startActivity(intent);

    }
    @OnClick(R.id.textview_setting_class_diary)
    public void textview_setting_class_diary_onclick(){
        Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
        intent.putExtra("index" , "diary" );
        startActivity(intent);
    }

    @OnClick(R.id.textview_setting_aboutme)
    public void textview_setting_aboutme_onclick(){
        startActivity(new Intent(this.getActivity() , AboutActivity.class));
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}