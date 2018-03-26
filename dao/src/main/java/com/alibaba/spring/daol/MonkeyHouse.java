package com.alibaba.spring.daol;

import java.util.Calendar;

/**
 * Created by jack on 2018/3/19.
 */
public class MonkeyHouse {
    private int id;
    private String monkeyUid;
    private int parentId;
    private Calendar dataChange_CreateTime;
    private Calendar dataChange_LastTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonkeyUid() {
        return monkeyUid;
    }

    public void setMonkeyUid(String monkeyUid) {
        this.monkeyUid = monkeyUid;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

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

    @Override
    public String toString() {
        return this.getMonkeyUid()+","+this.getParentId();
    }
}
