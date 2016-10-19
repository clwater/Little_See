package com.clwater.littesee.Utils.DBHelper;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gengzhibo on 16/10/17.
 */

@DatabaseTable(tableName = "haoqixin")

public class HaoQiXin implements Parcelable {
    @DatabaseField(generatedId=true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String title_image;

    @DatabaseField
    private String address;

    @DatabaseField
    private int isRead;


    public HaoQiXin() {
    }

    public HaoQiXin(int id, String title, String title_image , String address , int isRead) {
        this.id = id;
        this.title = title;
        this.title_image = title_image;
        this.address = address;
        this.isRead = isRead;
    }

    protected HaoQiXin(Parcel in) {
        id = in.readInt();
        title = in.readString();
        title_image = in.readString();
        address = in.readString();
        isRead = in.readInt();
    }

    public static final Creator<HaoQiXin> CREATOR = new Creator<HaoQiXin>() {
        @Override
        public HaoQiXin createFromParcel(Parcel in) {
            return new HaoQiXin(in);
        }

        @Override
        public HaoQiXin[] newArray(int size) {
            return new HaoQiXin[size];
        }
    };

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

    public String getTitle_image() {
        return title_image;
    }

    public void setTitle_image(String title_image) {
        this.title_image = title_image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(title_image);
        dest.writeString(address);
        dest.writeInt(isRead);

    }

}