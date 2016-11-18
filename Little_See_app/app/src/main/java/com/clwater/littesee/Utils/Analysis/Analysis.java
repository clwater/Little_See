package com.clwater.littesee.Utils.Analysis;

import android.util.Log;

import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by gengzhibo on 16/11/18.
 */

public class Analysis {
    public static List<ZhiHu> AnalysisZhiHU(String _date){
        List<ZhiHu> zhiHuList = null;

//        String JSON_DATA = "{\n" +
//                "    \"id\": 100,\n" +
//                "    \"body\": \"It is my post\",\n" +
//                "    \"number\": 0.13,\n" +
//                "    \"created_at\": \"2014-05-22 19:12:38\"\n" +
//                "}";
        TextBean textBean = new Gson().fromJson(_date , TextBean.class);
//
        Log.d("gzb" , "textBean.statu:" + textBean.date);
//       // Log.d("gzb" , "" + foos[1].text_date.title);
//
//        Text_date[] t = new Gson().fromJson(String.valueOf(textBean.date), Text_date[].class);
//
//        Log.d("gzb" , "" + t[1].title);
        return zhiHuList;
    }
}


class TextBean {
    public String statu;
    public Text_date date;

    public class Text_date{
        public String title;
        public String title_image;
        public String address;
    }
}


