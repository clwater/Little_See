package com.clwater.littesee.Utils.Analysis.Bean;

import java.util.List;

/**
 * Created by gengzhibo on 16/11/19.
 */

public class HttpImageBean {
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
        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getDateid() {
            return dateid;
        }

        public void setDateid(String dateid) {
            this.dateid = dateid;
        }

        private String href;
        private String dateid;

    }

}


