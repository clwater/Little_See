package com.clwater.littesee.Utils.DBHelper;

/**
 * Created by gengzhibo on 16/10/17.
 */

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class HaoQiXinDaoOrm {
    private Context context;
    private Dao<HaoQiXin,Integer> haoqixinDao;
    private DatabaseHelper helper;
    public HaoQiXinDaoOrm(Context context){
        this.context=context;
        helper=DatabaseHelper.getHelper(context);
        try {
            haoqixinDao =  helper.getDao(HaoQiXin.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //添加、修改数据
    public void add(HaoQiXin haoQiXin){
        try {
            haoqixinDao.createOrUpdate(haoQiXin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询所有
    public List<HaoQiXin> select(){
        try {
            return haoqixinDao.queryBuilder().orderBy("id" , false).query();
            //return haoqixinDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //删除某一条
    public void delete(HaoQiXin haoQiXin){
        try {
            haoqixinDao.delete(haoQiXin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询一条数据
    public HaoQiXin seleteHaoQinXin(int id){
        try {
            return haoqixinDao.queryBuilder()
                    .where()
                    .eq("id", id)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HaoQiXin seleteHaoQinXin(String title){
        try {
            return haoqixinDao.queryBuilder()
                    .where()
                    .eq("title", title)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}