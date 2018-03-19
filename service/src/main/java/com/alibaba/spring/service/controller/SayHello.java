package com.alibaba.spring.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jack on 2018/3/17.
 */
@RestController
public class SayHello {

    private static final Logger LOGGER = LoggerFactory.getLogger(SayHello.class);

    @GetMapping("/helloworld")
    public String helloworld() {
        LOGGER.trace("logback的--trace日志--输出了");
        LOGGER.debug("logback的--debug日志--输出了");
        LOGGER.info("logback的--info日志--输出了");
        LOGGER.warn("logback的--warn日志--输出了");
        LOGGER.error("logback的--error日志--输出了");
        return "helloworld";
    }

}
