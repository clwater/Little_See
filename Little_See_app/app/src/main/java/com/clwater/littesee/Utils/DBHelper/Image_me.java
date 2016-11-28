package com.clwater.littesee.Utils.DBHelper;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gengzhibo on 16/11/28.
 */

@DatabaseTable(tableName = "image")

public class Image_me  implements Parcelable{
    @DatabaseField(generatedId = true)
    private int id;

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @DatabaseField
    private String href;
    @DatabaseField
    private String statu;

    public Image_me(){}
    public Image_me(int id , String href ,String statu){
        this.id = id;
        this.href = href;
        this.statu = statu;
    }

    protected Image_me(Parcel in) {
        id = in.readInt();
        href = in.readString();
        statu = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(href);
        dest.writeString(statu);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Image_me> CREATOR = new Creator<Image_me>() {
        @Override
        public Image_me createFromParcel(Parcel in) {
            return new Image_me(in);
        }

        @Override
        public Image_me[] newArray(int size) {
            return new Image_me[size];
        }
    };
}



