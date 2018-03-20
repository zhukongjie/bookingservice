package com.alibaba.spring.service.contract;

/**
 * Created by jack on 2018/3/20.
 */
public class HellowordBean {

    private String hello;

    private Integer beanCount;


    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Integer getBeanCount() {
        return beanCount;
    }

    public void setBeanCount(Integer beanCount) {
        this.beanCount = beanCount;
    }
}
