package com.clwater.littlesee.utils.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yszsyf on 17/3/17.
 */

public class NewsBean {

    private List<DateBean> BBM54PGAwangning;

    public List<DateBean> getBBM54PGAwangning() {
        return BBM54PGAwangning;
    }

    public void setBBM54PGAwangning(List<DateBean> BBM54PGAwangning) {
        this.BBM54PGAwangning = BBM54PGAwangning;
    }

    public static class DateBean implements Serializable {
        private String docid;
        private String title;
        private String source;
        private String stitle;
        private String imgsrc;
        private String hasImg;
        private String digest;
        private String commentCount;
        private String ptime;
        private String url;
        private String imgsrc3gtype;

        private String indexclass;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStitle() {
            return stitle;
        }

        public void setStitle(String stitle) {
            this.stitle = stitle;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getHasImg() {
            return hasImg;
        }

        public void setHasImg(String hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImgsrc3gtype() {
            return imgsrc3gtype;
        }

        public void setImgsrc3gtype(String imgsrc3gtype) {
            this.imgsrc3gtype = imgsrc3gtype;
        }

        public String getIndexclass() {
            return indexclass;
        }

        public void setIndexclass(String indexclass) {
            this.indexclass = indexclass;
        }
    }

}