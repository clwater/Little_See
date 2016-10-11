package com.clwater.littesee.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import static java.security.AccessController.getContext;

/**
 * Created by gengzhibo on 16/10/10.
 */

public class BaseWebActivity extends AppCompatActivity {
    public Activity activity;
    public int width;
    public int height;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }
}
