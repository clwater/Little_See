package com.clwater.littesee.Utils.DBHelper;

/**
 * Created by gengzhibo on 16/10/17.
 */

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class UserDaoOrm {
    private Context context;
    private Dao<User1,Integer> userDao;
    private DatabaseHelper helper;
    public UserDaoOrm(Context context){
        this.context=context;
        helper=DatabaseHelper.getHelper(context);
        try {
            userDao=  helper.getDao(User1.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //添加、修改数据
    public void add(User1 user1){
        try {
            userDao.createOrUpdate(user1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询所有
    public List<User1> select(){
        try {
            return userDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //删除某一条
    public void delete(User1 user1){
        try {
            userDao.delete(user1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询一条数据
    public User1 seleteUser(String id){
        try {
            return userDao.queryBuilder()
                    .where()
                    .eq("userId", id)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}