package com.clwater.littesee.Utils.DBHelper;

/**
 * Created by gengzhibo on 16/10/17.
 */

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class ZhiHuDaoOrm {
    private Context context;
    private Dao<ZhiHu,Integer> zhihuDao;
    private DatabaseHelper helper;
    public ZhiHuDaoOrm(Context context){
        this.context=context;
        helper=DatabaseHelper.getHelper(context);
        try {
            zhihuDao =  helper.getDao(ZhiHu.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //添加、修改数据
    public void add(ZhiHu zhihu){
        try {
            zhihuDao.createOrUpdate(zhihu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询所有
    public List<ZhiHu> select(){
        try {
            return zhihuDao.queryBuilder().orderBy("id" , false).query();
            //return zhihuDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //删除某一条
    public void delete(ZhiHu ZhiHu){
        try {
            zhihuDao.delete(ZhiHu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询一条数据
    public ZhiHu seleteZhiHu(int id){
        try {
            return zhihuDao.queryBuilder()
                    .where()
                    .eq("id", id)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZhiHu seleteZhiHu(String title){
        try {
            return zhihuDao.queryBuilder()
                    .where()
                    .eq("title", title)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}