package com.clwater.littesee.Utils.Analysis.Bean;

import java.util.List;

/**
 * Created by gengzhibo on 16/11/19.
 */

public class HttpTextBean {
    private String statu;

    public List<DateBean> getDate() {
        return date;
    }

    public void setDate(List<DateBean> date) {
        this.date = date;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    private List<DateBean> date;

    public class DateBean{
        private String title;
        private String title_image;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_image() {
            return title_image;
        }

        public void setTitle_image(String title_image) {
            this.title_image = title_image;
        }

        private String address;
    }

}


