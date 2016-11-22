package com.clwater.littesee.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gengzhibo on 16/11/22.
 */

public class DateUtils {

    public static int checkDate() throws ParseException {
        Date curDate = new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String today = df.format(curDate);

        long to = df.parse(today).getTime();
        long from = df.parse("2016-11-1").getTime();
        long betweendate =  (to - from) / (1000 * 60 * 60 * 24) ;
        int _betweendate = (int) betweendate;
        Log.d("gzb" , "_betweendate:" + _betweendate );
        return _betweendate;
    }
}
