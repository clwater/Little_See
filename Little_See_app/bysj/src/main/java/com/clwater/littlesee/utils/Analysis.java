package com.clwater.littlesee.utils;

import android.util.Log;

import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.clwater.littlesee.utils.Bean.DiaryClassBean;
import com.clwater.littlesee.utils.Bean.ImageBean;
import com.clwater.littlesee.utils.Bean.NewsBean;
import com.clwater.littlesee.utils.Bean.ResultBean;
import com.clwater.littlesee.utils.Bean.ResultBean_image;
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
        Log.d("gzb" , _result);
        ResultBean resultBean = new Gson().fromJson(_result , ResultBean.class);
        return resultBean.getStatu();
    }


    public static String CheckDateStatu_Image(String _result){
        Log.d("gzb" , _result);
        ResultBean_image resultBean = new Gson().fromJson(_result , ResultBean_image.class);
        return resultBean.getStatu();
    }

    public static List<DiaryBean.DateBean> AnalysisDiary(String _result){
        DiaryBean textBean = new Gson().fromJson(_result , DiaryBean.class);
        List<DiaryBean.DateBean> infoList = textBean.getDate();
        return infoList;
    }

    public static List<ImageBean.DateBean> AnalysisImage(String _result){
        ImageBean textBean = new Gson().fromJson(_result , ImageBean.class);
        List<ImageBean.DateBean> infoList = textBean.getDate();
        return infoList;
    }

    public static List<NewsBean.DateBean> AnalysisNews(String _result){
//        _result = _result.replace("artiList(" , "");
//        _result = _result.substring(0 , _result.length()  - 1 );
        Log.d("gzb" , _result);
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
