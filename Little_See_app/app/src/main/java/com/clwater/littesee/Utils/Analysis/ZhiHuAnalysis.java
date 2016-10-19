package com.clwater.littesee.Utils.Analysis;

import android.content.Context;
import android.util.Log;

import com.clwater.littesee.MainActivity;
import com.clwater.littesee.Utils.DBHelper.HaoQiXin;
import com.clwater.littesee.Utils.DBHelper.HaoQiXinDaoOrm;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;

import java.util.List;

/**
 * Created by gengzhibo on 16/10/17.
 */

public class ZhiHuAnalysis {
    public static void Analysis(Context context){
        //test1();
        //test2();
    }

    private static String testText2 = "http://www.qdaily.com/articles/33473.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161019113639jERGHwAVd87KbIso.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为了推视频业务，亚马逊要在欧洲做宽带生意了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33468.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161019080510k8QuOKDRieqndANH.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：苹果即将发布新 Mac，亚马逊要做宽带生意\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33458.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161019002211QuiH4LosAhFd12zJ.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 出了个键盘应用，给 VR 用的\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33457.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018222819LfptrGXwcQRS2dyB.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "我们列出了关于少儿版《白蛇传》的 49 个疑问，制片人高翔都回答了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33439.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018150547WqjUEsYAc4CHt56a.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "裁员又转型，苹果放弃了生产汽车的计划\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33422.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018111140UwcxTH9L3jrOYmMK.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果 VS 微软：谁来定义电脑？一场持久的有关技术话语权的争夺战｜广告大战③\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33434.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018131627Et17oYLvlmMi0jRd.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为了买一个游戏公司，腾讯拉了四十亿美元投资\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33423.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018104026SEyebU8pGhaTBYVm.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "重新设计动态调价的那位教授，现在离开了 Uber\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33419.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018093149oLgJlvb81qRZznUy.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "王健林想每年拿1.5亿美元补贴好莱坞，还是为了卖房吧？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33406.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017214359dVe7QUGgcNJEL5oj.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "上线半年，共享自行车拿钱速度超过了打车大战，这会怎么改变你的出行？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33414.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161018080410aBYJnOv6ZuK9tUEA.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：苹果汽车项目人员缩减，万达挖到迪士尼高管\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33396.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610181333388P9r5hSNBnUxZGAf.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "又一个大公司做租房贷款，这些公司提供的服务划算么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33399.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017180741XZFlK34cB50iQeqO.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "奇异博士来到中国，这是漫威电影里的第一位魔法师\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33391.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017152104jez6JRXYCv1LOm8q.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "小米也开始做手机处理器了，但这短期内还出不了什么效果\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33392.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017153054mgHnruTUtaGA4Bzw.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "乒超没人冠名不要紧，阿里体育还是拿来做内容了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33383.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017131222YRcNXTLFpf843uAe.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "让机器人学人做事不太容易，Facebook 智能助手遇到困境\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33386.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017132504jQk4aECOMNK8b0oH.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为了吸引年轻人，麦当劳组建了两百人的全球数字团队\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33385.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016101713210496tapDeIv8PYTofA.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "因为苹果要用新屏幕，JDI 亏损还在砸钱做 OLED\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33371.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161017074017nOwCNb0cFfrxEsgX.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：全球禁止温室气体 HFC，北京网约车新规结束意见征求\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32945.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161006090309uJfAXlI6ULiE59Nk.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "温哥华想让自己变得更强大，它想到的盟友是西雅图\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33366.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610161842311AltN9cBfYnZCVaO.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "库克又谈到了增强现实，说它比 VR 重要\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33307.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610140840291pfk4JYG2XSE3yIr.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "亚马逊又又又推出音乐服务，已经是10年里的第三次了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33354.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161015153422FhixnVyca6EepRQv.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "优衣库过去一年增速放缓，姐妹品牌 GU 表现不错\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33347.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610150704528mJkGayQ7wx9nDTz.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "当苹果供应商不容易，人都快被它挖光了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33343.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161014233831c6nNepLi9b1saPlD.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "才发布手机没多久的 Google，又要自己做手表了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33129.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161010151210Xf5oIL0YePHqAMpr.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "支付宝做了一年多韩国市场，抓到的都是中国游客\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33312.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161014113817EieGdnxbO74o3R2S.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "切尔西与耐克签下 15 年长约，双方终于都满意了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33297.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161013222655UZYe5uQWxjINr9sX.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "印度没做成功，扎克伯格打算把免费联网计划带进美国\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33306.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161014101112R2j9fXHrQTpcwOWP.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "有份报告说，Apple Watch 是目前最准的手腕设备\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33304.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610140654194bUjI8FOmxf7wero.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：腾讯投资摩拜单车，阿里巴巴交易额突破三万亿元\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33174.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161011140052aAyQuPZ2lqvBKHiL.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果回应部分 App 被下架的事，但开发者觉得被冤枉了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33158.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161011085551GwT8FIua9ghd15bQ.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "人工智能说话会有不同的口音吗？大公司对此不太积极\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33300.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161013231846aV5KoFdzyhSCOqpc.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为什么美国购物季来临，亚马逊仓库却不接第三方卖家货了？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33281.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161013160756qFBQUtkIwAGLWjz9.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "赵薇卖了手头一小半的阿里影业股票，是后者遇到问题了吗？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33282.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161013172246Jyot2qfKbr4QXukc.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "阿迪又签了 8 个 NBA 新秀，当真是和耐克怼上了吗？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33278.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610131537300f23UmldBvsVqSRx.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "万达开始报喜不报忧，电影院生意还好吗？| 好奇心小数据\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33265.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610131210444KVOMf7igoeR8XAP.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "星巴克推出的第一款酒精饮料，当然还是会带上咖啡\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33197.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161011181748PAlrfkqUx1MdLsz5.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 有上百辆无人驾驶新测试车准备上路了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33222.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161012141424yvINfgEWVxZdtLM0.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "汉堡王 VS 麦当劳：都是做汉堡的，何苦这么“为难”对方？|广告大战②\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33223.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161012134222R1Wz65LM9ewsbAjc.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "迪士尼又要拍真人版《阿拉丁》，可能是部动作冒险片\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33211.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610121220478ixtqsAEL4zuZRTN.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "「这世界」全球多地出现“小丑恐慌”之后，麦当劳叔叔都不敢露面了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33213.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161012120608lMOVXQPdjiumJkYU.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "三星苹果专利案打到了高法，美国科技公司为什么支持三星？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33215.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161012125331J9fkjaO8ScNQPW3Y.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "全球电脑销量连续 8 个季度下跌，连 Mac 也卖少了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33205.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161012092651KWPzjhmtHMdr9nLk.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "中国的信贷机构通过观察卫生间来了解借款人？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33207.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161012082427J2tOq1TF3h0VyCL6.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：苹果要在深圳开研发中心；含糖饮料可能会变贵？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33182.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161011150331MFINi5dptslQk3Jv.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "开了书店之后，亚马逊的杂货店很有可能也在路上\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33164.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161011111916yEY8c4wqNemOBU1f.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "扎克伯格设想的办公未来，是让你工作和生活毫无界限\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33173.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161011133603zEPBAjsZgMf03b17.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "“2016 全球最有价值品牌”榜单出炉了，这 9 点值得关注\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33110.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161010111603X9AoDfGTiZKS3c1b.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "扎克伯格是怎么成为了 VR 的代言人？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33152.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610110844550cLfsMQpiRye4bVx.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Facebook 企业社交平台上线，诺贝尔经济学奖颁发，三星暂停销售 Note7\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33111.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610101135580osn3i7TEYzWOZqG.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "智能音响什么最好用？啊哈，当然是放音乐\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33036.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161008234014IvhGxbU9kdHWJ6nr.png?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "以免费服务为己任的 Google，怎么突然盯上了有钱人的生意？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33121.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161010134534OQyg3iaYjlm8CquN.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 风投说，这套方法能让你在 5 天完成产品迭代\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33116.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161010120502oE1pFMsgVxqHKj9e.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "不只是投资新公司，腾讯自己也开始招人做自动驾驶\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33117.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161010121111O5Iw6xBc42RHdiXr.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 用技术灭蚊，能彻底解决人类和蚊虫之间的恩怨吗？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33102.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161010003357yNXbBmg6Wr4Q9fwk.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 发布新手机后，投了一大波广告\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33091.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610092341533ntTZyKNQwWHoCVg.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "给 iPhone 7 做外壳的公司，最近也跟着苹果挣钱了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33103.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016101004010581ChkPf6GmoaMzeB.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：更多城市出台网约车新规，苹果在中国申请双卡双待专利\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33088.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161009174457ch1HERn6wFCpTaXo.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "宜家今年秋天的限量款，灵感源自100多年前的艺术运动\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33092.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161009191942ntiU9vbrFJCAVfjw.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "万达把旅行社业务抛掉了，接盘的是同程\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33024.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161008183002OMV6eBh5dTCIXfb2.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果和三星的专利战还在继续，为什么这事拖了这么久？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33037.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161009100331MwHX0VI7NjvOsUT2.png?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Under Armour VS 耐克，后起之秀如何从行业霸主那里获得话语权？｜广告大战 ①\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33067.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161009125739FK8adTy9SmrnAYE4.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "在柬埔寨新开了高端门店的星巴克，要开始扩张东南亚市场\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33053.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610091124202SbmsWEKHNl4JxrF.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 要在纽约开个快闪店，卖手机\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33028.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161008192714SHubjcRBtfMxU82q.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "北上广深发布专车管理细则，政策会扼杀你熟悉的手机叫车么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/33002.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016100813105174ZjPcaLsVMUQoqJ.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "蚂蚁金服平稳更替了接班人，IPO 前只剩下两大任务\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32995.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161008111820GnBPZKq2YbxzjlSh.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "给新手机打广告，Google 在电视上花的钱比苹果还多\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32991.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201610080841152CGOErFj6c75kZqu.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "中国最有名的互联网保险公司，靠卖运费险做到快上市了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32986.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161008073913QWVrSD4XHx3fIb85.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：三星苹果专利战又有新进展，小米海外开店\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32981.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161008010949fGFSAt9m0Qw3buaM.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "王健林交了3年前那份一堆明星撑腰的作业，他可能只是又借了一次好莱坞的风头\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32977.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161007231409d24cipHfFL5lvRu8.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "贺岁喜剧电影《健忘村》，发布了第一支预告片\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32968.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161007174713x8SZJQdCb9kAiI27.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Oculus 开了个年度发布会，认为社交是 VR 的未来\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32965.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161007102236sfGcWKx4DatVT5oh.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Oculus 正在开发独立虚拟现实头盔，中国房价连续 14 个月上涨\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32947.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161006103335D8vbL7GAsniUc62V.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：蚂蚁金服计划明年香港上市，沃尔玛增持京东股票\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32938.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161005095538v40VfbXTlyLs6FnW.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Google 发了手机和 VR 等五款硬件，微软 Bing 负责人陆奇要去腾讯？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32936.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161005052622vdTlSfB1ewpFCtrm.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "新手机、VR头盔、智能音箱......昨晚 Google 都发布了什么新硬件\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32935.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161005024051biL2FS97hMxeXO4G.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "乔布斯离开五年了，他促成的改变哪些留了下来？哪些没有？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32924.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161004092432b6X1YezT7xNmM0Q3.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Google 今晚发布新手机，微信和支付宝转账笔数也会受限\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32914.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161003121521kT7XOzZrYemEKUWJ.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果新总部进展，更像一个飞碟了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32912.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161003115148VlMWxbFRA6htqzk9.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：诺贝尔奖今天开始公布，亚马逊扩张人工智能团队\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32902.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161002102833WMcpOt2fiRAV6uIU.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "欧盟反垄断调查指向 Android，一个开源系统怎么建立垄断？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32900.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161002094353dQOFscPnioYxT1ML.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：苹果输掉专利官司要交 3 亿美元，小米又在印度发新手机\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32886.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20161001135540OWHu5vRcAz9nhTG0.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：美国直播应用鼻祖 Meerkat 关闭，百度外卖否认出售\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32848.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160930123131G7Uf02eCha4HRvAZ.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "匡威要开始认真卖衣服了，希望年轻的人们能买账\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32825.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160930080001q7vRuigZMcWtdbpf.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "五大科技巨头联合，保护人类不会被机器人抢走工作\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32866.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160930160537XwCEqLZzG4oBdJDx.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "詹姆斯球鞋卖得不好，耐克的领先优势开始被蚕食\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32857.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609301455103jAYPpB4rniDHJEg.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "一系列真人翻拍后，迪士尼还要拍“真人版”《狮子王》\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32849.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160930124140bqPFxD2KwJ6VygZ4.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "宜家澳大利亚做了个Airbnb风格的营销，把渡轮改成“家”\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32820.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160929233534zP4JK9vIWnBlGCZA.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "微信阅读量造假被曝光，但刷的生意并没停。弄个真数字为什么这么难？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32827.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160930075309E3TIwofjBXGvYr0s.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：微信公众号刷榜事件继续发酵，iPhone 8 的消息来了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32800.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160929155002PE60e9v4A5uokYpw.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "微软互联网服务负责人陆奇离职，纳德拉的改造在继续\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32788.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160929125047rdamQL9fWPteEGFj.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为了卖手机和平板，苹果开始和咨询公司合作\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32768.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160929080106iUj4tbIawyTfr8Hz.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "埃隆·马斯克的计划，是将人类送到火星乃至更远的地方\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32720.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609281543141eWARSuHqUJNcK9I.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "印度对 Google 太重要，以至于得到了一系列特殊优待\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32756.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609290008196b0LMFcl8dJIr3pS.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "一年前，我们花 18 天密集体验所谓“到家 O2O”，现在它们都不行了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32741.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160928180022eA5G6qxmX9L3k2Tu.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "努力了10年，亚马逊在美国服装业的份额排到了第二\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32742.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160928182053DleRi6UgPTShL9uE.JPG?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "去年受到追捧的麦当劳 Nanoblock，今年又来了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32672.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927120239MlwtdQ86OpEkRG0h.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "微软说，他们未来的重要计划是……可编程芯片？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32519.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160922233536QztgYGdx5hfF8rJq.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "这部你可能会看到的文艺片，背后有阿里影业、贾樟柯和一个诗人\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32728.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160928140411uqpVzhWJ4r6sCI10.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "俄罗斯政府也打算跟中国一样开始去微软化了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32693.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160928083412S2Ru63sON7dqgPfQ.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：亚马逊要抢快递生意，耐克增长放缓、股价大跌\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32692.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927174117Em7YkKi0FHWSU4xb.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "基于 Android，Google 要推出新操作系统“仙女座”\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32688.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927152820GIrnWKDb9FsvT7gU.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果音乐第一张播放量过 10 亿的专辑，来自说唱歌手 Drake\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32677.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927140750I8jzGWnbo2FB4u5s.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "麦当劳推出“系列视频”，一大拨自创的营销内容在路上\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32681.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927144050OZiRrjAs8floPuxT.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "优衣库姐妹品牌GU扩张，未来10年平均每年开100家店\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32668.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927105730fwNlra53ztF7qcYm.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "据说迪士尼也想买 Twitter，买来做什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32673.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927125746AouFlZtX8zUOmRWN.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "万达要花 10 亿美元，买下金球奖颁奖典礼的制作公司\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32663.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927094033CkL10pvMmHPu6UO5.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "今日娱乐：《仙剑奇侠传》拍电影，《爵迹》北美同步上映\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32661.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160927081231nM2WzqXOl4AVfsLQ.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：迪士尼也想买 Twitter，美团点评有了支付牌照，Uber 要在 24 个国家送外卖\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32635.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160926153336wqpl8TNxr1tPY9bz.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "小程序之后，腾讯的应用商店也想让你少用应用\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32645.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160926181502ahnJ6KHfz74pBS28.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "没机会买派拉蒙，王健林又瞄向了索尼影业\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32620.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160926114814HEMeyiL07cO9k68r.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为了做智能音箱，苹果都在忙什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32642.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160926175221yW0FTxVdBgX7io2Q.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "支付宝跟 10 个海外机场合作，想的还是游客生意\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32629.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160926144924G39OPBZUacRxdNk7.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 7 到底卖得怎么样？现在又有了不同说法\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32628.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016092614483176uEibA2QGt8SgZ5.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iOS 10 新漏洞，你备份的文件有危险\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32607.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160926070210p4IFdnA2RfWODYSN.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Twitter 要卖，三星推迟 Note 7 回归日期\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32596.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160925101342zP4Sh0K21mywFGuZ.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "F1 赛车的技术，对于汽车产业意味着什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32523.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160923071457847y1HpKgGUsaVAX.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "一个胡同小饭馆地图上找不着，在微信上认证就可以了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32454.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160921165946K53tyPTAzkR4irnV.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "第一个无人车指导条例颁布，它说了些什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32470.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160922080642enc8NkToztRZhquV.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 7 Plus 解锁全部拍照功能，两个摄像头到底有多好？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32579.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160923221836M1H69lJYkFfRxX2z.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "据说阿里音乐估值 30 亿，不懂它做啥了能值那么多钱\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32524.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160923082025bCJaqX7IhjmGWvP4.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：雅虎 5 亿帐户信息泄露，Google 领投 Airbnb 新一轮融资\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32521.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160923012216iBXdIL8TqZK5UVtn.jpeg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "微信小程序成了大新闻，它会改变什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32503.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160922173922UQJDZo56zkaKBumf.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "macOS Sierra 正式版体验，这六个新功能大概会让你有点兴趣\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32504.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160922181558UFKl0QygxJMjiG1p.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 屏幕制造商要被卖了，为什么接了大单还这么艰难？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32496.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160922154357NOxEYU86KwoIeVft.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为了汽车研发计划，苹果开始找生产F1赛车的公司帮忙\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32435.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609220121584XCyOtHi3n85IqzM.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为什么苹果放出来的相机样张，总是比你用 iPhone 拍出来的好？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32455.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160921174310RvFP9b62AkzJ03ta.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "美国快餐店走“高端”，把松露成分放到了汉堡和薯条里\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32434.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160921112800mqQI2tAw7cu6lb4N.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 7 制造成本上涨 18%，但这对苹果的利润影响应该不大\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32439.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016092113220553ObJtFD9IdTiB0W.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 7 增加订单到一亿台，多亏了三星？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32429.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160921103808x5cvEYp4RXzA2Ftk.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "安全的无人驾驶车还有多远，研究人员觉得还得几年\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32413.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160921075752tMx1Hpj35kbEsQVW.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：美国首套无人车指导条例出台，腾讯成了搜狗最大股东\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32418.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016092021040869a7Qc2dFxhCMZAD.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "曾因假药广告被罚，现在进了医疗产业，Google 这几年都做了哪些准备？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32401.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160920152844PSfpEKD4oNrVWb0y.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "旧金山饭馆生意不好做：房租高，科技公司还要挖走大厨\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32380.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919194641lrTYsMo7JAi9cyQa.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果 AirPods 之后，大家对智能耳机还有什么想象？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32389.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160920071242dMRegjO2FZEHB1xJ.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Google 要帮你管理旅行，GoPro 推出无人机\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32383.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919221357RCBEp6o4zQyeSJKb.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "麦当劳的谷歌营销，说第一个搜索结果都是自家食品\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32372.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609191615199vFyQdHKB7er2M0R.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 7 发售后遇到的问题，重度使用可能会出现噪音\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32359.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919135332p6u8SQZ9LX3Nrgze.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "宜家在瑞典的新广告，不寻常地关注了离婚家庭小孩\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32356.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919133444yRu8tnzU5J1xrfIL.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "距离电影上映还有三个月，《星球大战》玩具已经吆喝开了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32284.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016091810173086J1OfQ37VFbTIaL.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "「这世界」Google 连牛的隐私都照顾到了，是不是热心过头了？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32333.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919074617YiChxydO9lK6rmot.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "又是避税问题，苹果和 Google 在更多国家被调查\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32323.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919080353NAZBoLd7WUCcn0xk.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：三星在卖手上公司的股票，欧盟在苹果之后盯上了麦当劳\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32319.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160919034527botWz40sRirnuYSh.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为什么你就是买不到亮黑色的 iPhone 7 ？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32324.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160918234422Ii4gxDuLfWjK9t56.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "FBI 被美国媒体起诉了，还是因为 iPhone 解锁的事情\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32307.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160918144629EJMlYUB0bsGkwWS9.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "为推广同城配送，菜鸟裹裹做了这么个奇葩营销\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32322.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160918215842qgGaQzt87P6Wm4uL.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "怎么看待“未来是你的”？詹姆斯说，我还要向邓肯学习\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32321.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/2016091821510752hI1UFboanBcwLO.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "阿里体育出了一笔钱来运营高尔夫，但还是没有更细的计划\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32303.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160918174704QILzJlc326gUC4Bq.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "华为要在印度生产手机了，这市场好么？ | 好奇心小数据\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32279.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160918100145CLIyGkjSD8vXdNnr.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "今日娱乐：中国人收购英超西布朗，Xbox One月销量又超PS4\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32266.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160917072059stBrSuE8qXpwRgYM.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "「日本語」船梨精的家乡，变成了家居卖场激战区\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32189.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160914085600wUOeiLvX4GVJE6uQ.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "运动员穿上了各种芯片和传感器，他们的数据也被公司抓走了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32230.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160915041925ZJrCXcvAOUszEHeo.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "宜家公布部分财报，中国依然是增长最迅速的市场\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32194.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160914110524xoblFBJOrsT3dXvj.png?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "生鲜送上门的生意不好做，Google 在美国也停了它\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32184.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609140144593HSfBr5DWohRks8g.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iOS 10 正式版已经到来，除了外观的巨大变化，它还有三个重要的新功能\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32180.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609140755534BPvaYFNdhmI3xZH.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：iOS 10 开始升级，网易在给新闻业务找出路\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32173.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160913182808DPgQKejqMi0JCync.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "耐克给皮尔洛打造了一款鞋，像他喜爱的红酒\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32142.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160913100700Rvcn2kjK1iCzWYMI.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "宜家在中国发行了 10 年的《家居指南》，其实隐藏了这 12 个秘密\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32139.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160913082717YFX70EMHZpyrPwCT.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "爱尔兰政府不要苹果公司的钱，可爱尔兰人民不大同意\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32138.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160913080442dRqGPb4g0xVLZ6sk.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：Google 和药厂成立合资公司治疗糖尿病，苹果可能下月发布 Mac 的大更新\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32119.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160912165822zwpkhRWXDExNFdPr.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "未来能买到什么迪士尼衍生品，全看它们开的这个会了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32129.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160912230602NR7BJZg96KEwr4op.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "亚马逊也要直播体育比赛，版权竞争会越来越激烈\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32091.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160912111125m9Wn4s6ChB0b7pDI.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "我们对新 iPhone 的热情，已经越来越低了 | 好奇心小数据\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32083.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160912092647JKzCsguV1RZDIWkN.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "今日娱乐：广电加强直播行业监管，科幻小说星云奖颁奖\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32079.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160912071829O2ALUc54spgS6o0E.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：支付宝提现也要收手续费了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31967.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908120945YCBVLlDZeAi2NjFI.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "经济学家去了硅谷，他们现在是各种消费者研究的带头人\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31885.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160906175540PH7RcfSUzKbdmNlE.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "有间谍科技公司帮忙，政府可以监控智能手机上的一切\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32059.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609100535038QsEZCHRMjtp4d5L.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "隔三差五就有公司说自己在做的无人机送货，真的靠谱吗？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32032.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160909140851XbVgZenDi6589qKW.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "多伦多电影节期间，要不要来杯“沉默的拿铁”？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32062.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609101407366JG7kWO2EvIin4pr.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果重启汽车项目，也要做自动驾驶\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32063.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160910142249YmSR2JQwM6eDho3d.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "阿里巴巴继续入股微博，刚买了 1.35 亿美元股票\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32024.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609091437397FBKw3j62hDVnyHN.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "亚马逊语音助手还进入平板了，还能做更多事情\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32031.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160909140819VvCK0bSR7usZJzTp.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 不再公布首周末销量了，这是为什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32058.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160910005448M6YlDG4h2tsHfWgJ.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "优衣库把纽约地铁印上 T 恤，这是给MoMA的文化衫儿\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31984.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908152029XIOnMxy0rigt4mGE.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Apple Watch 有了二代，金表却不见了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32004.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160909002952eURtqjPETlf3J7VH.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "亚马逊在伦敦送外卖，到底是想干嘛？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/32009.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160909071726jutUOIl2VFdkfbx0.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：苹果不公布新 iPhone 首周销量，阿里体育推广电竞\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31986.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609081609244mLw1ps9yUFCZctk.JPG?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "iPhone 7 上手体验：它是更好的 iPhone，但已经不再是两年一次的大升级\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31983.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908151425GgmxBRnAlc5zk3d6.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "公开支持希拉里的星巴克 CEO，你什么时候竞选总统？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31973.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908113915gvN1hsX5BVuJFZkm.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "时装周的季节又到了，Google 希望你在搜索结果中买衣服\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31966.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908092834z7WKUcThwCgpVRyO.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "今日娱乐：PS 更新两款新版主机，乐视在美国卖自行车\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31962.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908085655wqh936izWQaM7eFr.JPG?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "苹果的“iPhone 年年焕新”计划到底是什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31919.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160907124029gGZkthU4Y0JTO6FB.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "作为健康“代言”的甜叶菊甜味剂，加入了星巴克调味台\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31943.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160908062400Ycsoaq5eLv937VdM.jpeg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "这里是 iPhone 7 和 Apple Watch 二代的具体细节，你想升级么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31920.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160907130832qMXagRiOd21STPuf.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "星巴克波特兰和西雅图门店开始卖 Brunch，仅限周末\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31924.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160907125555IuEVZhJ51LeUX2Wa.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "优衣库翻新了纽约旗舰店，把东京潮流杂志都搬了进去\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31897.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160906211330XGxR5TamOC8dzLDW.jpg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "明天凌晨一点，苹果会发布什么产品？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31909.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160907092454PY3HTXKJGsplhRCQ.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "今日娱乐：PS VR将送试玩碟，2026 年世界杯可能三国合办\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31905.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160907083829e3uwnZ9BtUdIHyci.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：小米要在印度建新工厂，星巴克在更多地区引入早午餐\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31889.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160906165105OFcwH57YGry9bAfh.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "腾讯超越中移动，成了亚洲最贵的公司 | 好奇心小数据\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31887.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160906162209pjDoA7gLzQ3JyqmE.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 又要做平板电脑了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31831.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160905150841Zve0KpY9za542ilI.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "耐克说小威是“史上最伟大运动员”，但还留了个空格\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31866.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160906104905FSiXM7sf3mc1z6t0.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 无人车还能给救护车让道了\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31858.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160906080546jxOXBkWm5Cl4aJKU.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：阿里出售美团点评股份，腾讯成亚洲市值最高公司\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31841.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160905174920AWqO9Y7xm2swQIZj.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "Google 据说下月发新手机，这次有什么不同？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31836.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160905164732GlKq75WDOJNxzadS.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "奥地利总理说，亚马逊和星巴克缴纳的税款还不如路边摊多\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31821.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/20160905161418nKGREuUgaSdxMThq.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "流量大户百度为什么也要花钱买流量？| 好奇心小数据\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31801.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609050258219gMvdOn2zCs7tkTZ.jpeg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "大公司头条：麦当劳要卖中国区业务，淘宝下架手机电话卡商品\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31767.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609021803481xYpWfrILPqiO5lv.jpg?imageMogr2/auto-orient/thumbnail/!245x185r/gravity/Center/crop/245x185/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "百度说金融的核心是人工智能，这是在说什么？\n" +
            "@@@@\n" +
            "http://www.qdaily.com/articles/31752.html\n" +
            "!!!!\n" +
            "http://img.qdaily.com/article/article_show/201609021411322CNMJTcDKlzfaGsR.jpeg?imageMogr2/auto-orient/thumbnail/!500x280r/gravity/Center/crop/500x280/quality/85/format/jpg/ignore-error/1\n" +
            "!!!!\n" +
            "上海迪士尼乐园开了快 3 个月，那些靠着它做生意的人，现在都在担心什么？\n" +
            "@@@@";


