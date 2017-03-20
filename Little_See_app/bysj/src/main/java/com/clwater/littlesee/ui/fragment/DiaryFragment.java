package com.clwater.littlesee.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.clwater.littlesee.R;
import com.clwater.littlesee.database.BaseControl;
import com.clwater.littlesee.database.BeanDiary;
import com.clwater.littlesee.eventbus.EventBus_RunInBack;
import com.clwater.littlesee.eventbus.EventBus_RunInFront;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.ui.adapter.DiaryRecyclerViewAdapter;
import com.clwater.littlesee.utils.Analysis;
import com.clwater.littlesee.utils.Bean.DiaryBean;
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
import butterknife.OnClick;

/**
 * Created by yszsyf on 17/2/26.
 */

//每日优选
public class DiaryFragment extends Fragment {
    @BindView(R.id.recylist_diarylist) RecyclerView recycleListView;
    @BindView(R.id.imageview_list_returntop) ImageView imageview_list_returntop;
    @BindView(R.id.swipecontainer_diarylist) SwipeRefreshLayout swipecontainer_diarylist;
    @BindView(R.id.textview_diary_finish) TextView textview_diary_finish;
    @BindView(R.id.textview_diary_nodate) TextView textview_diary_nodate;

    List<DiaryBean.DateBean> _DiaryList = new ArrayList<DiaryBean.DateBean>();
    List<DiaryBean.DateBean> _ShowDiaryList = new ArrayList<DiaryBean.DateBean>();
    DiaryRecyclerViewAdapter dairyAdapter;
    private String _result;

    private int _baseLastItem;
    private boolean _baseLastItemStatu = true;
    private boolean _allDateLoad = false;
    private boolean _getNewDate = false;
    private boolean _getINNewDate = true;
    private int newDateCount = 0 ;
    private int showDateCount = 0;
    private final int DIARYLIST_EVERY_COUNT = 50;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        ButterKnife.bind(this , view);
        EventBus.getDefault().register(this);


        checkIndexClass();      //判断是否选择了对应的栏目
        init();
        initList();
        QueryData();           //查询本地数据库 查看是否有数据

        swipecontainer_diarylist.setRefreshing(true);
        getDataFromServer();

