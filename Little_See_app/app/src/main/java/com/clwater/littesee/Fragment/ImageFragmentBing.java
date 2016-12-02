package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.library.Info;
import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.clwater.littesee.Activity.ImageInfoActivity;
import com.clwater.littesee.Adapater.DividerItemDecoration;
import com.clwater.littesee.Adapater.RecyclerAdapter_image;
import com.clwater.littesee.MainActivity;
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
import com.pnikosis.materialishprogress.ProgressWheel;

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
    @InjectView(R.id._top_process)
    public ProgressWheel _top_process;
//    @InjectView(R.id.item_img)
//    public PhotoView item_img;

    private String[] image_src ;
    //List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    private boolean image_statu ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_image_, container, false);
        ButterKnife.inject(this , view);

        EventBus.getDefault().register(this);
//        image_statu = true;
//
//
//        if (image_statu) {
//            getNewDate();
//            image_statu = false;
//        }else {
//            initViewPager();
//        }
//
        getData();

        getNewDate();



        return view ;
    }



    private void getNewDate() {
        Event_RunInBack event = new Event_RunInBack();
        EventBus.getDefault().post(event);
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
        _top_process.setVisibility(View.GONE);
        Toast.makeText(MainActivity.context , "点击图片可随意缩放图片或者旋转,长按保存图片." , Toast.LENGTH_SHORT).show();

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
            public Object instantiateItem(ViewGroup container, final int position) {

                View view = View.inflate(container.getContext(), R.layout.pager_item, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_img);
                Glide.with(ImageFragmentBing.this).load(image_src[position % image_src.length]).into(imageView);
                container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity() , ImageInfoActivity.class);
                        intent.putExtra("href" , image_src[position]);
                        startActivity(intent);
                        Log.d("gzb" , "viewpaher " + position);
                    }
                });
                return view;
            }

            @Override
            public int getCount() {
                return image_src.length;
            }
        };
        PVP_image_viewpager.setAdapter(adapter);
    }




    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void BackEventBus(Event_RunInBack e){

        int bewdate = 0 ;

        bewdate = DateUtils.checkDate__image_bing();
        String url = "";
        if (image_src.length < 1) {
            bewdate = bewdate - 50;
            url = "http://115.159.123.41:8001/imageold?statu=bing&date=" + bewdate;
        }else {
            url = "http://115.159.123.41:8001/image?statu=bing&date=" + bewdate;
        }
        Log.d("gzb" , "url: " + url);

        String date = OkHttp_LS.okhttp_get(url);
        if (date.equals("no new date")) {
            Toast.makeText(getActivity(), "没有更新的了", Toast.LENGTH_SHORT).show();
        } else if (date.equals("http get error")) {
            Toast.makeText(getActivity(), "获取请求失败,请检查网络后重试", Toast.LENGTH_SHORT).show();
        } else {
            if (date.length() > 2) {
                saveNewDate(date);
            }
        }

    }

    private void saveNewDate(String date) {
        List<Image_me> _image_me = Analysis.AnalysisImage_me_bing(date);
        int changeDate = SaveDate.imageDateSave(_image_me);
        //if (changeDate > 0) {
        EventBus.getDefault().post(new Event_RunInFront());
        //}

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void FrontEventBus(Event_RunInFront e){
        getData();
        initViewPager();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}