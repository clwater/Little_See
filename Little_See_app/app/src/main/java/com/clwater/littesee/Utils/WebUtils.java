package com.clwater.littesee.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.clwater.littesee.MainActivity;
import com.nostra13.universalimageloader.utils.L;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by gengzhibo on 16/10/12.
 */

public class WebUtils {

    public static final String BASE_URL = "file:///android_asset/";
    public static final String MIME_TYPE = "text/html";
    public static final String ENCODING = "utf-8";
    public static final String FAIL_URL_ZHIHU = "http//:daily.zhihu.com/";
    public static final String FAIL_URL_HAOQIXIN = "http://m.qdaily.com/";
    private static final String CSS_LINK_PATTERN = " <link href=\"%s\" type=\"text/css\" rel=\"stylesheet\" />";
    private static final String NIGHT_DIV_TAG_START = "<div class=\"night\">";
    private static final String NIGHT_DIV_TAG_END = "</div>";
    private static final String DIV_IMAGE_PLACE_HOLDER = "class=\"img-place-holder\"";
    private static final String DIV_IMAGE_PLACE_HOLDER_IGNORED = "class=\"img-place-holder-ignored\"";

    public static String buildHtmlWithCss(String html, String cssUrl, boolean isNightMode) {
        StringBuilder result = new StringBuilder();

        result.append(String.format(CSS_LINK_PATTERN, cssUrl));


        if (isNightMode) {
            result.append(NIGHT_DIV_TAG_START);
        }
        result.append(html.replace(DIV_IMAGE_PLACE_HOLDER, DIV_IMAGE_PLACE_HOLDER_IGNORED));
        if (isNightMode) {
            result.append(NIGHT_DIV_TAG_END);
        }
        return result.toString();
    }

    public static String buildHtmlWithCsss(String html, String[] cssUrls, boolean isNightMode) {
        StringBuilder result = new StringBuilder();
        for (String cssUrl : cssUrls) {
            result.append(String.format(CSS_LINK_PATTERN, cssUrl));
        }

        if (isNightMode) {
            result.append(NIGHT_DIV_TAG_START);
        }
        result.append(html.replace(DIV_IMAGE_PLACE_HOLDER, DIV_IMAGE_PLACE_HOLDER_IGNORED));
        if (isNightMode) {
            result.append(NIGHT_DIV_TAG_END);
        }
        return result.toString();
    }

    public static String getWebText_zhihu(String re){
        return re.substring(re.indexOf("<div class=\"content-inner\">") , re.lastIndexOf("<div class=\"question\">"));
    }
    public static String getWebCss_zhihu(String _re){
        String link = _re.substring(_re.indexOf("/css/share.css?") , _re.lastIndexOf("<script src=\"http://static.daily.zhihu.com/js/modernizr"));
        link = link.trim();
        link = link.substring("/css/share.css?v=".length() , link.length() - "\">".length() );
        return "http://news-at.zhihu.com/css/news_qa.auto.css?v=" + link;
    }

    public static String getWebText_haoqixin(String re){

        String text = "<div style=\"margin:0;\">\n" +
                "    <img alt=\"\" data-ratio=\"0.562500\" data-format=\"png\" class=\" lazyloaded\" data-src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpWebW640\" src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpWebW640\" style=\"height: 323.438px;\">\n" +
                "</div>\n" +
                "\n" +
                "<img class=\"banner lazyloaded\" data-src=\"http://img.qdaily.com/article/article_show/20161019002211QuiH4LosAhFd12zJ.png?imageMogr2/auto-orient/thumbnail/!755x450r/gravity/Center/crop/755x450/quality/85/format/jpg/ignore-error/1\" alt=\"Google 出了个键盘应用，给 VR 用的\" src=\"http://img.qdaily.com/article/article_show/20161019002211QuiH4LosAhFd12zJ.png?imageMogr2/auto-orient/thumbnail/!755x450r/gravity/Center/crop/755x450/quality/85/format/jpg/ignore-error/1\">";
        //text = re.replace("<div class=\"banner\"><img src=\"http://img.qdaily.com/article/article_show/20161019002211QuiH4LosAhFd12zJ.png?imageMogr2/auto-orient/thumbnail/!580x344r/gravity/Center/crop/580x344/quality/85/format/jpg/ignore-error/1\" alt=\"\"></div>","");
//        text = re.replace("figure" , "div");
//        Log.d("gzb" , "" + text);
//        Log.d("gzb" , "" + text);
//        text = re.replace("<div class=\"com-insert-images\"><figure style=\"margin:0;\">\n" +
//                "    <img alt=\"\" data-ratio=\"0.562500\" data-format=\"png\" class=\" lazyloaded\" data-src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpMobileW750\" src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpMobileW750\" style=\"height: 725.625px;\">\n" +
//                "</figure></div>" ,
//                "<img alt=\"\" data-ratio=\"0.562500\" data-format=\"png\" class=\" lazyloaded\" data-src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpMobileW750\" src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpMobileW750\" style=\"height: 725.625px;\">\n");
//        //text = re +  "<img alt=\"\" data-ratio=\"0.562500\" data-format=\"png\" class=\" lazyloaded\" data-src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpWebW640\" src=\"http://img.qdaily.com/uploads/201610190020052s1UiLJSPtvNhxo3.png-WebpWebW640\" style=\"height: 323.438px;\">";
        //        text = re.replace("<div class=\"com-insert-images\"><figure style=\"margin:0;\">" , "<div class=\"banner\">");
//        text = text.replace("</figure></div>" , "</div>");

           //text = re.replace("<div class=\"com-insert-images\"><figure style=\"margin:0;\">" , "<div class=\"banner\">");
       // text = re.substring(0 , re.indexOf("script") ) + re.substring(re.lastIndexOf("script") , re.length());
       //     text = re.replace("figure" , "div");

       text = re.substring(re.indexOf("<body ") , re.lastIndexOf("</html>")  );
        text = text.replace("data-src" , "src");

        Log.d("gzb" , text);
        return  text;
        //return re.substring(re.indexOf("<div class=\"article-detail-bd\">") , re.lastIndexOf("<div class=\"article-detail-ft\">"));
    }
    public static String getWebCss_haoqixin(String _re){
        return "";
    }

}
