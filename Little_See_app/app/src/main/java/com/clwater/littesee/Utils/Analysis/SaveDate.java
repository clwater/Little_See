package com.clwater.littesee.Utils.Analysis;

import com.clwater.littesee.MainActivity;
import com.clwater.littesee.Utils.DBHelper.HaoQiXin;
import com.clwater.littesee.Utils.DBHelper.HaoQiXinDaoOrm;
import com.clwater.littesee.Utils.DBHelper.Image_me;
import com.clwater.littesee.Utils.DBHelper.Image_meDaoOrm;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;

import java.util.List;

/**
 * Created by gengzhibo on 16/11/19.
 */

public class SaveDate {
    public static int zhihuDateSave(List<ZhiHu> zhiHuList){
        ZhiHuDaoOrm zhiHuDaoOrm = new ZhiHuDaoOrm(MainActivity.context);
        int changeDate = 0;

        for (int i = 0 ; i < zhiHuList.size(); i++ ){
            ZhiHu zhihu = zhiHuList.get(i);

            ZhiHu check = zhiHuDaoOrm.seleteZhiHu(zhihu.getTitle());
            if (check == null) {
                changeDate++;
                zhiHuDaoOrm.add(zhihu);
            }
        }
        return changeDate;
    }

    public static int haoqixinDateSave(List<HaoQiXin> haoQiXinList){
        HaoQiXinDaoOrm haoQiXinDaoOrm = new HaoQiXinDaoOrm(MainActivity.context);
        int changeDate = 0;

        for (int i = 0 ; i < haoQiXinList.size(); i++ ){
            HaoQiXin haoQiXin = haoQiXinList.get(i);

            HaoQiXin check = haoQiXinDaoOrm.seleteHaoQinXin(haoQiXin.getTitle());
            if (check == null) {
                changeDate++;
                haoQiXinDaoOrm.add(haoQiXin);
            }
        }
        return changeDate;
    }


    public static int imageDateSave(List<Image_me> imageList){
        Image_meDaoOrm image_meDaoOrm = new Image_meDaoOrm(MainActivity.context);
        int changeDate = 0;

        for (int i = 0 ; i < imageList.size(); i++){
            Image_me image_me = imageList.get(i);
            Image_me check = image_meDaoOrm.seleteImage_me(image_me.getHref());

            if (check == null){
                changeDate++;
                image_meDaoOrm.add(image_me);
            }
        }

        return changeDate;
    }
}
