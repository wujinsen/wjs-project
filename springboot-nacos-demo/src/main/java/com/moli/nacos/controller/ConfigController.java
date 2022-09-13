package com.moli.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${aaa}", autoRefreshed = true)
    private String aaa;

    @GetMapping(value = "/get")
    public String get() {
        return aaa;
    }

}
