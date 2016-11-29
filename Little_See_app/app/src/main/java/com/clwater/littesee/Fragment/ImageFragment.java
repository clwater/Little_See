package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clwater.littesee.Activity.TextInfoActivity;
import com.clwater.littesee.Adapater.DividerItemDecoration;
import com.clwater.littesee.Adapater.RecyclerAdapter;
import com.clwater.littesee.R;
import com.clwater.littesee.Utils.Analysis.Analysis;
import com.clwater.littesee.Utils.Analysis.SaveDate;
import com.clwater.littesee.Utils.DBHelper.Image_me;
import com.clwater.littesee.Utils.DBHelper.Image_me;
import com.clwater.littesee.Utils.DBHelper.Image_meDaoOrm;
import com.clwater.littesee.Utils.DateUtils;
import com.clwater.littesee.Utils.EventBus.Event_RunInBack;
import com.clwater.littesee.Utils.EventBus.Event_RunInFront;
import com.clwater.littesee.Utils.HttpUtils.OkHttp_LS;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;

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

public class ImageFragment extends Fragment {


    @InjectView(R.id.main_list)
    public com.lhh.ptrrv.library.PullToRefreshRecyclerView main_list;
    @InjectView(R.id.empty_list)
    public TextView empty_list;
    @InjectView(R.id.main_bottom_loading)
    public LinearLayout main_bottom_loading;

    public static Activity activity;
    private boolean precess_statu = true;

    List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    Image_meDaoOrm image_meDaoOrm;
    RecyclerAdapter adapter;

    boolean _chageDate = false;
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
        main_bottom_loading.setVisibility(View.GONE);

        EventBus.getDefault().register(this);


        return view;
    }

    private void initListview() {
        list = getData();


        main_list.setSwipeEnable(true);
        main_list.getRecyclerView().addItemDecoration(new DividerItemDecoration(getActivity() , 1));


        main_list.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                main_bottom_loading.setVisibility(View.VISIBLE);
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
                Image_me image_me = image_meDaoOrm.seleteImage_me(Integer.valueOf( map.get("id").toString() ));
                image_meDaoOrm.add(image_me);

                //upDateItemTextColor(index);
                list.clear();
                list = getData();

                adapter.notifyDataSetChanged();

                Intent intent = new Intent(getActivity() , TextInfoActivity.class);
                intent.putExtra("href" , map.get("href").toString());
                startActivity(intent);
            }
        });

        main_list.onFinishLoading(true, false);

        if (list.size() >= 1){
            empty_list.setVisibility(View.GONE);
        }
    }

    private void saveNewDate(String date) {
        List<Image_me> _image_me = Analysis.AnalysisImage_me_bing(date);
        int changeDate = SaveDate.imageDateSave(_image_me);
        if (changeDate > 0) {
            list = getData();
            _chageDate = true;
        } else {
            _chageDate = false;
        }


    }


    public List<Map<String, Object>> getData(){
        list.clear();
        image_meDaoOrm = new Image_meDaoOrm(getActivity());
        List<Image_me> image_meList= image_meDaoOrm.select();
        index_size = image_meList.size();
        for (int i = 0 ; i < _index  ; i++){
            if (i < index_size) {
                Image_me image_Me = image_meList.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", image_Me.getId());
                map.put("href", image_Me.getHref());
                map.put("statu", image_Me.getStatu());

                list.add(map);
            }
        }

        if (list.size() < 1){
            empty_list.setVisibility(View.VISIBLE);
        }else {
            empty_list.setVisibility(View.GONE);
        }


        return list;
    }



    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void BackEventBus(Event_RunInBack e){

        sleep(1000);

        Event_RunInFront event_RunInFront = new  Event_RunInFront();
        event_RunInFront.setValue(e.getValue());

        if (e.getValue().equals("onRefresh")){
            getNewDate();
            if (_chageDate == true){
                event_RunInFront.setValue2("new");
            }else {
                event_RunInFront.setValue2("unnew");
            }
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
        int bewdate = 0 ;

        bewdate = DateUtils.checkDate__image_bing();
        String url = "http://115.159.123.41:8001/image?statu=bing&date=" + bewdate;
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


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void FrontEventBus(Event_RunInFront e){
        String value = e.getValue();
        if (value.equals("onRefresh")){
            if (e.getValue2().equals("new")) {
                adapter.notifyDataSetChanged();
            }else {
                Toast.makeText(getActivity(), "已获得最新数据", Toast.LENGTH_SHORT).show();
            }
            main_list.setOnRefreshComplete();
            main_list.onFinishLoading(true, false);
        }else if(value.equals("onLoadMoreItems")){
            main_bottom_loading.setVisibility(View.GONE);
            if (e.getValue2().equals("finash")) {
                Toast.makeText(getActivity(), "没有更多了", Toast.LENGTH_SHORT).show();
                main_list.onFinishLoading(false, false);
            }else {
                adapter.notifyDataSetChanged();
                main_list.onFinishLoading(true, false);
            }
        }

        if (list.size() >= 1){
            empty_list.setVisibility(View.GONE);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



}