package com.alibaba.spring.daol;

import java.util.Calendar;

/**
 * Created by jack on 2018/3/26.
 */
public class User {

    long id;
    String uid;
    String uName;
    Calendar dataChange_CreateTime;
    Calendar dataChange_LastTime;


    public Calendar getDataChange_CreateTime() {
        return dataChange_CreateTime;
    }

    public void setDataChange_CreateTime(Calendar dataChange_CreateTime) {
        this.dataChange_CreateTime = dataChange_CreateTime;
    }

    public Calendar getDataChange_LastTime() {
        return dataChange_LastTime;
    }

    public void setDataChange_LastTime(Calendar dataChange_LastTime) {
        this.dataChange_LastTime = dataChange_LastTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}

