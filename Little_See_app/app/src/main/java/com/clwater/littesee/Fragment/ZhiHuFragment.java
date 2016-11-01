package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.clwater.littesee.Adapater.DividerItemDecoration;
import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.MainActivity;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;
import com.clwater.littesee.Utils.EventBus.Event_RunInBack;
import com.clwater.littesee.Utils.EventBus.Event_RunInFront;
import com.clwater.littesee.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
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
import butterknife.OnItemClick;

import static android.os.SystemClock.sleep;
import com.clwater.littesee.Adapater.RecyclerAdapter;

public class ZhiHuFragment extends Fragment
{

    @InjectView(R.id.main_list)
    public RecyclerView main_list;
    @InjectView(R.id._main_top_process)
    public RelativeLayout relativeLayout;
    @InjectView(R.id._top_process)
    public ProgressWheel progressWheel;
    @InjectView(R.id._top_pro_text)
    public TextView pro_text;

    public static Activity activity;
    private boolean precess_statu = true;

    List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    ZhiHuDaoOrm zhiHuDaoOrm;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        ButterKnife.inject(this , view);

       // showTopProcess();
        precess_statu = true;

        activity = getActivity();

        initListview();


        EventBus.getDefault().register(this);

//        main_list.setOnScrollListener(new AbsListView.OnScrollListener(){
//            public void onScrollStateChanged(AbsListView view, int scrollState){
//                // 当不滚动时
//                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//                    // 判断是否滚动到底部
//                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
//                        Log.d("gzb" , "aaaa");
//                    }
//                }
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//            }
//        });

//        testText.setText("zhihu");

        return view;
    }

    private void initListview() {
        List<Map<String, Object>> list=getData();


        main_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        main_list.setAdapter(new RecyclerAdapter(getActivity() , list));
        main_list.addItemDecoration(new DividerItemDecoration(getActivity() , 1));

    }



    public List<Map<String, Object>> getData(){

        zhiHuDaoOrm = new ZhiHuDaoOrm(getActivity());
        List<ZhiHu> zhihuList= zhiHuDaoOrm.select();
        for (int i = zhihuList.size() - 1 ; i >= 0  ; i--){
            ZhiHu zhihu = zhihuList.get(i);
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("id" , zhihu.getId());
            map.put("title" , zhihu.getTitle());
            map.put("address" , zhihu.getAddress());
            map.put("title_image" , zhihu.getTitle_image());
            map.put("isread" , zhihu.getIsRead());
            list.add(map);
        }
        return list;
    }


    private void showTopProcess() {
        progressWheel.setVisibility(View.VISIBLE);
    }
    private void stopTopProsess(){
        progressWheel.setVisibility(View.GONE);
        pro_text.setVisibility(View.VISIBLE);
        EventBus.getDefault().post(new Event_RunInBack());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void backEventBus(Event_RunInBack e){
        sleep(700);
        EventBus.getDefault().post(new Event_RunInFront());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void FrontEvent(Event_RunInFront e){
        pro_text.setVisibility(View.GONE);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

//    @OnItemClick(R.id.main_list)
//    public void itemClick(int position , View view){
//        if (precess_statu) {
//            stopTopProsess();
//            precess_statu = false;
//        }
//
//        Map<String, Object> map= list.get(position);
//        ZhiHu zhihu = zhiHuDaoOrm.seleteZhiHu(Integer.valueOf( map.get("id").toString() ));
//        zhihu.setIsRead(1);
//        zhiHuDaoOrm.add(zhihu);
//
//        Intent intent = new Intent(getActivity() , TextInfoActivity.class);
//        intent.putExtra("webImage" , map.get("title_image").toString());
//        intent.putExtra("webTitle" , map.get("title").toString());
//        intent.putExtra("webUrl" , map.get("address").toString());
//        intent.putExtra("statu" , "zhihu");
//        startActivity(intent);
//
//        //upDateItemTextColor(position);
//
//    }
//

    private void upDateItemTextColor(int position) {
//        View childAt = main_list.getChildAt(position - main_list.getFirstVisiblePosition());
//        if (childAt != null) {
//            TextView listview_main_text = (TextView) childAt.findViewById(R.id.listview_main_text);
//            if (listview_main_text != null) {
//                listview_main_text.setTextColor(Color.parseColor("#666666"));
//            }
//        }
    }


}