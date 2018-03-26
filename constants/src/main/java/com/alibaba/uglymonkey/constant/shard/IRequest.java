package com.alibaba.uglymonkey.constant.shard;

/**
 * Created by jack on 2018/3/21.
 */
public interface IRequest {
    RequestHeader getRequest();

    void setRequestHeader(RequestHeader requestHeader);
}
