package cn.wjs.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 测试控制器
 * PS:@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaTemplate template;

    @GetMapping(path = "/send/user")
    public void sendFoo() {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        user.setStartTime(System.currentTimeMillis());
        log.info("已发送数据: {}", JSON.toJSONString(user));
        this.template.send("topic-user", user);
    }

}
