package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.Toast;


import com.clwater.littesee.Activity.TextInfoActivity;
import com.clwater.littesee.Adapater.DividerItemDecoration;
import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.MainActivity;
import com.clwater.littesee.Utils.Analysis.Analysis;
import com.clwater.littesee.Utils.DBHelper.HaoQiXin;
import com.clwater.littesee.Utils.DBHelper.HaoQiXinDaoOrm;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;
import com.clwater.littesee.Utils.EventBus.Event_RunInBack;
import com.clwater.littesee.Utils.EventBus.Event_RunInFront;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.HttpUtils.OkHttp_LS;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
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

public class ZhiHuFragment extends Fragment {


    @InjectView(R.id.main_list)
    public com.lhh.ptrrv.library.PullToRefreshRecyclerView main_list;
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
    RecyclerAdapter adapter;


    int _index = 10;
    int index_size = 0 ;


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


        return view;
    }

    private void initListview() {
        list = getData();




        main_list.setSwipeEnable(true);//open swipe
        main_list.getRecyclerView().addItemDecoration(new DividerItemDecoration(getActivity() , 1));


        main_list.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {

                Event_RunInBack event_RunInBack = new Event_RunInBack();
                event_RunInBack.setValue("onLoadMoreItems");
                EventBus.getDefault().post(event_RunInBack);


            }
        });
        main_list.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Event_RunInBack event_RunInBack = new Event_RunInBack();
                event_RunInBack.setValue("onRefresh");
                EventBus.getDefault().post(event_RunInBack);


            }
        });


        main_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(getActivity() , list);
        main_list.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                int index = Integer.valueOf(data);
                Log.d("gzb" , "index :" + index);
                index = index_size - index;
                Map<String, Object> map= list.get(index);
                ZhiHu zhihu = zhiHuDaoOrm.seleteZhiHu(Integer.valueOf( map.get("id").toString() ));
                zhihu.setIsRead(1);
                zhiHuDaoOrm.add(zhihu);

                //upDateItemTextColor(index);
                list.clear();
                list = getData();

                adapter.notifyDataSetChanged();

                Intent intent = new Intent(getActivity() , TextInfoActivity.class);
                intent.putExtra("webImage" , map.get("title_image").toString());
                intent.putExtra("webTitle" , map.get("title").toString());
                intent.putExtra("webUrl" , map.get("address").toString());
                intent.putExtra("statu" , "zhihu");
                startActivity(intent);
            }
        });

        main_list.onFinishLoading(true, false);
    }

    private void saveNewDate(String date) {
        List<ZhiHu> _zhihu = Analysis.AnalysisZhiHU(date);


        Log.d("gzb", "getNewDate: " + date);

    }


    public List<Map<String, Object>> getData(){
        list.clear();
        zhiHuDaoOrm = new ZhiHuDaoOrm(getActivity());
        List<ZhiHu> zhihuList= zhiHuDaoOrm.select();
        index_size = zhihuList.size();
        for (int i = 0 ; i < _index  ; i++){
            if (i < index_size) {
                ZhiHu zhiHu = zhihuList.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", zhiHu.getId());
                map.put("title", zhiHu.getTitle());
                map.put("address", zhiHu.getAddress());
                map.put("title_image", zhiHu.getTitle_image());
                map.put("isread", zhiHu.getIsRead());
                list.add(map);
            }
        }
        return list;
    }



    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void BackEventBus(Event_RunInBack e){
        //sleep(3000);

        Event_RunInFront event_RunInFront = new  Event_RunInFront();
        event_RunInFront.setValue(e.getValue());

        if (e.getValue().equals("onRefresh")){
            getNewDate();
        }else if (e.getValue().equals("onLoadMoreItems")){
            if (_index - index_size >= 0){
                event_RunInFront.setValue2("finash");
            }else {
                event_RunInFront.setValue2("unfinash");
                _index += 10;
                list = getData();
            }


        }


        EventBus.getDefault().post(event_RunInFront);
    }

    private void getNewDate() {

        String date = OkHttp_LS.okhttp_get("http://115.159.123.41:8001/zhihu?date=17");
        if (date.equals("no new date")) {
            Toast.makeText(getActivity(), "没有更新的了", Toast.LENGTH_SHORT).show();
        } else if (date.equals("http get error")) {
            Toast.makeText(getActivity(), "获取请求失败,请检查网络后重试", Toast.LENGTH_SHORT).show();
        } else {


            saveNewDate(date);

        }


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void FrontEventBus(Event_RunInFront e){
        String value = e.getValue();
        if (value.equals("onRefresh")){
            adapter.notifyDataSetChanged();
            main_list.setOnRefreshComplete();
            main_list.onFinishLoading(true, false);
        }else if(value.equals("onLoadMoreItems")){

            if (e.getValue2().equals("finash")) {
                Toast.makeText(getActivity(), "没有更多了", Toast.LENGTH_SHORT).show();
                main_list.onFinishLoading(false, false);
            }else {
                adapter.notifyDataSetChanged();
                main_list.onFinishLoading(true, false);
            }
        }


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



}