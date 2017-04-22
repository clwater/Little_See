package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.clwater.littlesee.R;
import com.clwater.littlesee.database.BaseControl;
import com.clwater.littlesee.database.BeanImage;
import com.clwater.littlesee.eventbus.EventBus_RunInBack;
import com.clwater.littlesee.eventbus.EventBus_RunInFront;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.ui.adapter.DiaryRecyclerViewAdapter;
import com.clwater.littlesee.ui.adapter.ImageRecyclerViewAdapter;
import com.clwater.littlesee.utils.Analysis;
import com.clwater.littlesee.utils.Bean.ImageBean;
import com.clwater.littlesee.utils.OkHttpUtils;
import com.clwater.littlesee.utils.SPHelper;
import com.clwater.littlesee.utils.WebContent;
import com.clwater.littlesee.weight.ItemDecoration;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/2/26.
 */
//佳景
public class ImageFragment extends Fragment {
    @BindView(R.id.recylist_imagelist) RecyclerView recycleListView;
    @BindView(R.id.swipecontainer_imagelist) SwipeRefreshLayout swipecontainer_imagelist;


    private boolean _getINNewDate = true;
    private ImageRecyclerViewAdapter dairyAdapter;

    List<ImageBean.DateBean> _ImageList = new ArrayList<ImageBean.DateBean>();

    private String _result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this , view);
        EventBus.getDefault().register(this);
        setHasOptionsMenu(true);



        getDataFromServer();
        init();
        initList();



        updatefromServer();
        return view;
    }


    private void initList() {
        recycleListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dairyAdapter = new ImageRecyclerViewAdapter(getActivity() , _ImageList);
        recycleListView.setAdapter(dairyAdapter);
        recycleListView.addItemDecoration(new ItemDecoration(getActivity()));
//        recycleListView.addOnScrollListener(new DiaryListOnScroll());

    }

    private void init() {
        swipecontainer_imagelist.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
    }

    private void getDataFromServer() {
        swipecontainer_imagelist.setRefreshing(true);
        EventBus.getDefault().post(new EventBus_RunInBack("image_getDataFromServer"));

    }



    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventbusNetwork(EventBus_RunInBack e){
        if (e.getTag().equals("image_getDataFromServer") ){

            String r = SPHelper.getImageclass(getActivity());
            String[] rr = r.split(",");
            String _indexclass = "";
            for (int i = 0 ; i < rr.length - 1 ; i++){
                _indexclass = _indexclass + "\'" + rr[i] + "\',";
            }
            _indexclass = _indexclass + "\'" + rr[rr.length - 1] + "\'";
            String url = WebContent.ServerAddress + "/image?indexclass=(" + _indexclass+ ")";

//            Log.d("gzb" , url);
            _result = OkHttpUtils.okhttp_get(url);
//            Log.d("gzb" , "_result" + _result);
            String dateResult = Analysis.CheckDateStatu_Image(_result);
            if (dateResult.equals("1")){
                Log.d("gzb" , "today is no date");
            }else {
                List<ImageBean.DateBean> _ReasultDiaryList = Analysis.AnalysisImage(_result);
                Collections.reverse(_ReasultDiaryList);
                saveDate(_ReasultDiaryList);
                updatefromServer();
            }
            EventBus.getDefault().post(new EventBus_RunInFront("image_getDataFromServer_Finish"));
        }



    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventBus_showDiaryListDate(EventBus_RunInFront e){

        if (e.getTag().equals("image_getDataFromServer_Finish")){


            ChangeList();
            _getINNewDate = true;
            swipecontainer_imagelist.setRefreshing(false);
        }
    }

    private void ChangeList() {
        dairyAdapter.notifyDataSetChanged();
    }




    private void updatefromServer() {
        LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
        QueryBuilder qb = new QueryBuilder(BeanImage.class).appendOrderDescBy("id");
        List list = liteOrm.query(qb);


        _ImageList.clear();

        Log.d("gzb" , "" + list.size());

        for (int i = 0 ;i < list.size() ; i++){


            BeanImage b =  (BeanImage)list.get(i);

//            Log.d("gzb" , b.getAddress());
            ImageBean.DateBean d = new ImageBean.DateBean();
            d.setAddress(b.getAddress());
            d.setIndexclass(b.getIndexclass());
            d.setText(b.getText());
            _ImageList.add(d);
        }

        EventBus.getDefault().post(new EventBus_RunInFront("image_getDataFromServer_Finish"));

    }


    private void saveDate(List<ImageBean.DateBean> _ReasultDiaryList) {
        LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
        for (ImageBean.DateBean data : _ReasultDiaryList){
            List<BeanImage> beanDiaryList = liteOrm.query(new QueryBuilder<BeanImage>(BeanImage.class)
                    .whereEquals("address", data.getAddress()));
            if (beanDiaryList.size() == 0){
//                newDateCount++;
                BeanImage beanImage = new BeanImage(data.getAddress(), data.getText(), data.getIndexclass());
                liteOrm.save(beanImage);
            }
        }

    }


    private void checkIndexClass() {
        String a = SPHelper.getImageclass(getActivity());
//        Log.d("gzb" , "a :" +a);
        if (a.isEmpty()){
            inChooseItemActivity();
        }else {
            getDataFromServer();
        }

    }

    private void inChooseItemActivity(){
        Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
        intent.putExtra("index" , "image" );
        startActivity(intent);
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        final MenuItem fav;
        fav = menu.add("话题");
        fav.setIcon(R.drawable.ic_launcher);
        //fav.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        fav.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                inChooseItemActivity();
                return false;
            }
        });
    }



    @Override
    public void onResume() {
        super.onResume();
        checkIndexClass();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



}