    private static String testText1 = "[‘小事 · 爸妈反对，还要不要嫁给他？', 'http://daily.zhihu.com/story/8874639', 'http://pic3.zhimg.com/62f20ec187be95f3e76463d9fddb5056.jpg']\n" +
            "['现在想想那些香港恐怖片经典，满满都是「套路」', 'http://daily.zhihu.com/story/8875388', 'http://pic4.zhimg.com/6463c8a816f0a34c0db51ba05b491f77.jpg']\n" +
            "['想要追随兴趣？No, don't follow your heart', 'http://daily.zhihu.com/story/8875447', 'http://pic2.zhimg.com/32d514634d3426354ee99746afbb9315.jpg']\n" +
            "['复活恐龙的希望，科学家们一直都没放弃', 'http://daily.zhihu.com/story/8874135', 'http://pic1.zhimg.com/d5a48ff99d7efe62c0ce4f2ae7c9c780.jpg']\n" +
            "['对偶像的爱有多深？功能磁共振告诉你', 'http://daily.zhihu.com/story/8872843', 'http://pic1.zhimg.com/02e7c2f8a6f0ecf02a81cb74bd794020.jpg']\n" +
            "['知乎好问题 · 如何挑选基金？', 'http://daily.zhihu.com/story/8875079', 'http://pic3.zhimg.com/765f9c85222f5ae37022615a3defc38a.jpg']\n" +
            "['万一地铁发生事故，记得有这样一条逃生通道', 'http://daily.zhihu.com/story/8874945', 'http://pic4.zhimg.com/477df61a69cb71ac6374358d88016357.jpg']\n" +
            "['「别逗我，车灯不就是给灯泡加个塑料壳子嘛」', 'http://daily.zhihu.com/story/8874767', 'http://pic1.zhimg.com/ef4cc6e4de8e6837245ae5df90a323ec.jpg']\n" +
            "['签下一份合同时，记得用上刚刚获得诺奖的「契约理论」', 'http://daily.zhihu.com/story/8874308', 'http://pic1.zhimg.com/52a1e911bc37b3772ee574a77621f03c.jpg']\n" +
            "['一看到萌萌的宝宝和小猫小狗，我怎么就管不住我这手呢', 'http://daily.zhihu.com/story/8872747', 'http://pic3.zhimg.com/342d0a860b943a0f23e8cb546ee897aa.jpg']\n" +
            "['大误 · 我很中意你，不如我们交换一下人格？', 'http://daily.zhihu.com/story/8628638', 'http://pic3.zhimg.com/613849cfe01ebfd309eccafd0e90d75a.jpg']\n" +
            "['多印钱就造成通胀？事情并不是这么简单', 'http://daily.zhihu.com/story/8872331', 'http://pic1.zhimg.com/27fba2e6d2b934f21451ca77309ec590.jpg']\n" +
            "['可再生能源发电就像是悬在火电头上的「达摩克利斯之剑」', 'http://daily.zhihu.com/story/8873028', 'http://pic2.zhimg.com/2bcd54000aa4e1c491e2e15ca9d90a65.jpg']\n" +
            "['别的超级英雄都是成年人，为什么蜘蛛侠就是个孩子？', 'http://daily.zhihu.com/story/8864208', 'http://pic1.zhimg.com/8c62a958a471450db6536628cb750894.jpg']\n" +
            "['出名之前，日本漫画家赚的和便利店店员差不多', 'http://daily.zhihu.com/story/8872067', 'http://pic4.zhimg.com/e91b0a0d6dcb4cc93caaa17b4448446b.jpg']\n" +
            "['销售、财务和技术，哪个职位将来能当 CEO？', 'http://daily.zhihu.com/story/8872367', 'http://pic2.zhimg.com/55bcae7deaeccb9a74ffec26f4d2a551.jpg']\n" +
            "['从现在开始，多做一些「不为什么」的事', 'http://daily.zhihu.com/story/8870875', 'http://pic3.zhimg.com/64acf185375b610008e9e45cbfe7b01a.jpg']\n" +
            "['又限购，买不到房子怎么办？', 'http://daily.zhihu.com/story/8871233', 'http://pic4.zhimg.com/d8f41fe5243a59e016965ec27b22ffc3.jpg']\n" +
            "['读读日报 24 小时热门 TOP 5 · 高房价再到十字路口', 'http://daily.zhihu.com/story/8872875', 'http://pic3.zhimg.com/316df4056e041f9f346e865e3dd0afe2.jpg']\n" +
            "['瞎扯 · 如何正确地吐槽', 'http://daily.zhihu.com/story/8872005', 'http://pic1.zhimg.com/97e381a85f9895d0cc3fa417910a6c44.jpg']\n" +
            "['小事 · 两个小时，赚了七千块', 'http://daily.zhihu.com/story/8725019', 'http://pic4.zhimg.com/7dc751c7db11ca90a8cffa7e263e5273.jpg']\n" +
            "['这可能是伍迪 · 艾伦十几年来，最贵的一部戏', 'http://daily.zhihu.com/story/8871604', 'http://pic2.zhimg.com/1de4f0bf399ed32ee1dc3f23fc794a2d.jpg']\n" +
            "['哪怕不认识车标的人也会一眼看出，这车肯定很贵', 'http://daily.zhihu.com/story/8872012', 'http://pic3.zhimg.com/01f6f732a921de697f511a0de30212a6.jpg']\n" +
            "['我在美国学设计，作业真的好多……', 'http://daily.zhihu.com/story/4884882', 'http://pic1.zhimg.com/0ab8ec6feca30d44aad9ef8f0bd92b18.jpg']\n" +
            "['公司从小到大蒸蒸日上，财务和 HR 准备出场了', 'http://daily.zhihu.com/story/8871460', 'http://pic4.zhimg.com/9fab44ac9e5d29b18933fb3baf1f3443.jpg']\n" +
            "['知乎好问题 · 如何从时尚杂志中学到东西？', 'http://daily.zhihu.com/story/8871492', 'http://pic4.zhimg.com/5e834fff7647e168f1b92984d7e4c487.jpg']\n" +
            "['把照片调出电影质感，有了它方便好多', 'http://daily.zhihu.com/story/8870448', 'http://pic4.zhimg.com/ae402acdd45d42c452928d4e0ae952ff.jpg']\n" +
            "['出了问题，先别急着责怪「强势母亲」「恶婆婆」「无能丈夫」……', 'http://daily.zhihu.com/story/8870686', 'http://pic2.zhimg.com/267a244e6645491225dc291e6573fb61.jpg']\n" +
            "['当城市开始衰落，解决的方法也许是「不要拯救」', 'http://daily.zhihu.com/story/8870968', 'http://pic2.zhimg.com/6ea75f337b2dea1ae71091746abcb06d.jpg']\n" +
            "['很早以前，动画里的人物头发颜色还挺正常的，后来……', 'http://daily.zhihu.com/story/8865033', 'http://pic2.zhimg.com/7bf3f3b878b0c8d6d98db74e491356b9.jpg']";


