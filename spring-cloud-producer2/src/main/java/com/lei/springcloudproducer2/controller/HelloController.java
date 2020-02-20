package com.lei.springcloudproducer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return "hello"+name+",producer2 have send message to you";
    }
}
