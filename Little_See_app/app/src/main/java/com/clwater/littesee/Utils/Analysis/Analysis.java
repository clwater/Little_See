package com.clwater.littesee.Utils.Analysis;

import android.util.Log;

import com.clwater.littesee.Utils.Analysis.Bean.HttpImageBean;
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
<<<<<<< Updated upstream
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

=======
        Log.d("gzb" , _date);
        List<ZhiHu> zhiHuList = null;

        String JSON_DATA = "{\n" +
                "    \"id\": 100,\n" +
                "    \"body\": \"It is my post\",\n" +
                "    \"number\": 0.13,\n" +
                "    \"created_at\": \"2014-05-22 19:12:38\"\n" +
                "}";
        TextBean textBean = new Gson().fromJson(_date , TextBean.class);
//


        Log.d("gzb" , "textBean.statu:" + textBean.statu);
//       // Log.d("gzb" , "" + foos[1].text_date.title);
//
//        Text_date[] t = new Gson().fromJson(String.valueOf(textBean.date), Text_date[].class);
//
//        Log.d("gzb" , "" + t[1].title);
>>>>>>> Stashed changes
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

    public static List<Image_me> AnalysisImage_me_bing(String _date){
        List<Image_me> image_meList = new ArrayList<Image_me>();

        HttpImageBean textBean = new Gson().fromJson(_date , HttpImageBean.class);
        List<HttpImageBean.DateBean> infoList = textBean.getDate();

        for (int i = 0 ; i < infoList.size() ; i ++){
            HttpImageBean.DateBean dateBean = infoList.get(i);
            Image_me image_me = new Image_me();
            image_me.setHref(dateBean.getHref());
            image_me.setStatu("bing");
            image_meList.add(image_me);
        }

        return image_meList;
    }
}


