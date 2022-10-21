package com.moli.datasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moli.datasource.domain.entity.TSysUser;
import com.moli.datasource.mapper.OdsSsBuriedPointBookDataMapper;
import com.moli.datasource.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OdsSsBuriedPointBookDataMapper odsSsBuriedPointBookDataMapper;

    @DS("master")
    public List<TSysUser> aaa() {
        return userMapper.selectList(new LambdaQueryWrapper<>());
    }

    @DS("slave_1")
    public Integer bbb(){
        Integer count = odsSsBuriedPointBookDataMapper.selectCount(new LambdaQueryWrapper<>());
        return count;
    }

}
