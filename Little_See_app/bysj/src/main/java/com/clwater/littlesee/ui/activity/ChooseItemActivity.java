package com.clwater.littlesee.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.clwater.littlesee.R;
import com.google.android.flexbox.FlexboxLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/3/16.
 */

public class ChooseItemActivity extends AppCompatActivity {

    @BindView(R.id.flexboxlayout_chooseitem_activity)
    FlexboxLayout flexboxLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chooseitem);
        ButterKnife.bind(this);
        activity = this;
            
        initToolBar();
        init();

    }

    private void initToolBar() {
        toolbar.setTitle("优选话题");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    private void init() {
    }


}
