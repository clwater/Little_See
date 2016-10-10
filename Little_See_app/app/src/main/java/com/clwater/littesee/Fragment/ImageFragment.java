package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clwater.littesee.R;

public class ImageFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        return view;
    }
}