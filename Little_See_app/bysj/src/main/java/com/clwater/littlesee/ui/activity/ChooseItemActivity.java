package com.clwater.littlesee.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clwater.littlesee.R;

import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/3/16.
 */

public class ChooseItemActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseitem);
        ButterKnife.bind(this);

    }


}
