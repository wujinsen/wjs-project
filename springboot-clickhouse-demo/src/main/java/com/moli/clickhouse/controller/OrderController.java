package com.moli.clickhouse.controller;


import com.moli.clickhouse.mapper.OrderMapper;
import com.moli.clickhouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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

//    @GetMapping("/detail/{id}")
//    public List<Order> getOderBySkuId(
//            @PathVariable(name = "id", required = true) Integer id
//    ) {
//        return orderService.getOrderById(id);
//    }
}
