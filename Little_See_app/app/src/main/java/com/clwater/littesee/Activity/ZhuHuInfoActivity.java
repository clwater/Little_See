package com.clwater.littesee.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static java.security.AccessController.getContext;

/**
 * Created by gengzhibo on 16/10/11.
 */

public class ZhuHuInfoActivity  extends BaseWebActivity{

    @InjectView(R.id.mv_toolbar)
    public Toolbar toolbar;
    @InjectView(R.id.zh_info_image)
    public ImageView title_image;
    @InjectView(R.id.zh_SV_space)
    public TextView zh_SV_space;
    @InjectView(R.id.zh_info_web)
    public WebView webview;


    String testtext ="<div class=\"main-wrap content-wrap\">\n" +
            "<div class=\"headline\">\n" +
            "\n" +
            "<div class=\"img-place-holder\"></div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content-inner\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"question\">\n" +
            "<h2 class=\"question-title\">某个国家 / 地区的股市市值大小，能否体现其经济发展水平？</h2>\n" +
            "\n" +
            "<div class=\"answer\">\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "<p>根据华尔街日报的新闻，中国经济增长率很早就已经超过欧洲，现在中国股市的规模也超过了欧洲。Bespoke Investment Group 的数据显示，中国 A 股加上香港股市现在占全球股市的份额超过整个欧洲。中国股市现在占全球市值的 16%，欧洲约占 15%。</p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"answer\">\n" +
            "\n" +
            "<div class=\"meta\">\n" +
            "<img class=\"avatar\" src=\"http://pic1.zhimg.com/c28c3c783545207669595dd6fe0df0ac_is.jpg\">\n" +
            "<span class=\"author\">钱粮胡同，</span><span class=\"bio\">欧洲某行Portfolio Strategies</span>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "<p>这个问题看似简单，然而真心不好回答：</p>\n" +
            "<p><strong>一，难在回答的这个度怎么把握</strong>：不能太学术枯燥又不能太没营养</p>\n" +
            "<p><strong>二，这个故事要怎么讲</strong>：不会显得过于杂乱但是又能尽量全面</p>\n" +
            "<p>回答前再絮叨两点：</p>\n" +
            "<p>1）问题中提到的华尔街那篇新闻用的是<strong>绝对数值</strong>，而这类研究往往采用的是<strong>相对数值</strong>，即<strong>股市的发展水平</strong>用<strong>股市市值除以国民生产总值（Market Cap/GDP）</strong>来代表，而<strong>一国经济发展水平</strong>用<strong>人均 GDP（GDP per Capita）</strong>来代表；</p>\n" +
            "<p>2）问题标签虽然与热门的\"股票市场\"有关，但是其背后解释更接近于传统经济学与法律的范畴，同时兼带对不同国家金融系统，历史和制度演变的了解。也因此，这个回答药性不高，喜欢炒股的同学看了后估计 high 不起来。</p>\n" +
            "<p>我们直接看看问题：<strong>股市的市值大小是否可以体现一国的经济发展水平</strong>。这方面的学术研究其实有不少了，这里我倾向于引用业界花旗的一份研究，比较实用，清晰简单的描述了这个关系（图 1）：</p>\n" +
            "<p><strong>图 1：股市市值 / GDP 与人均 GDP 的关系，世界 top 53 经济体，2014 年数据</strong></p>\n" +
            "<p><img class=\"content-image\" src=\"http://pic1.zhimg.com/70/db94258662879e7db2da2fcdd104bd24_b.jpg\" alt=\"\" /></p>\n" +
            "<p>从图 1 可以看出，<strong>美国和英国两个经济体相当程度地体现了一国经济水平与股市的平衡发展关系</strong>（股市与经济发展水平两个比值相对协调，回归线上）；<strong>而发达国家如德国则无法支持这个论点</strong> - 德国股市指标远远落后于英国（30% vs 90%），然而经济发展水平却与英国相当（挪威的例子则更加极端）。<strong>对于中国在图 1 的位置（左下角，回归线下），则说明中国的股市发展水平相对快于经济的发展</strong>（也就是说，以中国 2014 年的股市发展水平来看，人均 GDP 理论上应该在 2 万美元上下 - 即 y 轴 20 附近，而现实中在 1 万美元左右）。<strong>这份研究报告其中一个结论是：全球来看（基于 53 个国家样本），一国股市的发展程度可以大约解释其经济发展水平的 28.3%</strong>。既然是这样，那么是否就说明股市不好做为一个国家经济发展的指标呢？或者说其只适用于某些国家（如英美法系的国家）？那么对于其他大陆法系国家来说，比如德国或中国（i.e. 具有中国特色的社会主义大陆法律体系），是否存在故事的另一面，也就是银行（间接融资）才是真正的主导？</p>\n" +
            "<p>这里先引用一个很久以前学术界的争论：大概在 19 世纪末期的时候，<strong>德国经济学家曾声称：\"以德国为首的银行为中心的金融系统优于以市场为中心的英国，这也使得德国在近代迅速崛起，成为了新的工业力量\"</strong>（Goldsmith，1969）。之后这一论点得到了日本的支持（另一个以银行为主在当时高速发展的经济体）。<strong>这里有人可能要说了，德国的成功是基于强大的实体企业，金融系统在这里能有多大关系？</strong>我想这里插个题外话，<strong>让有兴趣的人可以更好的理解德国银行体系对于本国经济和工业发展的重要性</strong> - 隆重介绍下德国长达 100 多年的<strong>德意志联盟（Germany Inc）</strong> - 在我的回答：<a href=\"https://www.zhihu.com/question/50697961/answer/123978873?from=profile_answer_card\">怎么看美国司法部对德意志银行开出的 140 亿美元罚单？ - 钱粮胡同的回答</a> 中曾经粗略提到过：</p>\n" +
            "<blockquote><strong>德意志联盟</strong>最早形成于 1873 年，开始于德意志银行与西门子公司（德银 1870 年成立的时候，董事会发言人就是西门子家族的 Georg von Siemens）。这个联盟一直延续到 2000 年初，随着德国税改以及德银向投资银行的快速转型宣告终结。在这期间的 100 多年里，<strong>联盟的作用主要在于由银行等金融机构主导（包括安联集团，德累斯顿银行等），通过高度交叉持股（主要是金融机构持有实体企业股份），进行有组织的大规模产业规划（如 1926 年德意志银行 Emil von Strauss 主导的戴姆勒和奔驰公司的合并）</strong><strong>和资源有效分配</strong><strong>，防止海外公司恶意收购本土企业等。这在当时称之为经典的德国组织性 / 合作性资本主义（organized Capitalism, 类似于集团军作战，一致对外）</strong>。下图是<strong>德国企业的交叉持股关系网络图</strong>，蓝点是德意志银行，红点是德国最大 250 家企业 - 以德银为中心，这个交叉持股网络总共存在 4,572 个双向持股关系。</blockquote>\n" +
            "<p><img class=\"content-image\" src=\"http://pic1.zhimg.com/70/124fd323f5d2501783f1325dad8e9924_b.jpg\" alt=\"\" /></p>\n" +
            "<p>以防讲着讲着跑远了，咱们先回到正题：</p>\n" +
            "<p>总的来说，<strong>学术界对于金融系统与经济发展水平的关系大概分四种观点</strong>：</p>\n" +
            "<ul>\n" +
            "<li><strong>相对早期，比较狭隘的观点 1）与 2）</strong>：基于发展经济学（Easterly &amp; Levine, 1999）与传统公司金融理论（Mayer, 1988）- 这两者都更支持以银行为主的间接融资体系，认为这样的安排更有利于企业乃至一国经济的发展。</li>\n" +
            "</ul>\n" +
            "<p>但是，现实没有这么简单。就像前面分析的，以市场为主导的英国并没有真正的衰落，美国也成为了世界超级强权；而在上图中我们看到，这两个国家以股市指标来代表经济发展水平是相对合适的。基于此，学术界又提出了下面两个相对更成熟的观点：</p>\n" +
            "<ul>\n" +
            "<li><strong>之后较成熟的观点 3）与 4）：基于金融服务质量与法律制度</strong>（Levine, 1997；LLSV, 1997, 1998, 1999）：这两个角度的解释更加成熟全面，从制度的角度来理解金融系统与经济发展的作用。他们认为，金融是一层层合同的叠加 - 也因此，对于一个国家来说，金融系统的优劣不是绝对的：哪种金融系统更加合适有效，并可以为实体经济提供高质量的金融服务，取决于这个国家的法律环境及其执行力度。</li>\n" +
            "</ul>\n" +
            "<p><strong>结合咱们这个问题，把上面的分析和学术理论换成白话解释就是：</strong></p>\n" +
            "<p><strong>1）对于英美法系的国家</strong>来说，股市也许是个合适的参照指标；</p>\n" +
            "<p><strong>2）对于德国等大陆法系的国家</strong>，银行更适合作为参考指标；</p>\n" +
            "<p><strong>3）</strong><strong>对于具有中国特色的社会主义国家来说</strong>，我觉得，股市如果能够快速健康的发展，不天天割韭菜，肯定是好事，也在一定程度上反映了我国经济发展的水平；但是基于中国的经济体量，相对值会比绝对值更有意义一些；同时，一个综合性的指标（考虑银行与股市的综合发展程度）也许可以更好的代表我国特色的经济发展水平。</p>\n" +
            "<p>希望这个回答多少有一点帮助。:)</p>\n" +
            "<p><strong>详细参考文献列表可点击「查看知乎讨论」获取。</strong></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "<div class=\"view-more\"><a href=\"http://www.zhihu.com/question/49999634\">查看知乎讨论<span class=\"js-question-holder\"></span></a></div>\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "</div>\n" +
            "</div>";

