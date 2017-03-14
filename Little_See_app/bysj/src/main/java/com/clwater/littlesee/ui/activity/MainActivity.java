package com.clwater.littlesee.ui.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.clwater.littlesee.R;
import com.clwater.littlesee.ui.fragment.NewsFragment;
import com.clwater.littlesee.ui.fragment.DiaryFragment;
import com.clwater.littlesee.ui.fragment.SearchFragment;
import com.clwater.littlesee.ui.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    NewsFragment _calendarFragment;         //即刻
    SearchFragment _searchFragment;         //实景
    SettingFragment _settingFragment;       //设置
    DiaryFragment _diaryFragemnt;           //每日精选

    private int bottemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

    }

    private void init() {

        initBottomNavigationBar();
        initFragmentManager();

    }

    private void initFragmentManager() {
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher, "今日"))
                .addItem(new BottomNavigationItem(R.drawable.ic_reloj_max, "笔记"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher, "日历"))
                .addItem(new BottomNavigationItem(R.drawable.ic_reloj_max, "搜索"))
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
                            break;
                        case 1:
                            transaction.replace(R.id.framelayout_content, _settingFragment);
                            break;
                        case 2:
                            transaction.replace(R.id.framelayout_content, _calendarFragment);
                            break;
                        case 3:
                            transaction.replace(R.id.framelayout_content, _searchFragment);
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
        _calendarFragment = new NewsFragment();
        _searchFragment = new SearchFragment();
        _settingFragment = new SettingFragment();
        _diaryFragemnt = new DiaryFragment();

        transaction.replace(R.id.framelayout_content, _diaryFragemnt);
        transaction.commit();
    }
}