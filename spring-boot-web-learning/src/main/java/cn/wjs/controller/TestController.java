package cn.wjs.controller;

import cn.wjs.Hello;
import cn.wjs.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Hello hello;

    @RequestMapping("/aaa")
    public void aaa(){
        System.out.println("aaaa");
        System.out.println(hello.getMsg());
    }

}
