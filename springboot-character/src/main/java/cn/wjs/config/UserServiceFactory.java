package cn.wjs.config;


import cn.wjs.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Component
public class UserServiceFactory {

//    @Autowired
//    ApplicationContext applicationContext;

    @Autowired
    @Qualifier("UserServiceMap")
    Map<String, UserService> maps;

    /**
     *
     * @param name 子类名称
     */
    public void select(String name){
        if (!CollectionUtils.isEmpty(maps)) {
            for (String key : maps.keySet()) {
                UserService userService = maps.get(key);
                if (userService.supports(name)){
                    userService.select(1l);
                    return;
                }
            }
        } else {

        }
    }

}
