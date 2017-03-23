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
import android.widget.ImageView;
import android.widget.TextView;


import com.clwater.littlesee.R;
import com.clwater.littlesee.database.BaseControl;
import com.clwater.littlesee.database.BeanNews;
import com.clwater.littlesee.eventbus.EventBus_RunInBack;
import com.clwater.littlesee.eventbus.EventBus_RunInFront;
import com.clwater.littlesee.ui.activity.ChooseItemActivity;
import com.clwater.littlesee.ui.adapter.NewsRecyclerViewAdapter;
import com.clwater.littlesee.utils.Analysis;
import com.clwater.littlesee.utils.Bean.NewsBean;
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
//即刻
public class NewsFragment extends Fragment {


    @BindView(R.id.recylist_newslist) RecyclerView recycleListView;
    @BindView(R.id.imageview_list_returntop)
    ImageView imageview_list_returntop;
    @BindView(R.id.swipecontainer_newslist) SwipeRefreshLayout swipecontainer_newslist;
    @BindView(R.id.textview_news_finish)
    TextView textview_news_finish;
    @BindView(R.id.textview_news_nodate) TextView textview_news_nodate;

    List<NewsBean.DateBean> _NewsList = new ArrayList<NewsBean.DateBean>();
    List<NewsBean.DateBean> _ShowNewsList = new ArrayList<NewsBean.DateBean>();
    NewsRecyclerViewAdapter newsAdapter;
    private String _result;

