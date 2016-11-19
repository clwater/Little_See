package com.clwater.littesee.Utils.Analysis;

import android.util.Log;

import com.clwater.littesee.Utils.Analysis.Bean.HttpTextBean;
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
}


