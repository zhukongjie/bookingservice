package com.alibaba.uglymonkey.constant.shard;

import java.security.Timestamp;

/**
 * Created by jack on 2018/3/21.
 */
public interface IResponse {

    ResponseStatusType getResponStatus();

    void setResponse(ResponseStatusType responseStatusType);

}
