package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.clwater.littlesee.R;
import com.clwater.littlesee.ui.activity.DebugActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yszsyf on 17/2/26.
 */


//设置
public class SettingFragment extends Fragment {
    @BindView(R.id.textview_serting_debug)
    TextView textview_serting_debug;

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


    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}