package cn.wjs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/aaa")
    public void aaa(){
        System.out.println("aaaa");
    }

}
