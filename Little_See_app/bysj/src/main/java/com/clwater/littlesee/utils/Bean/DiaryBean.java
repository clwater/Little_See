package com.clwater.littlesee.utils.Bean;

import java.util.List;

/**
 * Created by yszsyf on 17/3/17.
 */

public class DiaryBean {
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

    public class DateBean{
        private String title;
        private String image;
        private String address;
        private String indexclass;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIndexclass() {
            return indexclass;
        }

        public void setIndexclass(String indexclass) {
            this.indexclass = indexclass;
        }
    }

}