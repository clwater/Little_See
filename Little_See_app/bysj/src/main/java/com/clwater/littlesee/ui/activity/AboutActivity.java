package com.clwater.littlesee.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;


import com.clwater.littlesee.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.lin_about_me)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.lin_about_me)
    public void lin_about_me_onclick(){
        AboutActivity.this.finish();
    }
}
