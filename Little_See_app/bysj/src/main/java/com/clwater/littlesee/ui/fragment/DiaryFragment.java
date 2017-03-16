package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.clwater.littlesee.R;
import com.clwater.littlesee.eventbus.EventBus_Network;
import com.clwater.littlesee.eventbus.EventBus_Network_Main;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.utils.Analysis;
import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.clwater.littlesee.utils.OkHttpUtils;
import com.clwater.littlesee.utils.SPHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/2/26.
 */

//每日优选
public class DiaryFragment extends Fragment {
    @BindView(R.id.recylist_diarylist)
    RecyclerView recycleListView;

    List<DiaryBean.DateBean> _DiaryList = new ArrayList<DiaryBean.DateBean>();

    private String _result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        ButterKnife.bind(this , view);
        EventBus.getDefault().register(this);

        if (SPHelper.getStringValue(getActivity() , "diary_class").isEmpty()){
            Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
           // startActivity(intent);
        }


        getDataFromServer();

        return view;
    }

    private void getDataFromServer() {
        EventBus.getDefault().post(new EventBus_Network("diary"));

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventbusNetwork(EventBus_Network e){
        String url = "http://192.168.1.101:9007/diary?indexclass=('zhihu','haoqixin')";
        _result = OkHttpUtils.okhttp_get(url);



        Log.d("gzb" , "_result : " + _result);

        _DiaryList = Analysis.AnalysisDiary(_result);

        for( DiaryBean.DateBean _dairy :_DiaryList){
            Log.d("gzb" , _dairy.getTitle());
        }


        //EventBus.getDefault().post(new EventBus_Network_Main("diary"));

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventbusNetworkinMain(EventBus_Network_Main e){

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



}