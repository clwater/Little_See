package com.clwater.littesee;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



import com.clwater.littesee.Activity.AboutActivity;
import com.clwater.littesee.Activity.BaseActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String TAG ="Little_See";

    @InjectView(R.id.ma_layout)
    public DrawerLayout drawerLayout;
    @InjectView(R.id.ma_nv)
    public NavigationView navigationView;
    @InjectView(R.id.mv_toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);



        initNavigationView();


    }

    private void initNavigationView() {
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_more);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_zhihu:
               // getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FragmentOne()).commit();
                //mToolbar.setTitle("我的动态");
                break;
            case R.id.nav_about:
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



//requestWindowFeature(Window.FEATURE_NO_TITLE);

//        ImageLoader imageLoader = ImageLoader.getInstance();
//        imageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.this));
//        ImageLoader.getInstance().displayImage("https://avatars3.githubusercontent.com/u/14257964?v=3&s=466",ijimage, AppConfig.imageOptions());
