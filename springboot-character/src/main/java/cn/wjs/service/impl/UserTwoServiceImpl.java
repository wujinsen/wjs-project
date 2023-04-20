package cn.wjs.service.impl;

import cn.wjs.domain.PageRequest;
import cn.wjs.domain.SysUser;
import cn.wjs.domain.UserResponseDTO;
import cn.wjs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class UserTwoServiceImpl implements UserService {
    @Override
    public UserResponseDTO select(Long id) {
        System.out.println("UserTwoServiceImpl select");
        return null;
    }

    @Override
    public PageInfo<SysUser> userList(PageRequest request) {
        System.out.println("UserTwoServiceImpl userList");
        return null;
    }

    @Override
    public SysUser selectUserByName(String userName) {
        System.out.println("UserTwoServiceImpl selectUserByName");
        return null;
    }

    @Override
    public Boolean supports(String name) {
        return "UserTwoServiceImpl".equals(name);
    }
}
