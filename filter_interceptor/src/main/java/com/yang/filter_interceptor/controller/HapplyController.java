package com.yang.filter_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author rycoyang
 * @Date 2019/9/30 15:33
 **/
@RestController(value = "/happly")
public class HapplyController {

    @GetMapping("/yep")
    public String getString() {
        System.out.println("/happy/yep start");
        return "yep";
    }

    @GetMapping("/nop")
    public String getNop() {
        System.out.println("/happly/nop start....");
        return "nop";
    }

}
