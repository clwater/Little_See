package com.clwater.littesee.Utils.DBHelper;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import com.j256.ormlite.dao.Dao;

/**
 * Created by yszsyf on 16/10/15.
 */

public class PackageinfoDao {

    private Dao<PackageInfo, Integer> themeDao;
    private DBHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public PackageinfoDao(Context context) {
        try {
            dbHelper = DBHelper.getHelper(context);
            themeDao = dbHelper.getDao(PackageInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(PackageInfo theme) {
        try {
            themeDao.create(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(PackageInfo theme) {
        try {
            themeDao.delete(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(PackageInfo theme) {
        try {
            themeDao.update(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public PackageInfo queryForId(int id) {
        PackageInfo theme = null;
        try {
            theme = themeDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theme;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<PackageInfo> queryForAll() {
        List<PackageInfo> themes = new ArrayList<PackageInfo>();
        try {
            themes = themeDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themes;
    }

}