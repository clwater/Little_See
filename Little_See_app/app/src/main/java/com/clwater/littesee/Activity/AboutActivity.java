package com.clwater.littesee.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.clwater.littesee.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class AboutActivity extends BaseActivity {

    @InjectView(R.id.about_me)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.inject(this);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.this.finish();
            }
        });

    }
}
