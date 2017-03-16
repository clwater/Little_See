package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.clwater.littlesee.R;

import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/2/26.
 */
//即刻
public class NewsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this , view);

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}