package com.clwater.littesee;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;


import com.clwater.littesee.Activity.AboutActivity;
import com.clwater.littesee.Activity.BaseActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {
    private String TAG ="Little_See";


    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);


        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_more);
        ab.setDisplayHomeAsUpEnabled(true);

        setupDrawerContent(mNavigationView);
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
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }





//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.actionbar_main_activity,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_bar_about:
//                startActivity(new Intent(this , AboutActivity.class));
//                return true;
//
//            case R.id.action_bar_more:
//                Toast.makeText(MainActivity.this,"您点击了更多！", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

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
                mDrawerLayout.openDrawer(GravityCompat.START);
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
