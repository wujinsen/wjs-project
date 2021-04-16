package cn.wjs;


import cn.wjs.mapper.UserInfoMapper;
import cn.wjs.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
public class UserInfoTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void userInfoSelect(){
        List<UserInfo> list = userInfoMapper.selectAll();
        list.stream().forEach(userInfo -> System.out.println(userInfo.toString()));
    }

    @Test
    public void aaa(){
        System.out.println("aaa");
    }

}
