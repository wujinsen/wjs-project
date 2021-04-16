package cn.wjs.service.impl;

import cn.wjs.domain.PageRequest;
import cn.wjs.domain.User;
import cn.wjs.domain.UserResponseDTO;
import cn.wjs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class UserTwoServiceImpl implements UserService {
    @Override
    public UserResponseDTO select(String id) {
        System.out.println("UserTwoServiceImpl select");
        return null;
    }

    @Override
    public PageInfo<User> userList(PageRequest request) {
        System.out.println("UserTwoServiceImpl userList");
        return null;
    }

    @Override
    public User selectUserByName(String userName) {
        System.out.println("UserTwoServiceImpl selectUserByName");
        return null;
    }

    @Override
    public Boolean supports(String name) {
        return "UserTwoServiceImpl".equals(name);
    }
}
