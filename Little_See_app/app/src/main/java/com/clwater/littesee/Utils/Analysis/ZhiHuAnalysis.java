package com.clwater.littesee.Utils.Analysis;

import android.content.Context;
import android.util.Log;

import com.clwater.littesee.MainActivity;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;

import java.util.List;

/**
 * Created by gengzhibo on 16/10/17.
 */

public class ZhiHuAnalysis {
    public static void Analysis(Context context){
        test();
    }

    private static String testText = "[‘小事 · 爸妈反对，还要不要嫁给他？', 'http://daily.zhihu.com/story/8874639', 'http://pic3.zhimg.com/62f20ec187be95f3e76463d9fddb5056.jpg']\n" +
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

    private static void test() {
        ZhiHuDaoOrm zhiHuDaoOrm = new ZhiHuDaoOrm(MainActivity.context);
//        List<ZhiHu> list = zhiHuDaoOrm.select();
//        for (int i = 0 ; i < list.size() ; i++){
//            ZhiHu z = list.get(i);
//            zhiHuDaoOrm.delete(z);
//        }

        testText = testText.replace("\n" , "");
        testText = testText.replace("[" , "");
        testText = testText.replace("'" , "");
        String[] list = testText.split("]");
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
