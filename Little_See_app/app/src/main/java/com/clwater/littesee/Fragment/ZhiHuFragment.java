package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.clwater.littesee.Activity.ZhuHuInfoActivity;
import com.clwater.littesee.EventBus.Event_RunInBack;
import com.clwater.littesee.EventBus.Event_RunInFront;
import com.clwater.littesee.MainActivity;
import com.clwater.littesee.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

import static android.os.SystemClock.sleep;


public class ZhiHuFragment extends Fragment
{

    @InjectView(R.id.main_list)
    public ListView main_list;
    @InjectView(R.id.zhihu_main_top_process)
    public RelativeLayout relativeLayout;
    @InjectView(R.id.zh_top_process)
    public ProgressWheel progressWheel;
    @InjectView(R.id.zh_top_pro_text)
    public TextView pro_text;


    private static final String[] strs = new String[] {
    "1", "2", "3", "4", "5","6" ,"7" ,"8" ,"9" ,"0" ,
            "1", "2", "3", "4", "5","6" ,"7" ,"8" ,"9" ,"0",
            "1", "2", "3", "4", "5","6" ,"7" ,"8" ,"9" ,"0",
            "1", "2", "3", "4", "5","6" ,"7" ,"8" ,"9" ,"0",
            "1", "2", "3", "4", "5","6" ,"7" ,"8" ,"9" ,"0"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);
        ButterKnife.inject(this , view);

        showTopProcess();
        //main_list.setAdapter(new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, strs));

        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,     Object>>();/*在数组中存放数据*/
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.ic_menu_back);
            map.put("ItemText", "这是第"+i+"行");
            listItem.add(map);
        }

        SimpleAdapter mSimpleAdapter = new SimpleAdapter(getActivity(),listItem,//需要绑定的数据
                R.layout.listview_main_image_title,//每一行的布局//动态数组中的数据源的键对应到定义布局的View中
                 new String[] {"ItemImage", "ItemText"},
                new int[] {R.id.listview_main_image,R.id.listview_main_text});
        main_list.setAdapter(mSimpleAdapter);

        EventBus.getDefault().register(this);

        return view;
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

    @OnItemClick(R.id.main_list)
    public void itemClick(int position , View view){
        stopTopProsess();
    }



}