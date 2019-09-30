package com.yang.filter_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author rycoyang
 * @Date 2019/9/30 15:36
 **/
@RestController("/yes")
public class YesController {

    @GetMapping("/yepp")
    public String getYep() {
        System.out.println("/yes/yep start ...");
        return "/yes/yepp";
    }
}
