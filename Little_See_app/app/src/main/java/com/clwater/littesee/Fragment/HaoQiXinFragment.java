package com.clwater.littesee.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clwater.littesee.Activity.TextInfoActivity;
import com.clwater.littesee.Adapater.DividerItemDecoration;
import com.clwater.littesee.Adapater.ListViewImageAdapter;
import com.clwater.littesee.Adapater.RecyclerAdapter;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.DBHelper.HaoQiXin;
import com.clwater.littesee.Utils.DBHelper.HaoQiXinDaoOrm;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;
import com.clwater.littesee.Utils.EventBus.Event_RunInBack;
import com.clwater.littesee.Utils.EventBus.Event_RunInFront;
import com.clwater.littesee.Utils.HttpUtils.OkHttp_LS;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
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

/**
 * Created by gengzhibo on 16/10/10.
 */

public class HaoQiXinFragment extends Fragment {

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
    HaoQiXinDaoOrm haoQinXinDaoOrm;
    RecyclerAdapter adapter;


    int _index = 10;


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
                Log.d("gzb" , "onLoadMoreItems");
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
                int index = Integer.valueOf(data) - 1;
                Map<String, Object> map= list.get(index);
                HaoQiXin haoqixin = haoQinXinDaoOrm.seleteHaoQinXin(Integer.valueOf( map.get("id").toString() ));
                haoqixin.setIsRead(1);
                haoQinXinDaoOrm.add(haoqixin);

                //upDateItemTextColor(index);
                list.clear();
                list = getData();

                adapter.notifyDataSetChanged();

                Intent intent = new Intent(getActivity() , TextInfoActivity.class);
                intent.putExtra("webImage" , map.get("title_image").toString());
                intent.putExtra("webTitle" , map.get("title").toString());
                intent.putExtra("webUrl" , map.get("address").toString());
                intent.putExtra("statu" , "haoqixin");
                startActivity(intent);
            }
        });

        //main_list.onFinishLoading(true, false);
    }

    private void saveNewDate() {
    }


    public List<Map<String, Object>> getData(){
        list.clear();
        haoQinXinDaoOrm = new HaoQiXinDaoOrm(getActivity());
        List<HaoQiXin> haoqixinList= haoQinXinDaoOrm.select();
        for (int i = 0 ; i < _index  ; i++){
        //for (int i = 0 ; i < haoqixinList.size()  ; i++){
            HaoQiXin haoQiXin = haoqixinList.get(i);
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("id" , haoQiXin.getId());
            map.put("title" , haoQiXin.getTitle());
            map.put("address" , haoQiXin.getAddress());
            map.put("title_image" , haoQiXin.getTitle_image());
            map.put("isread" , haoQiXin.getIsRead());
            list.add(map);
        }
        return list;
    }



    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void BackEventBus(Event_RunInBack e){
        sleep(3000);

        if (e.getValue().equals("onRefresh")){
            getNewDate();
        }

        Event_RunInFront event_RunInFront = new  Event_RunInFront();
        event_RunInFront.setValue(e.getValue());
        EventBus.getDefault().post(event_RunInFront);
    }

    private void getNewDate() {

        String date = OkHttp_LS.okhttp_get("http://115.159.123.41:8001/zhihu");
        if (date.equals("no new date")) {
            Toast.makeText(getActivity(), "没有更新的了", Toast.LENGTH_SHORT).show();
        } else if (date.equals("http get error")) {
            Toast.makeText(getActivity(), "获取请求失败,请检查网络后重试", Toast.LENGTH_SHORT).show();
        } else {
            saveNewDate();
            Log.d("gzb", "getNewDate: " + date);

        }


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void FrontEventBus(Event_RunInFront e){
        String value = e.getValue();
        if (value.equals("onRefresh")){
            adapter.notifyDataSetChanged();
            main_list.setOnRefreshComplete();
            main_list.onFinishLoading(true, false);
        }else if (value.equals("onLoadMoreItems")){
            _index += 10;
            list = getData();
            adapter.notifyDataSetChanged();
            main_list.onFinishLoading(true, false);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



}