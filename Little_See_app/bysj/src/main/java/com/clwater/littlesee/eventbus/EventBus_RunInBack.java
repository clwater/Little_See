package com.clwater.littlesee.eventbus;

/**
 * Created by yszsyf on 17/3/19.
 */

public class EventBus_RunInBack {
    String tag ;
    String tag2 , tag3;

    public String getTag2() {
        return tag2;
    }

    public String getTag3() {
        return tag3;
    }


    public EventBus_RunInBack(String tag) {
        this.tag = tag;
    }

    public EventBus_RunInBack(String tag , String tag2) {
        this.tag = tag;
        this.tag2 = tag2;
    }

    public EventBus_RunInBack(String tag , String tag2 , String tag3) {
        this.tag = tag;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    public String getTag() {
        return tag;
    }
}
