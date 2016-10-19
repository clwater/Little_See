package com.clwater.littesee.Utils;

/**
 * Created by gengzhibo on 16/10/12.
 */

public class WebUtils {

    public static final String BASE_URL = "file:///android_asset/";
    public static final String MIME_TYPE = "text/html";
    public static final String ENCODING = "utf-8";
    public static final String FAIL_URL = "http//:daily.zhihu.com/";
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
        return re.substring(re.indexOf("<div class=\"content-inner\">") , re.lastIndexOf("<div class=\"question\">"));
    }
    public static String getWebCss_haoqixin(String _re){
        String link = _re.substring(_re.indexOf("/css/share.css?") , _re.lastIndexOf("<script src=\"http://static.daily.zhihu.com/js/modernizr"));
        link = link.trim();
        link = link.substring("/css/share.css?v=".length() , link.length() - "\">".length() );
        return "http://news-at.zhihu.com/css/news_qa.auto.css?v=" + link;
    }

}
