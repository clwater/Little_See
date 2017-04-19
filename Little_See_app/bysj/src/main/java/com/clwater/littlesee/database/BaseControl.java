package com.clwater.littlesee.database;

import android.content.Context;

import com.litesuits.orm.LiteOrm;

/**
 * Created by yszsyf on 17/3/18.
 */

public class BaseControl {

    static LiteOrm liteOrm;

    public static LiteOrm Initialize(Context context){
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(context, "littlesee.db");
        }
        liteOrm.setDebugged(true);
        return liteOrm;
    }
}
