package com.clwater.littlesee.ui.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.clwater.littlesee.R;
import com.clwater.littlesee.ui.fragment.NewsFragment;
import com.clwater.littlesee.ui.fragment.DiaryFragment;
import com.clwater.littlesee.ui.fragment.ImageFragment;
import com.clwater.littlesee.ui.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    NewsFragment _newsFragment;             //即刻
    ImageFragment _imageFragment;           //实景
    SettingFragment _settingFragment;       //设置
    DiaryFragment _diaryFragemnt;           //优选

    private int bottemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setTitle("aaa");
        setSupportActionBar(toolbar);
        //toolbar.setOnMenuItemClickListener(onMenuItemClick);

    }




    private void init() {

        initBottomNavigationBar();
        initFragmentManager();

    }

    private void initFragmentManager() {


        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_CLASSIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_reloj_max, "优选"))
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#ffffff")
                .addItem(new BottomNavigationItem(R.drawable.ic_reloj_max, "即刻"))
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#ffffff")
                .addItem(new BottomNavigationItem(R.drawable.ic_reloj_max, "实景"))
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#ffffff")
                .addItem(new BottomNavigationItem(R.drawable.ic_reloj_max, "设置"))
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#ffffff")
                .initialise();





        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                if (position != bottemIndex){
                    bottemIndex = position;
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    switch (position){
                        case 0:
                            transaction.replace(R.id.framelayout_content, _diaryFragemnt);
                            toolbar.setTitle("优选");
                            break;
                        case 1:
                            transaction.replace(R.id.framelayout_content, _newsFragment);
                            toolbar.setTitle("即刻");
                            break;
                        case 2:
                            transaction.replace(R.id.framelayout_content, _imageFragment);
                            toolbar.setTitle("实景");
                            break;
                        case 3:
                            transaction.replace(R.id.framelayout_content, _settingFragment);
                            toolbar.setTitle("设置");
                            break;
                    }

                    transaction.commit();

                }

            }
            @Override
            public void onTabUnselected(int position) {
                Log.d("gzb" , "onTabUnselected:  " + position );
            }
            @Override
            public void onTabReselected(int position) {
                Log.d("gzb" , "onTabReselected:  " + position );
            }
        });
    }

    private void initBottomNavigationBar() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        _newsFragment = new NewsFragment();
        _imageFragment = new ImageFragment();
        _settingFragment = new SettingFragment();
        _diaryFragemnt = new DiaryFragment();

        transaction.replace(R.id.framelayout_content, _diaryFragemnt);
        transaction.commit();
    }
}