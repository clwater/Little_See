package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clwater.littesee.R;

import butterknife.InjectView;

public class ZhiHuFragment extends Fragment
{

    @InjectView(R.id.test_zhihu)
    TextView test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);

        return view;
    }
}