-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2016-11-22 12:01:23
-- 服务器版本： 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `little_see`
--

-- --------------------------------------------------------

--
-- 表的结构 `haoqixin`
--

CREATE TABLE `haoqixin` (
  `id` int(10) NOT NULL,
  `title_image` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dateid` int(10) DEFAULT NULL,
  `title` varchar(100) CHARACTER SET gb2312 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `haoqixin`
--

INSERT INTO `haoqixin` (`id`, `title_image`, `address`, `dateid`, `title`) VALUES
(2, 'http://img.qdaily.com/article/article_show/20161122165057djZK9OpC7IrYWykq.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34758.html', 21, '销售目标从500亿美元下调至300亿，优衣库怎么了？ | 好奇心小数据'),
(3, 'http://img.qdaily.com/article/article_show/20161121225350d80RzUBZ1jGKJIeu.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34733.html', 21, 'MacBook Pro 新广告，把人类的发明创造史讲了一遍'),
(4, 'http://img.qdaily.com/article/article_show/20161122090134kE1ZljpTzs5O9baJ.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34727.html', 21, '大公司头条：福岛 7.3 级地震；酷派说今年要亏 30 亿元'),
(5, 'http://img.qdaily.com/article/article_show/20161121154157W3OPqIi94SrMcbN2.JPG?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34703.html', 21, '阿里影业请来《哈利?波特》制片人，拍一个畅销的英国故事'),
(6, 'http://img.qdaily.com/article/article_show/20161121181718n9vp6ubIlfVr5BR3.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34726.html', 21, '高调发布一款节日特饮，星巴克想卖更多即饮咖啡了'),
(7, 'http://img.qdaily.com/article/article_show/201611211748407dzyL8vrsZBGKtcY.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34718.html', 21, '苹果给出问题的 iPhone 6s 换电池，但故障原因还是没有说明白'),
(8, 'http://img.qdaily.com/article/article_show/2016112116402195y8rOAXEc3CiPpS.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34693.html', 21, '这几年用互联网改造汽车市场的努力，方向可能都错了 | 2016 大公司数字化 ⑥'),
(9, 'http://img.qdaily.com/article/article_show/20161121154600C6hkexu1A5HF2aSK.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34704.html', 21, '「票房」冯小刚手撕万达，他的焦虑会如何影响票房的走向？'),
(10, 'http://img.qdaily.com/article/article_show/20161121115552A58D2lkMwasgeZyH.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34686.html', 21, '亚马逊在意大利开始卖车了，但能做的很有限'),
(11, 'http://img.qdaily.com/article/article_show/20161121124454mTAncZOLDE7ebC30.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34689.html', 21, '「这世界」讨厌特朗普歧视没错，但歧视特朗普好像也不太对'),
(12, 'http://img.qdaily.com/article/article_show/20161121075332ojv0PM5ue6KnhdJH.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34675.html', 21, '大公司头条：宝马和百度无人车合作终止，阿里巴巴又投资了一个超市'),
(13, 'http://img.qdaily.com/article/article_show/20161118143950aNJqBGbSuO3IglEU.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34632.html', 21, '微软把编程工具带到了 Mac 上，吸引早先流失的程序员'),
(14, 'http://img.qdaily.com/article/article_show/20161119105439ITdCcySxr89Hliba.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34647.html', 21, '苹果要在美国生产手机，问题不仅仅是成本的增加'),
(15, 'http://img.qdaily.com/article/article_show/20161118135548B87EG0xnVQrpKy1c.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34629.html', 21, '苹果想让帕金森病人随时知晓病情，这事儿医生做不了'),
(16, 'http://img.qdaily.com/article/article_show/201611191317168gfWs2zSFV97bKQR.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34650.html', 21, '微信小程序现在还想占据 Android 手机的桌面了'),
(17, 'http://img.qdaily.com/article/article_show/20161118141500k49FPfpBgEXzCuQG.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34633.html', 21, '冯小刚发布公开信，指责万达打压《我不是潘金莲》'),
(18, 'http://img.qdaily.com/article/article_show/20161118131945QMjzbTJutLxgiqVS.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34627.html', 21, '麦当劳现在要送餐上桌了，这会让你更想去吗？'),
(19, 'http://img.qdaily.com/article/article_show/20161118112707nzbGEpSuA61v3Lw5.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34618.html', 21, 'OLED 屏幕迎来了苹果这个大客户，只是生产商还造不出来'),
(20, 'http://img.qdaily.com/article/article_show/201611180804209HeXj84blhPAwa61.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34606.html', 21, '大公司头条：苹果考虑在美国造 iPhone，阿里投资的百世物流要 IPO'),
(21, 'http://img.qdaily.com/article/article_show/20161117164228CxW0SOy57aQqVhvX.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34590.html', 21, '为了“黑色星期五”，亚马逊中国把货摆到了三里屯'),
(22, 'http://img.qdaily.com/article/article_show/20161117104212AFgREd3avIWHBzmP.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34574.html', 21, 'HTC 的头盔有了一个酷炫的用处：帮你飞越地球表面'),
(23, 'http://img.qdaily.com/article/article_show/20161117230811BLAmxjwn5hqpJElv.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34600.html', 21, '耐克请来艺术家Kaws，画了一个酷酷的篮球场'),
(24, 'http://img.qdaily.com/article/article_show/20161118004748vLjnX0o7QekAp5Mc.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34602.html', 21, '麦当劳为自己的“快闪”产品“麦排骨”，做了个小程序'),
(25, 'http://img.qdaily.com/article/article_show/20161117160021VK3XhFaGq8uixSNL.JPG?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34582.html', 21, 'MacBook Pro 两日体验，这是一次大升级，但你不一定在意那个 Bar'),
(26, 'http://img.qdaily.com/article/article_show/20161117122220CL4kDTKMlSW02pJE.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34579.html', 21, '迪士尼在研究一种人工智能，让声音和画面的剪辑可以同步'),
(27, 'http://img.qdaily.com/article/article_show/20161117113027FZqn6JX0RBko39CK.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34577.html', 21, '腾讯打开账本，这个季度微信用户增长基本到头'),
(28, 'http://img.qdaily.com/article/article_show/20161117123124sAnha9cOdFiE6rle.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34580.html', 21, '麦当劳巨无霸第一次修改配方，加入了泰式辣椒酱'),
(29, 'http://img.qdaily.com/article/article_show/20161117102726dU9qxZg2OLhRuEao.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34572.html', 21, 'Google 翻译变聪明了，我们试了一下'),
(30, 'http://img.qdaily.com/article/article_show/20161116135420XFyM5qIm4odbGB7g.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34532.html', 21, '神州租车发布新财报了，问题远不止增长放缓那么简单'),
(31, 'http://img.qdaily.com/article/article_show/20161116194445bdsZYqopTmtyvrMN.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34555.html', 21, '真人版《美女与野兽》的预告片，24 小时内被观看了 1.27 亿次'),
(32, 'http://img.qdaily.com/article/article_show/201611161830574yBWYolgkb83IDH5.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34550.html', 21, '春节还没来，支付宝就要开始做电视红包了'),
(33, 'http://img.qdaily.com/article/article_show/20161116165117HUlOIPDJ0ebTfgRw.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34545.html', 21, '苹果推出了一本摄影集致敬乔布斯，据说花了8年时间'),
(34, 'http://img.qdaily.com/article/article_show/201611161216113yw1bAB6RnV2eMgi.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34531.html', 21, '在印度，联想和小米手机都卖到前五名了'),
(35, 'http://img.qdaily.com/article/article_show/20161116084355F7JUsgzYQbh5LBuC.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34516.html', 21, 'Google 和 Facebook 说，不会让假新闻网站做广告'),
(36, 'http://img.qdaily.com/article/article_show/201611160748250egCz21hrL6PoTI3.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34514.html', 21, '大公司头条：京东发财报、拆分金融业务；亚马逊要告自己平台上的卖家；超级马里奥 30 天后来 iPhone'),
(37, 'http://img.qdaily.com/article/article_show/20161115151746hiwG76Mf9TA3KdDs.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34486.html', 21, '被万达并购半年后，时光网第一个产品是做直播'),
(38, 'http://img.qdaily.com/article/article_show/20161115190010wfAJQg9ZThBMPUnl.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34500.html', 21, '耐克在纽约开的新旗舰店，就像是好几家店拼起来的'),
(39, 'http://img.qdaily.com/article/article_show/20161115230438tYh2OCAGrTiL0lsV.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34510.html', 21, '中国的院线并购潮已经开始，它会把电影产业带向何方？'),
(40, 'http://img.qdaily.com/article/article_show/201611151731282Ggp76Zv3aym8uO1.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34497.html', 21, '亚马逊的智能家居设备，成为了新的营销工具'),
(41, 'http://img.qdaily.com/article/article_show/20161115103924hk1QwRHO7yi5CVul.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34469.html', 21, '传闻苹果要做 AR 眼镜了？那它要解决很多难题'),
(42, 'http://img.qdaily.com/article/article_show/20161115081726PxemL3jf6HZCdW8Y.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34462.html', 21, '大公司头条：百度糯米放弃酒店业务，特斯拉涨价，三星收购汽车电子厂商'),
(43, 'http://img.qdaily.com/article/article_show/20161114162341JuBzTDqgf9a5b17L.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34444.html', 21, '中国资本不太安分，又和西甲传出了两桩“绯闻”'),
(44, 'http://img.qdaily.com/article/article_show/20161114202623frE3VgmnaoP7ARZ2.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34454.html', 21, 'Google 给虚拟现实手机定了具体标准，达标的没几个'),
(45, 'http://img.qdaily.com/article/article_show/20161114163705gdjtu10M6zkef9Gs.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34442.html', 21, '宜家的第二家订货中心开在北京，是为开网店做准备吗'),
(46, 'http://img.qdaily.com/article/article_show/20161114122614sPXqBWCKmDEyQ03V.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34424.html', 21, '今年，中国科技巨头去美国买买买的钱也少了'),
(47, 'http://img.qdaily.com/article/article_show/20161114005931SAdEZkObNzf6hq89.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34410.html', 21, '数字竞赛停下来终归是件好事，今年双 11 可能只是个开始'),
(48, 'http://img.qdaily.com/article/article_show/2016111407315821VfDRK6ykTnONML.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34413.html', 21, '大公司头条：苹果明年增加一款 10.9 英寸 iPad，彼得?蒂尔加入特朗普过渡团队'),
(49, 'http://img.qdaily.com/article/article_show/20161113103534oe3wACiYG9frZF8h.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34401.html', 21, '罗伯特?德尼罗主演的电视剧，1.6 亿美元卖给了亚马逊'),
(50, 'http://img.qdaily.com/article/article_show/20161113032234vXlOZoLQW0j9i4h8.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34380.html', 21, '亚马逊为全美最权威时装设计比赛做片子，但被骂了'),
(51, 'http://img.qdaily.com/article/article_show/20161111182428egqKH30fGcb9MoBF.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34384.html', 21, '微信广告看上了小品牌，开始在二线城市推本地广告'),
(52, 'http://img.qdaily.com/article/article_show/20161111183446lJH16obdGAvrMRT8.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34382.html', 21, 'Chrome装机量超过20亿，但浏览器的未来会好吗 | 好奇心小数据'),
(53, 'http://img.qdaily.com/article/article_show/20161111143638UZoVsW1adG4HAbK7.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34372.html', 21, '迪士尼的业绩有些波动，但华尔街接受了他们的解释'),
(54, 'http://img.qdaily.com/article/article_show/20161111142745AgRsHaZI2lxmehk9.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34365.html', 21, '资本市场不买双 11 的账，阿里和京东股价都跌了'),
(55, 'http://img.qdaily.com/article/article_show/20161111080246cAJEDMh26BQGtU5i.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34345.html', 21, '大公司头条：阿里双 11 前一小时交易 353 亿，市值跌了 101 亿美元；美国科技巨头高管对大选做回应'),
(56, 'http://img.qdaily.com/article/article_show/20161110203319RnSdyJUj53QxKsMW.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34343.html', 21, '双 11 结束了，成交额 1207 亿，这还是现场唯一在意的数字'),
(57, 'http://img.qdaily.com/article/article_show/20161110145619CygSfAw1Y4MFU6m3.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34322.html', 21, 'Google 那个让你帮着画地图的功能，现在被放弃了'),
(58, 'http://img.qdaily.com/article/article_show/20161110151911WJhtsQ9YMqIeVa8D.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34326.html', 21, '新 MacBook Pro 特别贵，但似乎卖得还不错'),
(59, 'http://img.qdaily.com/article/article_show/20161109183125k2fyJg9sLq05U87m.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34289.html', 21, '美国 Apple Store 上架官翻 iPhone，这说明什么？'),
(60, 'http://img.qdaily.com/article/article_show/201611091830053lVw8viSeFMYmX0A.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34291.html', 21, '和耐克品牌一辈子绑在一起？C罗说他愿意'),
(61, 'http://img.qdaily.com/article/article_show/20161109081830wcAng5fQ1b4Ba6Jo.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34260.html', 21, '大公司头条：美国大选投票开始，中午出结果；乐视召开投资者会议；Google 放弃无人机项目'),
(62, 'http://img.qdaily.com/article/article_show/20161108224936PnklEA4O8fKRBoQD.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34253.html', 21, '乐视到了生死关头，这会是一系列泡沫破灭的开始吗？'),
(63, 'http://img.qdaily.com/article/article_show/201611081221276uvGR4cOoTs0VQtd.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34225.html', 21, '美国大选最后关头，科技公司都如何花式催人投票？'),
(64, 'http://img.qdaily.com/article/article_show/20161108154302OAvigMCQ79fRWpcj.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34235.html', 21, 'Apple News 广告都外包出去了，这生意并不是很好做'),
(65, 'http://img.qdaily.com/article/article_show/20161108141332859QReFEzJUlknmx.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34232.html', 21, '亮黑色还很难买，又传出 iPhone 7 要有亮白的消息了'),
(66, 'http://img.qdaily.com/article/article_show/20161108075955szCu9wAFhDVOmofS.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34215.html', 21, 'iPhone 假应用涌现，据说大部分来自中国开发者'),
(67, 'http://img.qdaily.com/article/article_show/20161108084145Pzp3YO25RMxtyvrZ.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34216.html', 21, '大公司头条：交通部公布网约车司机考试细则，特斯拉充电站要收费了'),
(68, 'http://img.qdaily.com/article/article_show/20161107180155vsHnF1fretk0BQEd.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34207.html', 21, '“小鲜肉+大 IP”，腾讯视频要依靠这些继续吸引会员'),
(69, 'http://img.qdaily.com/article/article_show/20161107234348qig9LtMl0r3ZOpXm.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34214.html', 21, '他们都说并没有少花钱，那么“双11”广告都去哪儿了？| 双11洞察③'),
(70, 'http://img.qdaily.com/article/article_show/20161107161645H83jP6xbAylSpXgV.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34199.html', 21, '都谈到地球的未来了，腾讯的海外投资实际上是怎么回事？'),
(71, 'http://img.qdaily.com/article/article_show/20161107153734mSpbP98vIiYWBjUh.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34194.html', 21, '因为用户的吐槽太多，苹果给 USB-C 转接口降价了'),
(72, 'http://img.qdaily.com/article/article_show/201611071029449LXEOmouZae5v407.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34172.html', 21, '大公司之间的微妙感情，从这个 LinkedIn 争夺战里就能看出门道'),
(73, 'http://img.qdaily.com/article/article_show/20161107121734PmKAkeCzRdpG3w2M.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34180.html', 21, '麦当劳明年推出手机订餐 app，不过暂时没提中国市场'),
(74, 'http://img.qdaily.com/article/article_show/20161107081558l4MS3vBzK9ipwG2n.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34169.html', 21, '大公司头条：乐视承认资金短缺停止烧钱，北京市网约车新政还在“调试”'),
(75, 'http://img.qdaily.com/article/article_show/2016110703182230UITMLDA2SylB6r.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34166.html', 21, '似乎已经战胜传统渠道的小米，今年为什么被 OPPO、vivo 打败了？ | 2016 大公司数字化②'),
(76, 'http://img.qdaily.com/article/article_show/20161106072419ljFueL2UW6KO9GCg.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34160.html', 21, '为了吸引年轻人，优衣库一口气出了 6 支方言广告'),
(77, 'http://img.qdaily.com/article/article_show/20161104172409V4l8L5UeoIpStPhm.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34132.html', 21, '以后去亚马逊书店买书，非会员得付全价了'),
(78, 'http://img.qdaily.com/article/article_show/20161104164554mk3Dw2vIh4cb0rBd.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34130.html', 21, 'iPhone 7 的新广告，是一个老头在海滩公放小号曲'),
(79, 'http://img.qdaily.com/article/article_show/20161104163124DhK6QeUJp8bBYAcz.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34128.html', 21, '试行效果不错，麦当劳明年在全美推出三种大小巨无霸'),
(80, 'http://img.qdaily.com/article/article_show/20161104140804nbjXwKzS40qFtEsW.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34109.html', 21, '开新店策略还管用，星巴克的股票终于不再跌了'),
(81, 'http://img.qdaily.com/article/article_show/20161104131444y2lU4Kgikh5omGsM.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34107.html', 21, '亚马逊中文海淘上线两年之后，把英国商店也搬来了'),
(82, 'http://img.qdaily.com/article/article_show/20161104055525qE7APJrh3tLiHxNj.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34089.html', 21, '能和故事里的角色聊天的话，你的孩子或许会更爱读书？'),
(83, 'http://img.qdaily.com/article/article_show/20161104123315yInlGaVcNDxhzEFH.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34104.html', 21, '蚂蚁金服被传可能在香港上市，马云和蔡崇信同时开了条件'),
(84, 'http://img.qdaily.com/article/article_show/201611031027392HZBvXVxd4aWzKtM.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34065.html', 21, '阿里巴巴的财报，第一次拿掉了成交额'),
(85, 'http://img.qdaily.com/article/article_show/201611040822582XFAos3jZ58Cefi6.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34092.html', 21, '大公司头条：微信小程序开放公测，Google 拒绝欧盟反垄断指控'),
(86, 'http://img.qdaily.com/article/article_show/20161103214912OxKdXqlCzJBsQMy4.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34084.html', 21, '王健林跑去洛杉矶“吓唬”好莱坞，中国电影的气势已经膨胀到这地步了吗？'),
(87, 'http://img.qdaily.com/article/article_show/20161103154728oZpIOz1YMVbDqmAS.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34077.html', 21, '办公协作应用的老大 Slack 呛声微软：嘿，你也来了'),
(88, 'http://img.qdaily.com/article/article_show/20161103143201ErnRY7hJdqgO6vMw.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34070.html', 21, '“星巴克，去你的。我的咖啡不应该（也不需要）政治洗脑”'),
(89, 'http://img.qdaily.com/article/article_show/20161031184120dOEtYMSTfuDr3U9Q.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33951.html', 21, '微信小程序内测一个多月，工程师说它是个封闭生态'),
(90, 'http://img.qdaily.com/article/article_show/20161103095913WJHeo7jy39mqUprK.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34061.html', 21, '今日娱乐：《我不是潘金莲》过审，迪士尼年度票房破纪录'),
(91, 'http://img.qdaily.com/article/article_show/20161102234938Yc8jNutS1fJ2Hg54.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34054.html', 21, '瑞银说越来越多人不喜欢 iPhone 了，特别是在中国'),
(92, 'http://img.qdaily.com/article/article_show/201611022259235QsdvL9yeoASE4bJ.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34052.html', 21, '大公司头条：联想手机业务又换负责人，之前是管人力资源的'),
(93, 'http://img.qdaily.com/article/article_show/20161102234327KBfsqJOot83SzkA4.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34053.html', 21, '从自助点餐到外卖平台，技术让麦当劳得到什么，又失去什么| 2016 大公司数字化①'),
(94, 'http://img.qdaily.com/article/article_show/20161101152630OMVlaS9wekGtK0Yg.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33981.html', 21, '苹果零售店逐个改头换面，它要的社区感到底能用来干嘛？'),
(95, 'http://img.qdaily.com/article/article_show/201611021236066kRDPAcTWewb35yF.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34023.html', 21, '新的Emoji要来了，耸肩表情和David Bowie都会有'),
(96, 'http://img.qdaily.com/article/article_show/201611021342236fHbdeqDZgsJ4zr1.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34028.html', 21, '7 年后，YouTube 在德国的版权纠纷终于结束了'),
(97, 'http://img.qdaily.com/article/article_show/20161102161747mLHvho19k0Z3bWpG.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34038.html', 21, '分析师们开始建议把“耐克的股票卖了”，这是怎么回事？'),
(98, 'http://img.qdaily.com/article/article_show/20161102142303ipw0gIPajcXkJGnL.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34031.html', 21, '阿里巴巴今天要发新财报，投资人不怎么看好它提前做空了'),
(99, 'http://img.qdaily.com/article/article_show/2016110102415551DJ7AMhEZF0veIs.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33961.html', 21, 'CrossFit 这么 Hard 的健身项目，是如何流行起来的？|市场发明家'),
(100, 'http://img.qdaily.com/article/article_show/201611021030143AI6Rbkl2cQhNKT7.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34019.html', 21, '苹果也要参加双十一，但只打折卖耳机'),
(101, 'http://img.qdaily.com/article/article_show/20161101172852IOXiGtwkqldz9n35.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33993.html', 21, '游戏直播鼻祖的创始人，做了一个视频版的分答'),
(102, 'http://img.qdaily.com/article/article_show/20161102100331B0TFv89irEbLcXIO.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/34014.html', 21, '今日娱乐：电视剧版“至尊宝”长这样，雷?阿伦宣布退役'),
(103, 'http://img.qdaily.com/article/article_show/20161102081509vPEdycHkal8DMG6B.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/34013.html', 21, '大公司头条：苹果无线耳机明年才能来，Instagram 要卖货了，Airbnb 中国的数据要存在本地'),
(104, 'http://img.qdaily.com/article/article_show/20161028133739rLCDEz1vnUhQKRXb.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33860.html', 21, 'Google的搜索广告收入还在涨，但单价却越来越低了'),
(105, 'http://img.qdaily.com/article/article_show/20161030091251P5HVXaZMzLxq8Y42.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33814.html', 21, '阿里开始“内容化”之后，大大小小的商家都发生了什么变化？|双11洞察②'),
(106, 'http://img.qdaily.com/article/article_show/20161101143940ME0nSihcapVyZKYo.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33977.html', 21, '如今中国动画有钱了，已经不满足于做日本人的学生了'),
(107, 'http://img.qdaily.com/article/article_show/20161101073919UE0WY6wux8INMRyv.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33964.html', 21, '赞助上海马拉松的第五年，这项赛事对耐克有多重要？'),
(108, 'http://img.qdaily.com/article/article_show/20161101100645CGEk98amZ0RPVUAh.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33967.html', 21, '今日娱乐：《白雪公主》拍真人电影，国足公布首批集训名单'),
(109, 'http://img.qdaily.com/article/article_show/201611010840264Fwdu2hAZDk0vJXo.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33955.html', 21, '大公司头条：网约车今天开始实施，这里是目前各地信息汇总；苹果应用商店加入支付宝付款；百胜中国今天在美上市'),
(110, 'http://img.qdaily.com/article/article_show/201610311714080t51eSYBRINzgbaV.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33946.html', 21, '阿里新成立了文化娱乐集团，CEO原来是个做浏览器的'),
(111, 'http://img.qdaily.com/article/article_show/20161031114916AgTpKOM5Qw8B4Nbz.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33919.html', 21, '苹果电视聚合应用少了 Netflix，这也说明到底谁更依赖谁'),
(112, 'http://img.qdaily.com/article/article_show/20161031073409gBKtd6nDhPo3cyzx.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33913.html', 21, '大公司头条：娃哈哈竞购美国乳业巨头，微软推出 MacBook 换购 Surface 计划'),
(113, 'http://img.qdaily.com/article/article_show/20161024200803TBE2g0ZSu5VCIX1q.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33678.html', 21, 'Google 早就变了隐私条款，你可能都没注意到吧'),
(114, 'http://img.qdaily.com/article/article_show/20161026233311WHD6rqa7c5FUxlPC.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33788.html', 21, '淘宝口口声声要“做内容”，这一切到底是怎么发生的？| 双11洞察①'),
(115, 'http://img.qdaily.com/article/article_show/201610300845469vf2IqFKPtQjkA5B.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33899.html', 21, '苹果说新 MacBook Pro 便宜版适合 Air 用户？我们试用了一下'),
(116, 'http://img.qdaily.com/article/article_show/201610271300145gtN9GqbBSkA8wDT.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33813.html', 21, '库克一直在强调智能助理，可是苹果这方面不强势啊'),
(117, 'http://img.qdaily.com/article/article_show/201610281336289cIlNbSjwRMOW1Gh.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33859.html', 21, '亚马逊终于又成功消灭了利润，它这次又把钱烧哪儿了？'),
(118, 'http://img.qdaily.com/article/article_show/20161028131038UazuFvHQkD5ZBd3C.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33856.html', 21, '百度的广告收入首次下滑，连补贴烧钱也变少了'),
(119, 'http://img.qdaily.com/article/article_show/20161028104050Ke1USFH3igsIn5Cr.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33852.html', 21, '亚马逊把 Prime 会员带到了中国，海淘包邮'),
(120, 'http://img.qdaily.com/article/article_show/20161028095014bc8xdTv3BFQfD7S2.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33849.html', 21, '今日娱乐：Minecraft上Apple TV，玩具总动员4延期'),
(121, 'http://img.qdaily.com/article/article_show/20161028074254h7gnACOqBizMtQ1x.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33843.html', 21, '大公司头条：苹果发布带触摸屏的笔记本电脑，阿里旅行更名“飞猪”'),
(122, 'http://img.qdaily.com/article/article_show/20161027103929fkuMX6A7NaL2dZGK.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33799.html', 21, 'Google 那个酷酷的高速光纤项目，似乎换了个推进策略'),
(123, 'http://img.qdaily.com/article/article_show/20161027164800QURPlDmzjNCgavTu.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33826.html', 21, '南瓜拿铁太受欢迎，星巴克等推出时间越来越早'),
(124, 'http://img.qdaily.com/article/article_show/20161028062509Kc3aogNrq2dv0MJD.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33839.html', 21, '新 MacBook Pro 上手体验，苹果第一次给笔记本装上触控屏'),
(125, 'http://img.qdaily.com/article/article_show/20161027155807lgidxsDFuN4t2mG1.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33820.html', 21, '负责内容投资的副总裁要离职了，小米的内容做得怎样了？'),
(126, 'http://img.qdaily.com/article/article_show/20161027164034bDipdMg829JR35kV.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33824.html', 21, '入主九个月，乐视和北京国安的合作在赛季中破裂'),
(127, 'http://img.qdaily.com/article/article_show/20161027131958SondwU0DVZRJYKF6.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33812.html', 21, '为了推 Win 10，微软拉了很多厂商一起做 VR'),
(128, 'http://img.qdaily.com/article/article_show/20161027095641Yk91FHOaRjlrBM8L.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33803.html', 21, '今日娱乐：派拉蒙也要“007”，天下霸唱新书影视版权卖了4000万'),
(129, 'http://img.qdaily.com/article/article_show/20161026213823T1xWBKGenF4LHcY0.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33784.html', 21, '一周两次表态要做海外，滴滴在急什么，它的机会有多大？'),
(130, 'http://img.qdaily.com/article/article_show/20161026171710hsPoFwKuL0qNmGT6.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33777.html', 21, '都说高尔夫不赚钱，阿里体育还要花钱办女子巡回赛'),
(131, 'http://img.qdaily.com/article/article_show/20161026165112Dq6Om2sFLRYMp7ha.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33774.html', 21, '苹果财报说下季度就恢复增长，但为什么股价还是跌了？'),
(132, 'http://img.qdaily.com/article/article_show/201610262145003SDLPCROsMp2qdc0.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33786.html', 21, 'NBA 新赛季，库里的新鞋和广告都上线了'),
(133, 'http://img.qdaily.com/article/article_show/20161026121806IrakwvGHXZefVtEF.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33753.html', 21, 'MacBook Pro 马上来了，跟之前透露出来的消息长得差不多'),
(134, 'http://img.qdaily.com/article/article_show/20161026040836h8pQnM4cOkijlSVW.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33730.html', 21, '硅谷最大的几个科技公司，怎么造个车就这么难呢？'),
(135, 'http://img.qdaily.com/article/article_show/20161026081425jOzJUfLkB185qvCa.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33741.html', 21, '大公司头条：苹果新季度利润依然在下滑，Google 要做巨型平板'),
(136, 'http://img.qdaily.com/article/article_show/20161025181500RWsgVX2lvKOTd5CD.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33725.html', 21, '小米发了两台新手机，想用更好看的产品卖更贵一点'),
(137, 'http://img.qdaily.com/article/article_show/20161025144615yKLUkE27mqdsoaMz.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33706.html', 21, 'Google 也要做无线 VR 头盔，还可以追踪眼球'),
(138, 'http://img.qdaily.com/article/article_show/201610250611428hWHkeTQPM1GIZ2D.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33689.html', 21, '麦当劳三季度业绩不错，但还是不被华尔街看好'),
(139, 'http://img.qdaily.com/article/article_show/20161025094342eDq1UNgOSFLmCrXb.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33696.html', 21, '今日娱乐：昆汀要去导演《死侍 2》？赵丽颖参演韩寒新片'),
(140, 'http://img.qdaily.com/article/article_show/20161025080537uh5DL7eiM3psGJbR.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33692.html', 21, '大公司头条：海航买下四分之一希尔顿，智能手表销量三季度跌了一半'),
(141, 'http://img.qdaily.com/article/article_show/20161024232624xGEmfnldRp7gLwN5.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33684.html', 21, '卖公司这事还是有很多学问的，Twitter 怎么就尴尬了？'),
(142, 'http://img.qdaily.com/article/article_show/20161024174603J2Evf4Hgb3QRLiM6.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33667.html', 21, '在医院看病也用微信支付，腾讯这回可能想多了????'),
(143, 'http://img.qdaily.com/article/article_show/20161024145023lOr5Jy9L46c27s8m.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33659.html', 21, '马化腾说，微信最早就是个邮箱'),
(144, 'http://img.qdaily.com/article/article_show/201610241141538ceDAnPLhsOvXCZf.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33647.html', 21, '「这世界」电脑自动联想出来的论文，居然还能参加学术会议？'),
(145, 'http://img.qdaily.com/article/article_show/20161023113146KkjaesTOUwZid36Y.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33618.html', 21, '微信公号底下那块广告又改版了，微信以后想怎么做广告？'),
(146, 'http://img.qdaily.com/article/article_show/20161024075108jFSYvgZresP7bnkE.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33630.html', 21, '大公司头条：AT&T 宣布以 854 亿美元收购时代华纳，Google 在泰国过滤内容'),
(147, 'http://img.qdaily.com/article/article_show/20161021185536Ry6cG5xslTUo7DnE.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33608.html', 21, 'Google 在纽约的快闪店终于开了，但它并不卖货'),
(148, 'http://img.qdaily.com/article/article_show/20161021112756h7xTEBSasDN5GOPq.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33574.html', 21, '粉丝支持星战可以，但要拿来赚钱，迪士尼可不答应'),
(149, 'http://img.qdaily.com/article/article_show/20161021120508fgymw6P5AaqGZLFv.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33591.html', 21, '新剧《如果蜗牛有爱情》就要播出，它能创造高收视吗？'),
(150, 'http://img.qdaily.com/article/article_show/20161021081711kMhUyiPLzCTrubYd.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33568.html', 21, '大公司头条：任天堂发布新主机 Switch，中国区 iOS 应用营收超美国，沃尔玛投资新达达'),
(151, 'http://img.qdaily.com/article/article_show/201610201223200u1C5kqMAoQn7OFp.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33522.html', 21, '王家卫和张嘉佳拍的《摆渡人》，确定 12 月 23 日上映'),
(152, 'http://img.qdaily.com/article/article_show/201610201829343k51VsNIujbJmlqc.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33548.html', 21, '苹果和建筑公司合作，要卖装有全套智能家居的房子'),
(153, 'http://img.qdaily.com/article/article_show/20161020164528jivZuVs9RJQB0cDU.JPG?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33537.html', 21, 'QQ 做了十八年，腾讯开始为了品牌运营认真做企鹅玩偶了'),
(154, 'http://img.qdaily.com/article/article_show/20160923191047t0iEpe91dUnL3VSN.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/32575.html', 21, '两年前还意图颠覆市场的电影票务电商，如今承认自己只是一个“服务者”'),
(155, 'http://img.qdaily.com/article/article_show/20161019174434jqU9Ek5bQGv1eC0Z.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33498.html', 21, '腾讯有了自己的“指数”，主要是为了卖广告'),
(156, 'http://img.qdaily.com/article/article_show/20161019162608YthlaoKDsEQNzb7n.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33494.html', 21, 'Google 现在想告诉你，什么时候买机票最便宜'),
(157, 'http://img.qdaily.com/article/article_show/20161019190047LbNSGvDsK8yaghU2.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33503.html', 21, '星巴克扩张，新上任中国CEO说未来内地每年开店500家'),
(158, 'http://img.qdaily.com/article/article_show/201610191537088SXihKVpIuOe6wdl.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33490.html', 21, '支付宝和微信，现在都把支付补贴做成了“打怪升级”'),
(159, 'http://img.qdaily.com/article/article_show/20161019142030ksxFmz6Coprn7Jhc.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33483.html', 21, '苹果下周要发 Mac 电脑，充电接口要换了？'),
(160, 'http://img.qdaily.com/article/article_show/20161019135010mF9QrlCHypznG0Nd.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33480.html', 21, '下次你在都乐香蕉菠萝上看到迪士尼的卡通人，可别惊讶啊'),
(161, 'http://img.qdaily.com/article/article_show/20161019113639jERGHwAVd87KbIso.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33473.html', 21, '为了推视频业务，亚马逊要在欧洲做宽带生意了'),
(162, 'http://img.qdaily.com/article/article_show/20161019080510k8QuOKDRieqndANH.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33468.html', 21, '大公司头条：苹果即将发布新 Mac，亚马逊要做宽带生意'),
(163, 'http://img.qdaily.com/article/article_show/20161019002211QuiH4LosAhFd12zJ.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33458.html', 21, 'Google 出了个键盘应用，给 VR 用的'),
(164, 'http://img.qdaily.com/article/article_show/20161018222819LfptrGXwcQRS2dyB.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33457.html', 21, '我们列出了关于少儿版《白蛇传》的 49 个疑问，制片人高翔都回答了'),
(165, 'http://img.qdaily.com/article/article_show/20161018150547WqjUEsYAc4CHt56a.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33439.html', 21, '裁员又转型，苹果放弃了生产汽车的计划'),
(166, 'http://img.qdaily.com/article/article_show/20161018111140UwcxTH9L3jrOYmMK.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33422.html', 21, '苹果 VS 微软：谁来定义电脑？一场持久的有关技术话语权的争夺战｜广告大战③'),
(167, 'http://img.qdaily.com/article/article_show/20161018131627Et17oYLvlmMi0jRd.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33434.html', 21, '为了买一个游戏公司，腾讯拉了四十亿美元投资'),
(168, 'http://img.qdaily.com/article/article_show/20161018104026SEyebU8pGhaTBYVm.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33423.html', 21, '重新设计动态调价的那位教授，现在离开了 Uber'),
(169, 'http://img.qdaily.com/article/article_show/20161018093149oLgJlvb81qRZznUy.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33419.html', 21, '王健林想每年拿1.5亿美元补贴好莱坞，还是为了卖房吧？'),
(170, 'http://img.qdaily.com/article/article_show/20161017214359dVe7QUGgcNJEL5oj.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33406.html', 21, '上线半年，共享自行车拿钱速度超过了打车大战，这会怎么改变你的出行？'),
(171, 'http://img.qdaily.com/article/article_show/20161018080410aBYJnOv6ZuK9tUEA.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33414.html', 21, '大公司头条：苹果汽车项目人员缩减，万达挖到迪士尼高管'),
(172, 'http://img.qdaily.com/article/article_show/201610181333388P9r5hSNBnUxZGAf.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33396.html', 21, '又一个大公司做租房贷款，这些公司提供的服务划算么？'),
(173, 'http://img.qdaily.com/article/article_show/20161017180741XZFlK34cB50iQeqO.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33399.html', 21, '奇异博士来到中国，这是漫威电影里的第一位魔法师'),
(174, 'http://img.qdaily.com/article/article_show/20161017152104jez6JRXYCv1LOm8q.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33391.html', 21, '小米也开始做手机处理器了，但这短期内还出不了什么效果'),
(175, 'http://img.qdaily.com/article/article_show/20161017153054mgHnruTUtaGA4Bzw.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33392.html', 21, '乒超没人冠名不要紧，阿里体育还是拿来做内容了'),
(176, 'http://img.qdaily.com/article/article_show/20161017131222YRcNXTLFpf843uAe.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33383.html', 21, '让机器人学人做事不太容易，Facebook 智能助手遇到困境'),
(177, 'http://img.qdaily.com/article/article_show/20161017132504jQk4aECOMNK8b0oH.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33386.html', 21, '为了吸引年轻人，麦当劳组建了两百人的全球数字团队'),
(178, 'http://img.qdaily.com/article/article_show/2016101713210496tapDeIv8PYTofA.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33385.html', 21, '因为苹果要用新屏幕，JDI 亏损还在砸钱做 OLED'),
(179, 'http://img.qdaily.com/article/article_show/20161017074017nOwCNb0cFfrxEsgX.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33371.html', 21, '大公司头条：全球禁止温室气体 HFC，北京网约车新规结束意见征求'),
(180, 'http://img.qdaily.com/article/article_show/20161006090309uJfAXlI6ULiE59Nk.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/32945.html', 21, '温哥华想让自己变得更强大，它想到的盟友是西雅图'),
(181, 'http://img.qdaily.com/article/article_show/201610161842311AltN9cBfYnZCVaO.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33366.html', 21, '库克又谈到了增强现实，说它比 VR 重要'),
(182, 'http://img.qdaily.com/article/article_show/201610140840291pfk4JYG2XSE3yIr.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33307.html', 21, '亚马逊又又又推出音乐服务，已经是10年里的第三次了'),
(183, 'http://img.qdaily.com/article/article_show/20161015153422FhixnVyca6EepRQv.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33354.html', 21, '优衣库过去一年增速放缓，姐妹品牌 GU 表现不错'),
(184, 'http://img.qdaily.com/article/article_show/201610150704528mJkGayQ7wx9nDTz.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33347.html', 21, '当苹果供应商不容易，人都快被它挖光了'),
(185, 'http://img.qdaily.com/article/article_show/20161014233831c6nNepLi9b1saPlD.png?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33343.html', 21, '才发布手机没多久的 Google，又要自己做手表了'),
(186, 'http://img.qdaily.com/article/article_show/20161010151210Xf5oIL0YePHqAMpr.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33129.html', 21, '支付宝做了一年多韩国市场，抓到的都是中国游客'),
(187, 'http://img.qdaily.com/article/article_show/20161014113817EieGdnxbO74o3R2S.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33312.html', 21, '切尔西与耐克签下 15 年长约，双方终于都满意了'),
(188, 'http://img.qdaily.com/article/article_show/20161013222655UZYe5uQWxjINr9sX.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33297.html', 21, '印度没做成功，扎克伯格打算把免费联网计划带进美国'),
(189, 'http://img.qdaily.com/article/article_show/20161014101112R2j9fXHrQTpcwOWP.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33306.html', 21, '有份报告说，Apple Watch 是目前最准的手腕设备'),
(190, 'http://img.qdaily.com/article/article_show/201610140654194bUjI8FOmxf7wero.jpeg?imageMogr2/auto-orien', 'http://www.qdaily.com/articles/33304.html', 21, '大公司头条：腾讯投资摩拜单车，阿里巴巴交易额突破三万亿元'),
(191, 'http://img.qdaily.com/article/article_show/20161011140052aAyQuPZ2lqvBKHiL.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33174.html', 21, '苹果回应部分 App 被下架的事，但开发者觉得被冤枉了'),
(192, 'http://img.qdaily.com/article/article_show/20161011085551GwT8FIua9ghd15bQ.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33158.html', 21, '人工智能说话会有不同的口音吗？大公司对此不太积极'),
(193, 'http://img.qdaily.com/article/article_show/20161013231846aV5KoFdzyhSCOqpc.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33300.html', 21, '为什么美国购物季来临，亚马逊仓库却不接第三方卖家货了？'),
(194, 'http://img.qdaily.com/article/article_show/20161013160756qFBQUtkIwAGLWjz9.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33281.html', 21, '赵薇卖了手头一小半的阿里影业股票，是后者遇到问题了吗？'),
(195, 'http://img.qdaily.com/article/article_show/20161013172246Jyot2qfKbr4QXukc.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33282.html', 21, '阿迪又签了 8 个 NBA 新秀，当真是和耐克怼上了吗？'),
(196, 'http://img.qdaily.com/article/article_show/201610131210444KVOMf7igoeR8XAP.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33265.html', 21, '星巴克推出的第一款酒精饮料，当然还是会带上咖啡'),
(197, 'http://img.qdaily.com/article/article_show/20161011181748PAlrfkqUx1MdLsz5.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33197.html', 21, 'Google 有上百辆无人驾驶新测试车准备上路了'),
(198, 'http://img.qdaily.com/article/article_show/20161012141424yvINfgEWVxZdtLM0.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33222.html', 21, '汉堡王 VS 麦当劳：都是做汉堡的，何苦这么“为难”对方？|广告大战②'),
(199, 'http://img.qdaily.com/article/article_show/20161012134222R1Wz65LM9ewsbAjc.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33223.html', 21, '迪士尼又要拍真人版《阿拉丁》，可能是部动作冒险片'),
(200, 'http://img.qdaily.com/article/article_show/201610121220478ixtqsAEL4zuZRTN.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33211.html', 21, '「这世界」全球多地出现“小丑恐慌”之后，麦当劳叔叔都不敢露面了'),
(201, 'http://img.qdaily.com/article/article_show/20161012120608lMOVXQPdjiumJkYU.jpg?imageMogr2/auto-orient', 'http://www.qdaily.com/articles/33213.html', 21, '三星苹果专利案打到了高法，美国科技公司为什么支持三星？');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `haoqixin`
--
ALTER TABLE `haoqixin`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `haoqixin`
--
ALTER TABLE `haoqixin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