    boolean pd = true;

    String[] scc;

    private static final String CSS_LINK_PATTERN = " <link href=\"%s\" type=\"text/css\" rel=\"stylesheet\" />";
    private static final String NIGHT_DIV_TAG_START = "<div class=\"night\">";
    private static final String NIGHT_DIV_TAG_END = "</div>";


    private static final String DIV_IMAGE_PLACE_HOLDER = "class=\"img-place-holder\"";
    private static final String DIV_IMAGE_PLACE_HOLDER_IGNORED = "class=\"img-place-holder-ignored\"";

    public static String buildHtmlWithCss(String html, String[] cssUrls, boolean isNightMode) {
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihuinfo);
        ButterKnife.inject(this);

        activity = this;

        initTitle();
        initNavigation();
        initUI();
        initWebView();


    }

    private void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        //settings.setUseWideViewPort(true);造成文字太小
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCachePath(getCacheDir().getAbsolutePath() + "/webViewCache");
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.setWebChromeClient(new WebChromeClient());

        //webview.loadDataWithBaseURL();

     //   webview.loadUrl("http://daily.zhihu.com/story/8874308");
        //loadDataWithBaseURL/?

        scc = new String[10];
        scc[0]  = "http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3";

        String data = buildHtmlWithCss(testtext, scc, true);

        webview.loadDataWithBaseURL("file:///android_asset/", data, "text/html", "utf-8", "http//:daily.zhihu.com/");



