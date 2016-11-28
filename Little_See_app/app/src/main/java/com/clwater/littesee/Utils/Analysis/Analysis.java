package com.clwater.littesee.Utils.Analysis;

import android.util.Log;

import com.clwater.littesee.Utils.Analysis.Bean.HttpTextBean;
import com.clwater.littesee.Utils.DBHelper.HaoQiXin;
import com.clwater.littesee.Utils.DBHelper.Image_me;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengzhibo on 16/11/18.
 */

public class Analysis {
    public static List<ZhiHu> AnalysisZhiHU(String _date){
        List<ZhiHu> zhiHuList = new ArrayList<ZhiHu>();

        Log.d("gzb" , "" + _date);
        HttpTextBean textBean = new Gson().fromJson(_date , HttpTextBean.class);
        List<HttpTextBean.DateBean> infoList = textBean.getDate();

        for (int i = 0 ; i < infoList.size() ; i ++){
            HttpTextBean.DateBean dateBean = infoList.get(i);
            ZhiHu zhihu = new ZhiHu();
            zhihu.setTitle(dateBean.getTitle());
            zhihu.setTitle_image(dateBean.getTitle_image());
            zhihu.setAddress(dateBean.getAddress());
            zhihu.setIsRead(0);
            zhiHuList.add(zhihu);
        }

        return zhiHuList;
    }


    public static List<HaoQiXin> AnalysisHaoQiXin(String _date){
        List<HaoQiXin> haoQinXinList = new ArrayList<HaoQiXin>();

        HttpTextBean textBean = new Gson().fromJson(_date , HttpTextBean.class);
        List<HttpTextBean.DateBean> infoList = textBean.getDate();

        for (int i = 0 ; i < infoList.size() ; i ++){
            HttpTextBean.DateBean dateBean = infoList.get(i);
            HaoQiXin haoqixin = new HaoQiXin();
            haoqixin.setTitle(dateBean.getTitle());
            haoqixin.setTitle_image(dateBean.getTitle_image());
            haoqixin.setAddress(dateBean.getAddress());
            haoqixin.setIsRead(0);
            haoQinXinList.add(haoqixin);
        }

        return haoQinXinList;
    }

    public static List<Image_me> AnalysisImage_me(String _date){
        List<Image_me> image_meList = new ArrayList<Image_me>();

        return image_meList;
    }
}


