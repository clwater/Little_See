package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.clwater.littlesee.R;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.ui.activity.DebugActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yszsyf on 17/2/26.
 */


//设置
public class SettingFragment extends Fragment {
    @BindView(R.id.textview_serting_debug) TextView textview_serting_debug;

    @BindView(R.id.textview_setting_class_image) TextView textview_setting_class_image;
    @BindView(R.id.textview_setting_class_news) TextView textview_setting_class_news;
    @BindView(R.id.textview_setting_class_diary) TextView textview_setting_class_diary;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this , view);

        return view;
    }

    @OnClick(R.id.textview_serting_debug)
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


    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}