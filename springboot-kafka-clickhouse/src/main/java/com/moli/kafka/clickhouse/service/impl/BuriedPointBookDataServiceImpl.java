package com.moli.kafka.clickhouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moli.kafka.clickhouse.domain.entity.BuriedPointBookData;
import com.moli.kafka.clickhouse.mapper.BuriedPointBookDataMapper;
import com.moli.kafka.clickhouse.service.BuriedPointBookDataService;
import org.springframework.stereotype.Service;

@Service
public class BuriedPointBookDataServiceImpl extends ServiceImpl<BuriedPointBookDataMapper, BuriedPointBookData> implements BuriedPointBookDataService {
}