        return view;
    }

    private void init() {
        swipecontainer_diarylist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (_getINNewDate) {
                    _getINNewDate = false;
                    getDataFromServer();
                }
            }
        });
        swipecontainer_diarylist.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);


    }



    private void checkIndexClass() {
        if (SPHelper.getStringValue(getActivity() , "diary_class").isEmpty()){
            Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
            startActivity(intent);
        }

    }


    private void initList() {
        recycleListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dairyAdapter = new DiaryRecyclerViewAdapter(getActivity() , _ShowDiaryList);
        recycleListView.setAdapter(dairyAdapter);
        recycleListView.addItemDecoration(new ItemDecoration(getActivity()));
        recycleListView.addOnScrollListener(new DiaryListOnScroll());

    }

    @OnClick(R.id.imageview_list_returntop)
    public void imageview_list_returntop_onclick(){
        recycleListView.smoothScrollToPosition(0);
    }

    private void getDataFromServer() {
        EventBus.getDefault().post(new EventBus_RunInBack("diary_getDataFromServer"));
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventbusNetwork(EventBus_RunInBack e){
        if (e.getTag().equals("diary_getDataFromServer") ){

            String url = WebContent.ServerAddress + "/diary?indexclass=('知乎日报','好奇心日报')";
            _result = OkHttpUtils.okhttp_get(url);
            List<DiaryBean.DateBean> _ReasultDiaryList = Analysis.AnalysisDiary(_result);
            saveDate(_ReasultDiaryList);
            updatefromServer();

            EventBus.getDefault().post(new EventBus_RunInFront("diary_getDataFromServer_Finish"));
        }

    }

    private void updatefromServer() {
        LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
        List list = liteOrm.query(BeanDiary.class);
        if (newDateCount > 0) {
            LoadDate(list);
        }

        for (int i = 0 ; i < newDateCount ; i ++){
            _ShowDiaryList.add(i , _DiaryList.get(i));
        }
        showDateCount += newDateCount;
        newDateCount = 0;


    }

    private void QueryData() {
        EventBus.getDefault().post(new EventBus_RunInBack("diaryQueryData"));
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void EventBus_QueryData(EventBus_RunInBack e ){
        if (e.getTag().equals("diaryQueryData")){
            LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
            List list = liteOrm.query(BeanDiary.class);
            if (list.size() >= 0){
                LoadDate(list);
                SelectShowDate();
            }
        }else if (e.getTag().equals("diaryQueryDataAgain")){
            SelectShowDate();
        }
    }

    private void SelectShowDate() {
        int increment  = DIARYLIST_EVERY_COUNT ;
        if ( ( _DiaryList.size()  - showDateCount ) < DIARYLIST_EVERY_COUNT){
            increment = _DiaryList.size() - showDateCount ;
        }


        //Log.d("gzb", "showDateCount: " + showDateCount);
        if ( _DiaryList.size() - showDateCount  < 1){
            _allDateLoad = true;
        }

        for (int i = 0 ; i < increment ; i++ , showDateCount++){
            _ShowDiaryList.add(_DiaryList.get(showDateCount));
        }

        if (!_allDateLoad) {
            showDiaryListDate();
        }else {
            EventBus.getDefault().post(new EventBus_RunInFront("diary_showDiaryListDate_Error"));
        }

        if ( showDateCount == 0){
            EventBus.getDefault().post(new EventBus_RunInFront("diary_showDiaryListDate_Error2"));
        }
    }

    private void showDiaryListDate() {
        EventBus.getDefault().post(new EventBus_RunInFront("diary_showDiaryListDate"));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventBus_showDiaryListDate(EventBus_RunInFront e){
        if (e.getTag().equals("diary_showDiaryListDate")){
            ChangeList();
        }else if (e.getTag().equals("diary_showDiaryListDate_Error")){
//            Toast.makeText(getActivity() , "没有更多的了" , Toast.LENGTH_SHORT).show();
            if (showDateCount != 0) {
                textview_diary_finish.setVisibility(View.VISIBLE);
            }
        }else if (e.getTag().equals("diary_getDataFromServer_Finish")){
            if (_ShowDiaryList.size() == 0){
                textview_diary_nodate.setVisibility(View.VISIBLE);
            }else {
                textview_diary_nodate.setVisibility(View.GONE);
            }

            ChangeList();
            _getINNewDate = true;
            swipecontainer_diarylist.setRefreshing(false);
        }else if (e.getTag().equals("diary_showDiaryListDate_Error2")){
            textview_diary_finish.setVisibility(View.GONE);
        }
    }

    private void ChangeList() {
        dairyAdapter.notifyDataSetChanged();
    }

    private void LoadDate(List list) {
        for (int i = 0 ; i < list.size() ; i++){
            BeanDiary _beanDiary = (BeanDiary) list.get(i);

            DiaryBean.DateBean _diaryBean = new DiaryBean.DateBean();
            _diaryBean.setTitle(_beanDiary.getTitle());
            _diaryBean.setAddress(_beanDiary.getAddress());
            _diaryBean.setImage(_beanDiary.getImage());
            _diaryBean.setIndexclass(_beanDiary.getIndexclass());
            _DiaryList.add(_diaryBean);
        }
        Collections.reverse(_DiaryList);
    }

    private void saveDate(List<DiaryBean.DateBean> _ReasultDiaryList) {
        LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
        for (DiaryBean.DateBean data : _ReasultDiaryList){
            List<BeanDiary> beanDiaryList = liteOrm.query(new QueryBuilder<BeanDiary>(BeanDiary.class)
                    .whereEquals("title", data.getTitle()));
            if (beanDiaryList.size() == 0){
                _getNewDate = true;
                newDateCount++;
                BeanDiary beanDiary = new BeanDiary(data.getTitle(), data.getImage(), data.getAddress(), data.getIndexclass());
                liteOrm.save(beanDiary);
            }
        }



    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventbusNetworkinMain(EventBus_RunInFront e){
        if (e.getTag().equals("diary")) {
            initList();
            swipecontainer_diarylist.setRefreshing(false);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    class DiaryListOnScroll extends RecyclerView.OnScrollListener{
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy < 0){
                textview_diary_finish.setVisibility(View.GONE);
            }

            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                int lastItemPosition = linearManager.findLastVisibleItemPosition();
                int firstItemPosition = linearManager.findFirstVisibleItemPosition();

                if (_baseLastItemStatu){
                    _baseLastItem = lastItemPosition;
                    _baseLastItemStatu = false;
                }

                if (firstItemPosition > _baseLastItem){
                    chageReturnIcon(true);

                }else {
                    chageReturnIcon(false);
                }

                if (lastItemPosition == showDateCount - 1){
                    //Log.d("gzb" , "加载更多" );
                    //Toast.makeText(getActivity() , "加载更多" , Toast.LENGTH_SHORT).show();
                    EventBus.getDefault().post(new EventBus_RunInBack("diaryQueryDataAgain"));
                }

            }
        }

    }

    private void chageReturnIcon(boolean b) {
        if (b) {
            imageview_list_returntop.setVisibility(View.VISIBLE);
        }else {
            imageview_list_returntop.setVisibility(View.GONE);
        }
    }


}



