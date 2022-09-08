package com.moli.kafka.clickhouse.listener;


import com.alibaba.fastjson.JSON;
import com.moli.kafka.clickhouse.domain.entity.BuriedPointBookData;
import com.moli.kafka.clickhouse.domain.entity.Order;
import com.moli.kafka.clickhouse.domain.vo.BuriedPointBookInfoVo;
import com.moli.kafka.clickhouse.domain.vo.UserNewActionTopicMessageVo;
import com.moli.kafka.clickhouse.mapper.BuriedPointBookDataMapper;
import com.moli.kafka.clickhouse.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Component
@Slf4j
public class KafkaConsumerListener {

    @Resource
    private BuriedPointBookDataMapper buriedPointBookDataMapper;

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
        buriedPointBookData.setIp(userNewActionTopicMessageVo.getUserIp());
        log.info("kafka userNewActionTopicMessageVo ====================: {}", userNewActionTopicMessageVo);
        log.info("kafka buriedPointBookInfoVo ====================: {}", buriedPointBookInfoVo);
        log.info("kafka buriedPointBookData ====================: {}", buriedPointBookData);
        int num = buriedPointBookDataMapper.insert(buriedPointBookData);
        log.info("num ===== : {}", num);

    }

//    @KafkaListener(id = "userGroup", topics = "topic-user")
//    public void listenUser(User user) {
//        log.info("消费数据: {}", user);
//    }

//    @KafkaListener(id = "userGroup", topics = "aaa_topic")
//    public void listenUser(String str) {
//        log.info("消费数据: {}", str);
//    }

    private void buildParameter(BuriedPointBookData buriedPointBookData, BuriedPointBookInfoVo buriedPointBookInfoVo, UserNewActionTopicMessageVo userNewActionTopicMessageVo) {

    }

}
