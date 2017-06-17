package com.clwater.littlesee.personas;

/**
 * Created by yszsyf on 2017/3/29.
 */

public class Utils {
    private static volatile Utils instance=null;
    private Utils (){}
    public static  Utils getInstance(){
        if(instance==null){
            synchronized(Utils .class){
                if(instance==null){
                    instance=new Utils ();
                }
            }
        }
        return instance;
    }
}
