package com.clwater.littesee.Utils.DBHelper;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gengzhibo on 16/10/17.
 */

@DatabaseTable(tableName = "user")

public class User1 implements Parcelable {
    @DatabaseField(id=true)
    //id为主键，则为true
    private String userId;
    @DatabaseField
    private String name;
    @DatabaseField
    private int age;

    public User1() {
    }

    public User1(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    protected User1(Parcel in) {
        userId = in.readString();
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<User1> CREATOR = new Creator<User1>() {
        @Override
        public User1 createFromParcel(Parcel in) {
            return new User1(in);
        }

        @Override
        public User1[] newArray(int size) {
            return new User1[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        dest.writeString(name);
        dest.writeInt(age);
    }
    @Override
    public String toString() {
        return "User1{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}