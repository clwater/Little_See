-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2016-11-18 08:50:58
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
-- 表的结构 `zhihu`
--

CREATE TABLE `zhihu` (
  `id` int(10) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `title_image` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `dateid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

--
-- 转存表中的数据 `zhihu`
--

INSERT INTO `zhihu` (`id`, `title`, `title_image`, `address`, `dateid`) VALUES
(93, '到了 2020 年，中国会是唯一一个拥有太空站的国家吗？', 'http://pic4.zhimg.com/6ae9c71bcd6e804a2a17a899dfc6561f.jpg', 'http://daily.zhihu.com/story/8989393', 17),
(94, '伊隆 ? 马斯克：我有好几家公司，自己收购自己倒腾钱', 'http://pic4.zhimg.com/b363d5804b497b2b4f55cdae03ade92b.jpg', 'http://daily.zhihu.com/story/8989282', 17),
(95, '吃了好多我才注意到，这红红的是血吗？', 'http://pic3.zhimg.com/bf0174529d906e2cbb0385a2f1621c6e.jpg', 'http://daily.zhihu.com/story/8989303', 17),
(96, '大误 ? 原来我是非洲人', 'http://pic2.zhimg.com/a40aca45adba5cf4ae845dc5243716ed.jpg', 'http://daily.zhihu.com/story/8982498', 17),
(97, '相机越来越智能，想要拍好就得多拼「套路」', 'http://pic1.zhimg.com/136fa1721b94991615345883060da090.jpg', 'http://daily.zhihu.com/story/8988075', 17),
(98, '他们编出「时间无价」这种谎言，都是为了天真的我们', 'http://pic3.zhimg.com/6fb297af3932f68c8c55fbad509e34ce.jpg', 'http://daily.zhihu.com/story/8983320', 17),
(99, '别只盯着「谢谢惠顾」，瓶盖里还有别的学问', 'http://pic2.zhimg.com/6117b74ef70bc2410884f4e18a747359.jpg', 'http://daily.zhihu.com/story/8988073', 17),
(100, '电影里的花式拉牌很酷炫对不对？我来教你', 'http://pic1.zhimg.com/196046379672284ee17ed9c6cb622ec8.jpg', 'http://daily.zhihu.com/story/8918569', 17),
(101, '总是预测错也不丢人，人类的思维机制确实有弱点', 'http://pic1.zhimg.com/110dea0f007283949fe9eaa9287b8c4c.jpg', 'http://daily.zhihu.com/story/8988072', 17),
(102, '开灯睡觉影响记忆力', 'http://pic1.zhimg.com/931b270c7d1778f12e87dce0efdc0c40.jpg', 'http://daily.zhihu.com/story/8987940', 17),
(103, '很多大公司开始操心你的信用情况，这事才刚刚开始', 'http://pic2.zhimg.com/f84edda9a5de6eb99abff8b26958712d.jpg', 'http://daily.zhihu.com/story/8987977', 17),
(104, '读读日报 24 小时热门 TOP 5 ? 满天都是小星星', 'http://pic2.zhimg.com/9b9b2c48ef2bc1a6ad8d3ffcea641139.jpg', 'http://daily.zhihu.com/story/8987960', 17),
(105, '瞎扯 ? 如何正确地吐槽', 'http://pic2.zhimg.com/2097ce3cdd9b51ea46b32c2de0f219e5.jpg', 'http://daily.zhihu.com/story/8987983', 17),
(106, '小事 ? 一人我饮酒醉', 'http://pic1.zhimg.com/fc67a1935801c60dda495757d893e3cc.jpg', 'http://daily.zhihu.com/story/8986512', 17),
(107, '就算是鸡蛋碰石头，也要溅他一身黄', 'http://pic1.zhimg.com/5baeb1becef9ded39d67cf01cdd0001c.jpg', 'http://daily.zhihu.com/story/8986342', 17),
(108, '小语种人才的意义真的是非同凡响啊（敲黑板）', 'http://pic4.zhimg.com/5a301fb14d6efb537a5075ec62293357.jpg', 'http://daily.zhihu.com/story/8986537', 17),
(109, '快递车半路出车祸了，东西全掉沟里了，我该怎么办？', 'http://pic3.zhimg.com/ae8523de3976ca208069da41f79e46f6.jpg', 'http://daily.zhihu.com/story/8986687', 17),
(110, '放心，苹果还是会保修你的 iPhone，就是加了点小条件', 'http://pic4.zhimg.com/f0f95e41939167b533afc6769c34cdeb.jpg', 'http://daily.zhihu.com/story/8986525', 17),
(111, '知乎好问题 ? 如何高效地管理邮件？', 'http://pic2.zhimg.com/f8df07e00f887db7a0adaa1c47add9e9.jpg', 'http://daily.zhihu.com/story/8986664', 17),
(112, '一个人过没什么不好的，但是……也没那么好', 'http://pic1.zhimg.com/3fc5c6cd7559725921d04b0fb2907554.jpg', 'http://daily.zhihu.com/story/8984802', 17),
(113, '分析经济问题就非要用数学公式吗？', 'http://pic2.zhimg.com/7a032e6b943628d6f43d09bd3020dead.jpg', 'http://daily.zhihu.com/story/8986145', 17),
(114, '人工智能界的大牛李飞飞加入谷歌，巨头们正在争抢人才', 'http://pic2.zhimg.com/d1228d80d18cdb3ee4eb128e55b2ede1.jpg', 'http://daily.zhihu.com/story/8986220', 17),
(115, '听到、看到、闻到与「栗子」有关的一切，就两眼放光', 'http://pic3.zhimg.com/3cbdb1c2a3bb2e7ba292246f1b9f3f7a.jpg', 'http://daily.zhihu.com/story/8986052', 17),
(116, '大误 ? 「你谈过几个男朋友？」', 'http://pic4.zhimg.com/22d65791d391845e192ab34e0a951ceb.jpg', 'http://daily.zhihu.com/story/8983067', 17),
(117, '没有高科技的古代，人们是怎样绘制地图的？', 'http://pic4.zhimg.com/bc4bb90d1332f366e79a5577cfce8013.jpg', 'http://daily.zhihu.com/story/8984848', 17),
(118, '「不够酷」的库克，担任苹果 CEO 这五年其实做得挺好', 'http://pic3.zhimg.com/f763158a165211829eb2c735f69a5e3a.jpg', 'http://daily.zhihu.com/story/8982760', 17),
(119, '动物咬人会得病，那人咬动物会怎么样？', 'http://pic2.zhimg.com/a566c04a4d950f89e525e7fc6edcfc5d.jpg', 'http://daily.zhihu.com/story/8984797', 17),
(120, '蹲在专利局门口数人，没准儿能准确预测经济增速', 'http://pic4.zhimg.com/c77edf8da20dd92e0834b2b8412734cb.jpg', 'http://daily.zhihu.com/story/8984178', 17),
(121, '岩浆岩、变质岩、沉积岩吃起来口感有什么差异？', 'http://pic1.zhimg.com/a2282df1980297b7825bf5250b00a3f0.jpg', 'http://daily.zhihu.com/story/8984844', 17),
(122, '乡镇是中国商业的终点，这其中有着一大波机会和挑战', 'http://pic2.zhimg.com/25492628eec7700c012441fc774cb561.jpg', 'http://daily.zhihu.com/story/8983621', 17);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `zhihu`
--
ALTER TABLE `zhihu`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `zhihu`
--
ALTER TABLE `zhihu`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
