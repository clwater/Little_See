package com.clwater.littesee.Utils.Analysis;

import com.clwater.littesee.MainActivity;
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
}
