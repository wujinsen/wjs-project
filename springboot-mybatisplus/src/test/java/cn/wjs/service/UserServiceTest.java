package cn.wjs.service;


import cn.wjs.mapper.UserMapper;
import cn.wjs.model.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Wrapper;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
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

    @Test
    public void updateTest() {
        UpdateWrapper<User> wrapper= new UpdateWrapper();
        User user = new User();
        user.setOrderNum(1);
        userMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getName,"aaa"));
    }

}
