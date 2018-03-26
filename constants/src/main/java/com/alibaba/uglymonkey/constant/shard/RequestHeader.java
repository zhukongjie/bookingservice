package com.alibaba.uglymonkey.constant.shard;

import java.util.List;

/**
 * Created by jack on 2018/3/21.
 */
public class RequestHeader {

    private String cid;
    private String vid;
    private String version;
    private List<KeyValueDict> extension;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<KeyValueDict> getExtension() {
        return extension;
    }

    public void setExtension(List<KeyValueDict> extension) {
        this.extension = extension;
    }
}
