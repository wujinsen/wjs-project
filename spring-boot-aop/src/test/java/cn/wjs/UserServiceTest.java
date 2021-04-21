package cn.wjs;


import cn.wjs.model.User;
import cn.wjs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userTest(){
        User user = new User();
        user.setAge(1);
        user.setName("aaa");
        user.setId(1l);
        userService.insertUser(user);
        log.info("=========================");
        userService.updateUser();
    }
}
