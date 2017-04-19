package com.clwater.littlesee.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by yszsyf on 17/3/18.
 */

@Table("Image")
public class BeanImage {
    public BeanImage(String address, String text, String indexclass) {
        this.text = text;
        this.address = address;
        this.indexclass = indexclass;
    }

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;


    @Column("text")
    private String text;


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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
