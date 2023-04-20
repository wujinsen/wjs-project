package cn.wjs.service.impl;

import cn.wjs.domain.PageRequest;
import cn.wjs.domain.SysUser;
import cn.wjs.domain.UserResponseDTO;
import cn.wjs.mapper.UserMapper;
import cn.wjs.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public UserResponseDTO select(Long id) {
        System.out.println("user select");
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        SysUser result = userMapper.selectOne(sysUser);
        System.out.println("result: " + result);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(result, userResponseDTO);
        return userResponseDTO;
    }

    public PageInfo<SysUser> userList(PageRequest request) {

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        Example example = new Example(SysUser.class);
//        example.createCriteria()
//                .andEqualTo("createTime", "");
        example.orderBy("createTime");
        List<SysUser> sysUserList = userMapper.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        return pageInfo;

    }

    @Override
    public SysUser selectUserByName(String userName) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);

        return userMapper.selectOne(sysUser);
    }

    @Override
    public Boolean supports(String name) {
        return "UserServiceImpl".equals(name);
    }
}

