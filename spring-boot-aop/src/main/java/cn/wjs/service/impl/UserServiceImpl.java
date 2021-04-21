package cn.wjs.service.impl;

import cn.wjs.model.User;
import cn.wjs.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public void insertUser(User str) {
        System.out.println("插入用户成功");
    }

    public void updateUser() {
        System.out.println("更新用户成功");
    }

}
