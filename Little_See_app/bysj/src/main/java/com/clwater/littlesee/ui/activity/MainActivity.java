package com.clwater.littlesee.ui.activity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.clwater.littlesee.R;
import com.clwater.littlesee.eventbus.EventBus_UpdateSetting;
import com.clwater.littlesee.ui.fragment.NewsFragment;
import com.clwater.littlesee.ui.fragment.DiaryFragment;
import com.clwater.littlesee.ui.fragment.ImageFragment;
import com.clwater.littlesee.ui.fragment.SettingFragment;
import com.clwater.littlesee.utils.SPHelper;
import com.clwater.littlesee.utils.WebContent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.framelayout_content)
    FrameLayout frameLayout;

    NewsFragment _newsFragment;             //即刻
    ImageFragment _imageFragment;           //佳景
    SettingFragment _settingFragment;       //设置
    DiaryFragment _diaryFragemnt;           //优选

    Fragment _tempFragment;

    private int bottemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);

        init();
        initToolbar();
        checkAddress();
    }

    private void checkAddress() {
        WebContent.ServerAddress = SPHelper.getServeraddress(this);
    }


    private void initToolbar() {
        toolbar.setTitle("优选");
        setSupportActionBar(toolbar);
        //toolbar.setOnMenuItemClickListener(onMenuItemClick);

    }




    private void init() {

        initBottomNavigationBar();
        initFragmentManager();

    }



    public void switchContent(Fragment from, Fragment to) {
        if (_tempFragment != to) {
            _tempFragment = to;
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                ft.hide(from).add(R.id.framelayout_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                ft.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }


    private void initFragmentManager() {


        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_CLASSIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.dairy, "优选"))
                //.setActiveColor(R.color._000000)
                .setActiveColor(R.color._000000)
                .setInActiveColor("#ffffff")
                .addItem(new BottomNavigationItem(R.drawable.news, "即刻"))
                .setActiveColor(R.color._000000)
                .setInActiveColor("#ffffff")
                .addItem(new BottomNavigationItem(R.drawable.image, "佳景"))
                .setActiveColor(R.color._000000)
                .setInActiveColor("#ffffff")
                .addItem(new BottomNavigationItem(R.drawable.setting, "设置"))
                .setActiveColor(R.color._000000)
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
                            toolbar.setTitle("优选");
                            switchContent(_tempFragment , _diaryFragemnt);
                            _tempFragment = _diaryFragemnt;
                            break;
                        case 1:
                            toolbar.setTitle("即刻");
                            switchContent(_tempFragment , _newsFragment);
                            _tempFragment = _newsFragment;

                            break;
                        case 2:
                            toolbar.setTitle("佳景");
                            switchContent(_tempFragment , _imageFragment);
                            _tempFragment = _imageFragment;

                            break;
                        case 3:
                            toolbar.setTitle("设置");
                            switchContent(_tempFragment , _settingFragment);
                            _tempFragment = _settingFragment;
                            EventBus.getDefault().post(new EventBus_UpdateSetting());
                            break;
                    }
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

        _tempFragment = _diaryFragemnt;
        transaction.replace(R.id.framelayout_content, _diaryFragemnt);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}