    private static void test2() {
        HaoQiXinDaoOrm haoQiXinDaoOrm = new HaoQiXinDaoOrm(MainActivity.context);
        testText2 = testText2.replace("\n" , "");
        String[] list = testText2.split("@@@@");
        for (int i = 0 ; i < list.length - 1 ; i++){
            String[] l = list[i].split("!!!!");
            HaoQiXin haoqixin = new HaoQiXin();
            haoqixin.setTitle(l[2]);
            haoqixin.setAddress(l[0]);
            haoqixin.setTitle_image(l[1]);
            haoqixin.setIsRead(0);
            haoQiXinDaoOrm.add(haoqixin);
        }
    }


    private static void test1() {
        ZhiHuDaoOrm zhiHuDaoOrm = new ZhiHuDaoOrm(MainActivity.context);

        testText1 = testText1.replace("\n" , "");
        testText1 = testText1.replace("[" , "");
        testText1 = testText1.replace("'" , "");
        String[] list = testText1.split("]");
        for (int i = 0 ; i < list.length - 1 ; i++ ){
            String[] llist = list[i].split(", ");
            ZhiHu zhihu = new ZhiHu();
            zhihu.setTitle(llist[0]);
            zhihu.setAddress(llist[1]);
            zhihu.setTitle_image(llist[2]);
            zhihu.setIsRead(0);
            zhiHuDaoOrm.add(zhihu);
        }

    }
}
