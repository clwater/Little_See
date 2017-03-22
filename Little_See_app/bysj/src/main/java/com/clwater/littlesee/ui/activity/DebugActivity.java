package com.clwater.littlesee.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.clwater.littlesee.R;
import com.clwater.littlesee.utils.SPHelper;
import com.clwater.littlesee.utils.WebContent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yszsyf on 17/3/22.
 */

public class DebugActivity extends AppCompatActivity {

    @BindView(R.id.edittext_debug_ip)
    EditText edittext_debug_ip;


    @BindView(R.id.button_debug_save)
    Button button_debug_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_debug);
        ButterKnife.bind(this);

        init();

    }

    private void init() {
        edittext_debug_ip.setText("" + WebContent.ServerAddress);
    }

    @OnClick(R.id.button_debug_save)
    public void onclick_edittext_debug_ip(){
        SPHelper.saveServeraddress(this , edittext_debug_ip.getText().toString());
        WebContent.ServerAddress = edittext_debug_ip.getText().toString();

    }
}