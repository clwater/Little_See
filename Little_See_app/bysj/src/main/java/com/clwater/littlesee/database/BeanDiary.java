package com.clwater.littlesee.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by yszsyf on 17/3/18.
 */

@Table("Diary")
public class BeanDiary {
    public BeanDiary(String title, String image, String address, String indexclass) {
        this.title = title;
        this.image = image;
        this.address = address;
        this.indexclass = indexclass;
    }

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;


    @Column("title")
    private String title;

    @Column("image")
    private String image;

    @Column("address")
    private String address;

    @Column("indexclass")
    private String indexclass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndexclass() {
        return indexclass;
    }

    public void setIndexclass(String indexclass) {
        this.indexclass = indexclass;
    }
}
