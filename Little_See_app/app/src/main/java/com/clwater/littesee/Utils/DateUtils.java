package com.clwater.littesee.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gengzhibo on 16/11/22.
 */

public class DateUtils {

    public static int checkDate() {
        Date curDate = new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String today = df.format(curDate);

        long to = 0;
        long from = 0;
        int betweendate = 0;
        try {
            to = df.parse(today).getTime();
            from = df.parse("2016-11-1").getTime();
            betweendate = (int) (to - from) / (1000 * 60 * 60 * 24) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return betweendate;
    }
}
