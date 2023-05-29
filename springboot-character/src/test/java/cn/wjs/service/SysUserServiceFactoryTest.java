package cn.wjs.service;


import cn.wjs.config.UserServiceFactory;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceFactoryTest {

    @Autowired
    private UserServiceFactory userServiceFactory;

    /**
     * 一种是通过工厂类的方式调用句子子类，类似于工厂模式与策略模式相结合; 另一只UserService注入指定别名
     */
    @Test
    public void test(){
        userServiceFactory.select("UserServiceImpl");
    }

}
