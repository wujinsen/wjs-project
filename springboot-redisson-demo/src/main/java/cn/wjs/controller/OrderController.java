package cn.wjs.controller;


import cn.wjs.domain.OrderM;
import cn.wjs.service.OrderServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class OrderController {

    @Resource
    private OrderServer orderServer;

    @PostMapping("/createOrder")
    public boolean createOrder(@RequestBody OrderM orderM) {
        return orderServer.createOrder(orderM.getUserId(), orderM.getSkuId());
    }

}
