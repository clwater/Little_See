package com.clwater.littlesee.utils;

/**
 * Created by yszsyf on 17/3/22.
 */

public class WebUtils {
    public static final String BASE_URL = "file:///android_asset/";
    public static final String MIME_TYPE = "text/html";
    public static final String ENCODING = "utf-8";
    public static final String FAIL_URL_ZHIHU = "http://daily.zhihu.com/";
    private static final String CSS_LINK_PATTERN = " <link href=\"%s\" type=\"text/css\" rel=\"stylesheet\" />";

    public static String buildWithCss(String html , String[] cssUrls){
        StringBuilder result = new StringBuilder();

        for (String cssUrl : cssUrls) {
            result.append(String.format(CSS_LINK_PATTERN, cssUrl));
        }

        result.append(html);

        return result.toString();
    }

}
