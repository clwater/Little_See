package com.clwater.littlesee.utils;

import android.util.Log;

import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.clwater.littlesee.utils.Bean.DiaryClassBean;
import com.clwater.littlesee.utils.Bean.NewsBean;
import com.clwater.littlesee.utils.Bean.ResultBean;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.List;

/**
 * Created by yszsyf on 17/3/17.
 */

public class Analysis {

    public static String CheckDateStatu(String _result){
        ResultBean resultBean = new Gson().fromJson(_result , ResultBean.class);
        return resultBean.getStatu();
    }

    public static List<DiaryBean.DateBean> AnalysisDiary(String _result){
        DiaryBean textBean = new Gson().fromJson(_result , DiaryBean.class);
        List<DiaryBean.DateBean> infoList = textBean.getDate();
        return infoList;
    }

    public static List<NewsBean.DateBean> AnalysisNews(String _result){
        NewsBean textBean = new Gson().fromJson(_result , NewsBean.class);
        List<NewsBean.DateBean> infoList = textBean.getDate();
        return infoList;
    }

    public static String[] AnalysisDiaryClass(String _result){
        DiaryClassBean diaryClassBean = new Gson().fromJson(_result , DiaryClassBean.class);
        String[] diaryClass = diaryClassBean.getDirayClass();
        return diaryClass;
    }
}
