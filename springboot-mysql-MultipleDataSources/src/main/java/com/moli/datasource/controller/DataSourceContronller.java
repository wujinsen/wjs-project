package com.moli.datasource.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moli.datasource.mapper.UserMapper;
import com.moli.datasource.service.OdsSsBuriedPointBookDataService;
import com.moli.datasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/datasource")
@Slf4j
public class DataSourceContronller {

    @Resource
    private UserService userService;

    @Resource
    private OdsSsBuriedPointBookDataService odsSsBuriedPointBookDataService;

    @GetMapping("/aaa")
    public void aaa() {
        log.info("result: {}", userService.aaa());
        log.info("result Two aaa: {}", userService.bbb());
    }

}
