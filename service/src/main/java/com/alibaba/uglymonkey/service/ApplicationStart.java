package com.alibaba.uglymonkey.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jack on 2018/3/17.
 */
@SpringBootApplication
public class ApplicationStart {

    public static void main(String[] args) throws URISyntaxException, IOException {
        SpringApplication.run(ApplicationStart.class, args);

        System.setProperty("java.awt.headless", "false");
        Desktop.getDesktop().browse(new URI("http://localhost:8080/getworld"));
    }
}
