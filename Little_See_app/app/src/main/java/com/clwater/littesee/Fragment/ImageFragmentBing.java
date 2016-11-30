package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.clwater.littesee.Adapater.DividerItemDecoration;
import com.clwater.littesee.Adapater.RecyclerAdapter_image;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.Analysis.Analysis;
import com.clwater.littesee.Utils.Analysis.SaveDate;
import com.clwater.littesee.Utils.DBHelper.Image_me;
import com.clwater.littesee.Utils.DBHelper.Image_meDaoOrm;
import com.clwater.littesee.Utils.DateUtils;
import com.clwater.littesee.Utils.EventBus.Event_RunInBack;
import com.clwater.littesee.Utils.EventBus.Event_RunInFront;
import com.clwater.littesee.Utils.HttpUtils.OkHttp_LS;
import com.github.ybq.parallaxviewpager.ParallaxViewPager;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;


import static android.os.SystemClock.sleep;

public class ImageFragmentBing extends Fragment {

    @InjectView(R.id.PVP_image_viewpager)
    public ParallaxViewPager PVP_image_viewpager;

    private String[] image_src ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_image_, container, false);
        ButterKnife.inject(this , view);


        //EventBus.getDefault().register(this);

        getData();

        initViewPager();

        return view;
    }


    public void getData(){
        Image_meDaoOrm image_meDaoOrm = new Image_meDaoOrm(getActivity());
        List<Image_me> image_meList= image_meDaoOrm.select();
        int  index_size = image_meList.size();

        image_src = new String[index_size];

        for (int i = 0 ; i < index_size  ; i++){
            if (i < index_size) {
                Image_me image_Me = image_meList.get(i);
                image_src[i] = image_Me.getHref();
            }
        }

    }


    private void initViewPager() {
        PagerAdapter adapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object obj) {
                container.removeView((View) obj);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = View.inflate(container.getContext(), R.layout.pager_item, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_img);
                Glide.with(ImageFragmentBing.this).load(image_src[position % image_src.length]).into(imageView);
                container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                return view;
            }

            @Override
            public int getCount() {
                return 40;
            }
        };
        PVP_image_viewpager.setAdapter(adapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //EventBus.getDefault().unregister(this);
    }



}