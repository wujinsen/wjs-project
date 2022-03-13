package cn.wjs;


import cn.wjs.domain.OrderM;
import cn.wjs.mapper.OrderMapper;
import cn.wjs.util.GenerateRandom;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertTest(){
        OrderM order = new OrderM();
        order.setId(Long.valueOf(GenerateRandom.number(6)));
        order.setUserId(1l);
        order.setSkuId(1l);
        order.setOrderNo("123456");
        order.setCreateTime(new Date());
        orderMapper.insert(order);
    }

}
