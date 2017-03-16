package com.clwater.littlesee.utils;

import android.util.Log;

import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.List;

/**
 * Created by yszsyf on 17/3/17.
 */

public class Analysis {
    public static List<DiaryBean.DateBean> AnalysisDiary(String _result){
        DiaryBean textBean = new Gson().fromJson(_result , DiaryBean.class);
        List<DiaryBean.DateBean> infoList = textBean.getDate();
        return infoList;
    }
}
