package com.clwater.littesee;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.clwater.littesee.Activity.AboutActivity;
import com.clwater.littesee.Activity.BaseActivity;
import com.clwater.littesee.Fragment.ImageFragment;
import com.clwater.littesee.Fragment.WangyiFragment;
import com.clwater.littesee.Fragment.ZhiHuFragment;
import com.clwater.littesee.Utils.DBHelper.User1;
import com.clwater.littesee.Utils.DBHelper.UserDaoOrm;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    @InjectView(R.id.ma_layout)
    public DrawerLayout drawerLayout;
    @InjectView(R.id.ma_nv)
    public NavigationView navigationView;
    @InjectView(R.id.mv_toolbar)
    public Toolbar toolbar;


    private WangyiFragment _wangyi;
    private ZhiHuFragment _zhihu;
    private ImageFragment _image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        initNavigationView();
        setDefaultFragment();
        
        testSql();


    }

    private void testSql() {
        UserDaoOrm userDao=new UserDaoOrm(this);
        User1 user1=new User1();
        user1.setUserId("a1");
        user1.setName("b1");
        user1.setAge(11);
        userDao.add(user1);

        user1.setUserId("a2");
        user1.setName("b2");
        user1.setAge(22);
        userDao.add(user1);

        user1.setUserId("a3");
        user1.setName("b3");
        user1.setAge(33);
        userDao.add(user1);

        List<User1> list= userDao.select();
        Log.d("gzb" , "1" +  list.toString());

        User1 u = userDao.seleteUser("a2");
        userDao.delete(u);

        list= userDao.select();
        Log.d("gzb" , "2" +  list.toString());

        user1.setUserId("a3");
        user1.setName("b3");
        user1.setAge(34);
        userDao.add(user1);


        list= userDao.select();
        Log.d("gzb" , "3" +  list.toString());

    }


    private void setDefaultFragment() {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        _zhihu = new ZhiHuFragment();
        //_image = new ImageFragment();
        transaction.replace(R.id.id_content, _zhihu);
        transaction.commit();

    }


    private void initNavigationView() {
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_nv);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_zhihu:
                toolbar.setTitle("知乎");
                if (_zhihu == null){
                    _zhihu = new ZhiHuFragment();
                }
                transaction.replace(R.id.id_content, _zhihu);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_wangyi:
                toolbar.setTitle("网易");
                if (_wangyi == null){
                    _wangyi = new WangyiFragment();
                }
                transaction.replace(R.id.id_content, _wangyi);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_image:
                toolbar.setTitle("图片");
                if (_image == null){
                    _image = new ImageFragment();
                }
                transaction.replace(R.id.id_content, _image);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_about:
                drawerLayout.closeDrawers();
                startActivity(new Intent(this , AboutActivity.class));
                break;
        }

        return true;
    }


    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.actionbar_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.action_bar_about:
                startActivity(new Intent(this , AboutActivity.class));
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}


