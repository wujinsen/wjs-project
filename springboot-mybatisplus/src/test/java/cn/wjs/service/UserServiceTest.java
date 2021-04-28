package cn.wjs.service;


import cn.wjs.mapper.UserMapper;
import cn.wjs.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Wrapper;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class UserServiceTest {



    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;
    @Test
    public void userServiceTest() {
//        User user = userService.selectByPrimaryKey(1);
//        log.info("user: {}", user);

        log.info("result: {} ", userMapper.selectById(1));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        log.info("result: {} ", userMapper.selectOne(wrapper));
    }

}
