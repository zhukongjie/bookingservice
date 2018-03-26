package com.alibaba.uglymonkey.web.model;

import com.alibaba.uglymonkey.constant.shard.RequestHeader;

/**
 * Created by jack on 2018/3/21.
 */
public class UserRequestType extends RequestHeader {

    private String uname;
    private String uid;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return uname + uid;
    }
}
