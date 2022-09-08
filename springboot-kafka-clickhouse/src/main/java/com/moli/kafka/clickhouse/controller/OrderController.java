package com.moli.kafka.clickhouse.controller;


import com.moli.kafka.clickhouse.domain.entity.Order;
import com.moli.kafka.clickhouse.mapper.OrderMapper;
import com.sun.xml.internal.rngom.digested.DTextPattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linchengdong
 * @created 2021-01-13 9:41
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @GetMapping("/test")
    public Object getAmountBySkuId() {
        return orderMapper.selectById(1);
    }

    @GetMapping("/insert")
    public Boolean insert() {

        Order order = new Order();
        order.setId(6);
        order.setTotalAmount(new BigDecimal(6));
        order.setSkuId("6");
        order.setCreateTime(new Date());
        orderMapper.insert(order);
        return Boolean.TRUE;
    }
}
