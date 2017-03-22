package com.clwater.littlesee.eventbus;

/**
 * Created by yszsyf on 17/3/19.
 */

public class EventBus_RunInFront {
    String tag ;
    String tag2 ;

    public EventBus_RunInFront(String tag) {
        this.tag = tag;
    }

    public EventBus_RunInFront(String tag , String tag2) {
        this.tag = tag;
        this.tag2 = tag2;
    }

    public String getTag() {
        return tag;
    }
    public String getTag2() {
        return tag2;
    }
}
