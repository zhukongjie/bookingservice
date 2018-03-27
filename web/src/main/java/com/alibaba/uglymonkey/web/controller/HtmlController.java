package com.alibaba.uglymonkey.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jack on 2018/3/27.
 */
@Controller
public class HtmlController {

    @GetMapping("/html")
    public String html() {
        return "/index.html";
    }


}
