package cn.wjs.controller;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private RedissonClient redisson;


}
