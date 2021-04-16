package cn.wjs.config;

import cn.wjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
public class UserServiceConfig {


    @Autowired
    ApplicationContext applicationContext;

    @Bean(name="UserServiceMap")
    public Map<String, UserService> getRepaymentPlanEnterAccountServiceList() {
        return applicationContext.getBeansOfType(UserService.class);
    }

}
