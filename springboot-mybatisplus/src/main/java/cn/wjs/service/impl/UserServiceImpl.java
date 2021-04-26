package cn.wjs.service.impl;

import cn.wjs.mapper.UserMapper;
import cn.wjs.model.User;
import cn.wjs.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
