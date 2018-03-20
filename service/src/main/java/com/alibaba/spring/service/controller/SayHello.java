package com.alibaba.spring.service.controller;

import com.alibaba.spring.service.contract.HellowordBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jack on 2018/3/17.
 */
@RestController
public class SayHello {

    private static final Logger LOGGER = LoggerFactory.getLogger(SayHello.class);

    @RequestMapping("/helloworld")
    public String helloworld() {
        LOGGER.trace("logback的--trace日志--输出了");
        LOGGER.debug("logback的--debug日志--输出了");
        LOGGER.info("logback的--info日志--输出了");
        LOGGER.warn("logback的--warn日志--输出了");
        LOGGER.error("logback的--error日志--输出了");
        return "helloworld";
    }

    @RequestMapping(value = "/getWorld", method = RequestMethod.POST)
    public HellowordBean getHelloWorld(@ModelAttribute HellowordBean hellowordBean) {

        return hellowordBean;

    }

}
