package com.clwater.littlesee.utils.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yszsyf on 17/3/17.
 */

public class ImageBean {

    private String statu;

    private List<DateBean> date;

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public List<DateBean> getDate() {
        return date;
    }

    public void setDate(List<DateBean> date) {
        this.date = date;
    }

    public static class DateBean implements Serializable {

        private String address;
        private String text;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIndexclass() {
            return indexclass;
        }

        public void setIndexclass(String indexclass) {
            this.indexclass = indexclass;
        }

        private String indexclass;


    }

}