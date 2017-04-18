package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.clwater.littlesee.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/2/26.
 */
//实景
public class ImageFragment extends Fragment {
    @BindView(R.id.recylist_imagelist) RecyclerView recylist_imagelist;
    @BindView(R.id.swipecontainer_imagelist) SwipeRefreshLayout swipecontainer_imagelist;


    private boolean _getINNewDate = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this , view);

        setHasOptionsMenu(true);

        init();


//        getDataFromServer();

        return view;
    }


    private void init() {
        swipecontainer_imagelist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (_getINNewDate) {
                    _getINNewDate = false;
                    getDataFromServer();
                }
            }
        });
        swipecontainer_imagelist.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
    }

    private void getDataFromServer() {
        swipecontainer_imagelist.setRefreshing(true);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}