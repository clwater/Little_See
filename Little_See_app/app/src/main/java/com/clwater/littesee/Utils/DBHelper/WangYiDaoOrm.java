package com.clwater.littesee.Utils.DBHelper;

/**
 * Created by gengzhibo on 16/10/17.
 */

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class WangYiDaoOrm {
    private Context context;
    private Dao<WangYi,Integer> wangyiDao;
    private DatabaseHelper helper;
    public WangYiDaoOrm(Context context){
        this.context=context;
        helper=DatabaseHelper.getHelper(context);
        try {
            wangyiDao =  helper.getDao(WangYi.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //添加、修改数据
    public void add(WangYi wangYi){
        try {
            wangyiDao.createOrUpdate(wangYi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询所有
    public List<WangYi> select(){
        try {
            return wangyiDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //删除某一条
    public void delete(WangYi wangYi){
        try {
            wangyiDao.delete(wangYi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询一条数据
    public WangYi seleteWangYi(int id){
        try {
            return wangyiDao.queryBuilder()
                    .where()
                    .eq("id", id)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}