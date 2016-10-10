package com.clwater.littesee.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clwater.littesee.R;

/**
 * Created by gengzhibo on 16/10/10.
 */

public class WangyiFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_wangyi, container, false);
    }

}