//        webview.setWebViewClient(new WebViewClient()
//        {
//            @Override
//            public void onPageFinished(WebView view, String url)
//            {
////                String fun="javascript:alert(\"aaa\") ";
////                view.loadUrl(fun);
//
//
//                if (pd == true) {
//
//
//
////                    final String insertJavaScript = "javascript:window.onload=function(){ " +
////                            "document.getElementsByClassName('img-wrap')[0].style.display='none'; " +
////                            "document.getElementsByClassName('img-wrap')[0].style.display='none';}";
////
////                    webview.loadUrl(insertJavaScript);
//                     webview.loadUrl("javascript:document.getElementsByClassName(\"img-wrap\").style.width=\"20px\";");
//                    webview.loadUrl("javascript:alert(\"aaaa\")");
//                    Logger.d("11111");
//
//
////                   // String fun2 = "javascript:alert(\"aaaaa\")";
////
////                    String fun2 = "javascript:\n" +
////                            "var aaaa = document.getElementsByClassName(\"img-wrap\"); alert(aaaa)\n" ;
////
////                    // String fun2 = "javascript:document.getElementsByClassName(\"img-wrap\").style.visibility='hidden'";
////                    view.loadUrl(fun2);
////
////                    //Logger.d("2");
//                    pd = false;
//                }
//
//
//
//                super.onPageFinished(view, url);
//            }
//        });



    }




    private void initUI() {
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();


        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) title_image.getLayoutParams();
        relativeParams.height = height * 4  / 10;
        title_image.setLayoutParams(relativeParams);

        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) zh_SV_space.getLayoutParams();
        linearParams.height = height * 4  / 10;
        zh_SV_space.setLayoutParams(linearParams);



        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ZhuHuInfoActivity.this));
        ImageLoader.getInstance().displayImage("https://avatars3.githubusercontent.com/u/14257964?v=3&s=466",title_image, AppConfig.imageOptions());

    }

    private void initNavigation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

    private void initTitle() {
        toolbar.setTitle("知乎日报");
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_nv);
        ab.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
