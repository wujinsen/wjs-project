package com.moli.datasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moli.datasource.mapper.OdsSsBuriedPointBookDataMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OdsSsBuriedPointBookDataServiceImpl implements  OdsSsBuriedPointBookDataService{

    @Resource
    private OdsSsBuriedPointBookDataMapper odsSsBuriedPointBookDataMapper;

    @DS("slave_1")
    public Integer bbb() {
        Integer count = odsSsBuriedPointBookDataMapper.selectCount(new LambdaQueryWrapper<>());
        return count;
    }

}
