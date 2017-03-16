package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.clwater.littlesee.R;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.utils.SPHelper;

import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/2/26.
 */

//每日优选
public class DiaryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        ButterKnife.bind(this , view);

        if (SPHelper.getStringValue(getActivity() , "diary_class").isEmpty()){
            Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
            //startActivity(intent);
        }

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}