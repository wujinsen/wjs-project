package com.moli.kafka.clickhouse.listener;


import com.alibaba.fastjson.JSON;
import com.moli.kafka.clickhouse.domain.entity.BuriedPointBookData;
import com.moli.kafka.clickhouse.domain.entity.Order;
import com.moli.kafka.clickhouse.domain.vo.BuriedPointBookInfoVo;
import com.moli.kafka.clickhouse.domain.vo.UserNewActionTopicMessageVo;
import com.moli.kafka.clickhouse.mapper.BuriedPointBookDataMapper;
import com.moli.kafka.clickhouse.mapper.OrderMapper;
import com.moli.kafka.clickhouse.service.BuriedPointBookDataService;
import com.moli.kafka.clickhouse.utils.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class KafkaConsumerListener {

    @Resource
    private BuriedPointBookDataMapper buriedPointBookDataMapper;

    @Resource
    private BuriedPointBookDataService buriedPointBookDataService;

    @Resource
    private OrderMapper orderMapper;

    @KafkaListener(id = "audit", topics = "spa_user_pointdata_beta_topic")
    public void listenUserStr(String str) {
        UserNewActionTopicMessageVo userNewActionTopicMessageVo = JSON.parseObject(str, UserNewActionTopicMessageVo.class);
        log.info("kafka消费数据====================: {}", str);
        BuriedPointBookInfoVo buriedPointBookInfoVo = userNewActionTopicMessageVo.getData();
        BuriedPointBookData buriedPointBookData = new BuriedPointBookData();
        BeanUtils.copyProperties(userNewActionTopicMessageVo, buriedPointBookData);
        BeanUtils.copyProperties(buriedPointBookInfoVo, buriedPointBookData);
        log.info("kafka userNewActionTopicMessageVo ====================: {}", userNewActionTopicMessageVo);
        log.info("kafka buriedPointBookInfoVo ====================: {}", buriedPointBookInfoVo);
        log.info("kafka buriedPointBookData ====================: {}", buriedPointBookData);
        List<BuriedPointBookData> list = new ArrayList<>();
        buildParameter(list, buriedPointBookInfoVo, userNewActionTopicMessageVo);

        Boolean b = buriedPointBookDataService.saveBatch(list);
        log.info("num ===== : {}", b);

    }

//    @KafkaListener(id = "userGroup", topics = "topic-user")
//    public void listenUser(User user) {
//        log.info("消费数据: {}", user);
//    }

//    @KafkaListener(id = "userGroup", topics = "aaa_topic")
//    public void listenUser(String str) {
//        log.info("消费数据: {}", str);
//    }

    private void buildParameter(List<BuriedPointBookData> list, BuriedPointBookInfoVo buriedPointBookInfoVo, UserNewActionTopicMessageVo userNewActionTopicMessageVo) {

        List<String> strArr = Arrays.asList(buriedPointBookInfoVo.getBookId().split(","));

        BuriedPointBookData buriedPointBookData = new BuriedPointBookData();
        buriedPointBookData.setId(IdGenerator.getId());
        buriedPointBookData.setUserId(Integer.valueOf(userNewActionTopicMessageVo.getUserId()));
        buriedPointBookData.setChannelName(userNewActionTopicMessageVo.getChannelName());
        buriedPointBookData.setIp(userNewActionTopicMessageVo.getUserIp());
        buriedPointBookData.setDeviceId(userNewActionTopicMessageVo.getDeviceId());
        buriedPointBookData.setApplicationId(userNewActionTopicMessageVo.getAppId());
        buriedPointBookData.setOsVersion(userNewActionTopicMessageVo.getOsversion());
        buriedPointBookData.setBrand(userNewActionTopicMessageVo.getBrand());
        buriedPointBookData.setDeviceModel(userNewActionTopicMessageVo.getModel());
        buriedPointBookData.setNetworkType(userNewActionTopicMessageVo.getIsWifi());
        buriedPointBookData.setVersionCode(userNewActionTopicMessageVo.getVersionCode());
        buriedPointBookData.setVerisonName(userNewActionTopicMessageVo.getVersionName());
        buriedPointBookData.setProductType(userNewActionTopicMessageVo.getProductType());
        buriedPointBookData.setCurrentPage(userNewActionTopicMessageVo.getCurrentPage());
        buriedPointBookData.setCurrentAction(userNewActionTopicMessageVo.getCurrentAction());
        for (String bookId : strArr) {
            buriedPointBookData.setBookId(Integer.valueOf(bookId));
            list.add(buriedPointBookData);
        }

    }

}