    private int _baseLastItem;
    private boolean _baseLastItemStatu = true;
    private boolean _allDateLoad = false;
    private boolean _getINNewDate = true;
    private int newDateCount = 0 ;
    private int showDateCount = 0;
    private final int NEWSLIST_EVERY_COUNT = 50;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this , view);
        EventBus.getDefault().register(this);
        setHasOptionsMenu(true);



        //checkIndexClass();      //判断是否选择了对应的栏目
        init();
        initList();
        QueryData();           //查询本地数据库 查看是否有数据


        return view;
    }


    private void init() {
        swipecontainer_newslist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (_getINNewDate) {
                    _getINNewDate = false;
                    getDataFromServer();
                }
            }
        });
        swipecontainer_newslist.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
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

    private void checkIndexClass() {
        String a = SPHelper.getNewsclass(getActivity());
//        Log.d("gzb" , "a :" +a);
        if (a.isEmpty()){
            inChooseItemActivity();
        }else {
           // getDataFromServer();
        }

    }

    private void inChooseItemActivity(){
        Intent intent = new Intent(this.getActivity() , ChooseItemActivity.class);
        intent.putExtra("index" , "news");
        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();
        checkIndexClass();
    }

    private void initList() {
        recycleListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsAdapter = new NewsRecyclerViewAdapter(getActivity() , _ShowNewsList);
        recycleListView.setAdapter(newsAdapter);
        recycleListView.addItemDecoration(new ItemDecoration(getActivity()));
        recycleListView.addOnScrollListener(new NewsFragment.NewsListOnScroll());

    }

    @OnClick(R.id.imageview_list_returntop)
    public void imageview_list_returntop_onclick(){
        recycleListView.smoothScrollToPosition(0);
    }

    private void getDataFromServer() {
        swipecontainer_newslist.setRefreshing(true);
        EventBus.getDefault().post(new EventBus_RunInBack("news_getDataFromServer"));
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventbusNetwork(EventBus_RunInBack e){
        if (e.getTag().equals("news_getDataFromServer") ){

            String r = SPHelper.getNewsclass(getActivity());
            String[] rr = r.split(",");
            String _indexclass = "";
            for (int i = 0 ; i < rr.length - 1 ; i++){
                _indexclass = _indexclass + "\'" + rr[i] + "\',";
            }

            _indexclass = _indexclass + "\'" + rr[rr.length - 1] + "\'";

            String url = WebContent.ServerAddress + "/news?indexclass=(" + _indexclass+ ")";

            Log.d("gzb" , url);
            _result = OkHttpUtils.okhttp_get(url);
            String dateResult = Analysis.CheckDateStatu(_result);
            if (dateResult.equals("1")){
                Log.d("gzb" , "today is no date");
            }else {
                List<NewsBean.DateBean> _ReasultNewsList = Analysis.AnalysisNews(_result);
                saveDate(_ReasultNewsList);
                updatefromServer();
            }
            EventBus.getDefault().post(new EventBus_RunInFront("news_getDataFromServer_Finish"));
        }

    }

    private void updatefromServer() {
        LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
        List list = liteOrm.query(BeanNews.class);
        if (newDateCount > 0) {
            LoadDate(list);
        }

        for (int i = 0 ; i < newDateCount ; i ++){
            _ShowNewsList.add(i , _NewsList.get(i));
        }
        showDateCount += newDateCount;
        newDateCount = 0;


    }

    private void QueryData() {
        EventBus.getDefault().post(new EventBus_RunInBack("newsQueryData"));
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void EventBus_QueryData(EventBus_RunInBack e ){
        if (e.getTag().equals("newsQueryData")){
            LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
            List list = liteOrm.query(BeanNews.class);
            if (list.size() >= 0){
                LoadDate(list);
                SelectShowDate();
            }
        }else if (e.getTag().equals("newsQueryDataAgain")){
            SelectShowDate();
        }
    }

    private void SelectShowDate() {
        int increment  = NEWSLIST_EVERY_COUNT ;
        if ( ( _NewsList.size()  - showDateCount ) < NEWSLIST_EVERY_COUNT){
            increment = _NewsList.size() - showDateCount ;
        }


        //Log.d("gzb", "showDateCount: " + showDateCount);
        if ( _NewsList.size() - showDateCount  < 1){
            _allDateLoad = true;
        }

        for (int i = 0 ; i < increment ; i++ , showDateCount++){
            _ShowNewsList.add(_NewsList.get(showDateCount));
        }

        if (!_allDateLoad) {
            showNewsListDate();
        }else {
            EventBus.getDefault().post(new EventBus_RunInFront("news_showNewsListDate_Error"));
        }

        if ( showDateCount == 0){
            EventBus.getDefault().post(new EventBus_RunInFront("news_showNewsListDate_Error2"));
        }
    }

    private void showNewsListDate() {
        EventBus.getDefault().post(new EventBus_RunInFront("news_showNewsListDate"));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventBus_showNewsListDate(EventBus_RunInFront e){
        if (e.getTag().equals("news_showNewsListDate")){
            ChangeList();
        }else if (e.getTag().equals("news_showNewsListDate_Error")){
//            Toast.makeText(getActivity() , "没有更多的了" , Toast.LENGTH_SHORT).show();
            if (showDateCount != 0) {
                textview_news_finish.setVisibility(View.VISIBLE);
            }
        }else if (e.getTag().equals("news_getDataFromServer_Finish")){
            if (_ShowNewsList.size() == 0){
                textview_news_nodate.setVisibility(View.VISIBLE);
            }else {
                textview_news_nodate.setVisibility(View.GONE);
            }

            ChangeList();
            _getINNewDate = true;
            swipecontainer_newslist.setRefreshing(false);
        }else if (e.getTag().equals("news_showNewsListDate_Error2")){
            textview_news_finish.setVisibility(View.GONE);
        }
    }

    private void ChangeList() {
        newsAdapter.notifyDataSetChanged();
    }

    private void LoadDate(List list) {
        for (int i = 0 ; i < list.size() ; i++){
            BeanNews _beanNews = (BeanNews) list.get(i);

            NewsBean.DateBean _newsBean = new NewsBean.DateBean();
            _newsBean.setTitle(_beanNews.getTitle());
            _newsBean.setAddress(_beanNews.getAddress());
            _newsBean.setImage(_beanNews.getImage());
            _newsBean.setIndexclass(_beanNews.getIndexclass());
            _NewsList.add(_newsBean);
        }
        Collections.reverse(_NewsList);
    }

    private void saveDate(List<NewsBean.DateBean> _ReasultNewsList) {
        LiteOrm liteOrm = new BaseControl().Initialize(getActivity());
        for (NewsBean.DateBean data : _ReasultNewsList){
            List<BeanNews> beanNewsList = liteOrm.query(new QueryBuilder<BeanNews>(BeanNews.class)
                    .whereEquals("title", data.getTitle()));
            if (beanNewsList.size() == 0){
                newDateCount++;
                BeanNews beanNews = new BeanNews(data.getTitle(), data.getImage(), data.getAddress(), data.getIndexclass());
                liteOrm.save(beanNews);
            }
        }



    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventbusNetworkinMain(EventBus_RunInFront e){
        if (e.getTag().equals("news")) {
            initList();
            swipecontainer_newslist.setRefreshing(false);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    class NewsListOnScroll extends RecyclerView.OnScrollListener{
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy < 0){
                textview_news_finish.setVisibility(View.GONE);
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
                    EventBus.getDefault().post(new EventBus_RunInBack("newsQueryDataAgain"));
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