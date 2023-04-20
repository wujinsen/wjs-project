package cn.wjs.controller;

import cn.wjs.Hello;
import cn.wjs.HelloProperties;
import cn.wjs.HelloService;
import com.alibaba.fastjson.JSON;
import com.moli.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

//    @Autowired
//    private Hello hello;
////
//    @Autowired
//    private OpenAiService openAiService;
//    @Autowired
//    private HelloService helloService;

    @GetMapping("/aaa")
    public String aaa(){
//        System.out.println("aaaa");
//        System.out.println(hello.getMsg());
     //   System.out.println(openAiService.createCompletion());
        System.out.println("hello world");
        return "success";
    }
    @PostMapping("/bbb")
    public String bbb(@RequestBody User user ){
        System.out.println(user);
        return "success";
    }


}

