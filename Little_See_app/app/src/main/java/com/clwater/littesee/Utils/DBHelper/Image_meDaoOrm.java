package com.clwater.littesee.Utils.DBHelper;

/**
 * Created by gengzhibo on 16/10/17.
 */

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class Image_meDaoOrm {
    private Context context;
    private Dao<Image_me,Integer> image_meDao;
    private DatabaseHelper helper;
    public Image_meDaoOrm(Context context){
        this.context=context;
        helper=DatabaseHelper.getHelper(context);
        try {
            image_meDao =  helper.getDao(Image_me.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //添加、修改数据
    public void add(Image_me image_me){
        try {
            image_meDao.createOrUpdate(image_me);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询所有
    public List<Image_me> select(){
        try {
            return image_meDao.queryBuilder().orderBy("id" , false).query();
            //return image_meDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //删除某一条
    public void delete(Image_me Image_me){
        try {
            image_meDao.delete(Image_me);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询一条数据
    public Image_me seleteImage_me(int id){
        try {
            return image_meDao.queryBuilder()
                    .where()
                    .eq("id", id)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Image_me seleteImage_me(String title){
        try {
            return image_meDao.queryBuilder()
                    .where()
                    .eq("href", title)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}