package cn.wjs.service.impl;

import cn.wjs.domain.PageRequest;
import cn.wjs.domain.User;
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
    public UserResponseDTO select(String id) {
        System.out.println("user select");
        User user = new User();
        user.setId(id);
        User result = userMapper.selectOne(user);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(result, userResponseDTO);
        return userResponseDTO;
    }

    public PageInfo<User> userList(PageRequest request) {

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        Example example = new Example(User.class);
//        example.createCriteria()
//                .andEqualTo("createTime", "");
        example.orderBy("createTime");
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;

    }

    @Override
    public User selectUserByName(String userName) {
        User user = new User();
        user.setName(userName);

        return userMapper.selectOne(user);
    }

    @Override
    public Boolean supports(String name) {
        return "UserServiceImpl".equals(name);
    }
}

