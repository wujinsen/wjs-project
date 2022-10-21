package com.moli.hive.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moli.hive.mapper.OdsSsBuriedPointBookDataMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hive")
public class HiveController {

    @Resource
    private OdsSsBuriedPointBookDataMapper odsSsBuriedPointBookDataMapper;

    @RequestMapping("/test")
    public Integer test(){
        Integer count = odsSsBuriedPointBookDataMapper.selectCount(new LambdaQueryWrapper<>());
        System.out.println("count: " + count);
        return count;
    }

}
