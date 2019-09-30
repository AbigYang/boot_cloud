package com.yang.filter_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.yang.filter_interceptor.common.filter")
public class FilterInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorApplication.class, args);
    }

}
