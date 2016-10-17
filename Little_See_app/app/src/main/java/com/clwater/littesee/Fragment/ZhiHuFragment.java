package com.clwater.littesee.Fragment;

/**
 * Created by gengzhibo on 16/10/10.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.clwater.littesee.Activity.ZhuHuInfoActivity;
import com.clwater.littesee.Adapater.ListViewImageAdapter;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;
import com.clwater.littesee.Utils.EventBus.Event_RunInBack;
import com.clwater.littesee.Utils.EventBus.Event_RunInFront;
import com.clwater.littesee.R;
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

    public static Activity activity;
    private boolean precess_statu = true;

    List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    ZhiHuDaoOrm zhiHuDaoOrm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);
        ButterKnife.inject(this , view);

        showTopProcess();
        precess_statu = true;

        activity = getActivity();

        initListview();


        EventBus.getDefault().register(this);

        return view;
    }

    private void initListview() {
        List<Map<String, Object>> list=getData();
        main_list.setAdapter(new ListViewImageAdapter(getActivity(), list));
    }

    public List<Map<String, Object>> getData(){

        zhiHuDaoOrm = new ZhiHuDaoOrm(getActivity());
        List<ZhiHu> zhihuList= zhiHuDaoOrm.select();
        for (int i = 0 ; i < zhihuList.size() ; i++){
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

    @OnItemClick(R.id.main_list)
    public void itemClick(int position , View view){
        if (precess_statu) {
            stopTopProsess();
            precess_statu = false;
        }

        Map<String, Object> map= list.get(position);
        ZhiHu zhihu = zhiHuDaoOrm.seleteZhiHu(Integer.valueOf( map.get("id").toString() ));
        zhihu.setIsRead(1);
        zhiHuDaoOrm.add(zhihu);

        Intent intent = new Intent(getActivity() , ZhuHuInfoActivity.class);
        intent.putExtra("webImage" , map.get("title_image").toString());
        intent.putExtra("webTitle" , map.get("title").toString());
        intent.putExtra("webUrl" , map.get("address").toString());

        startActivity(intent);

    }



}