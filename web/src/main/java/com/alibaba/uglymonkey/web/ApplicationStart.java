package com.alibaba.uglymonkey.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jack on 2018/3/21.
 */
@SpringBootApplication()
public class ApplicationStart {

    public static void main(String[] args) throws URISyntaxException, IOException {
        SpringApplication.run(ApplicationStart.class, args);
        System.setProperty("java.awt.headless", "false");
    }
}
