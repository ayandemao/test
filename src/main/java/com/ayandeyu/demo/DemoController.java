package com.ayandeyu.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DemoController {

    @GetMapping("/alive")
    public String test() {
        return "张小言是小乖乖~~~~~~~";
    }

}
