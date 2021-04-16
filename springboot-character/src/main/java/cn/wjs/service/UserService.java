package cn.wjs.service;


import cn.wjs.domain.PageRequest;
import cn.wjs.domain.User;
import cn.wjs.domain.UserResponseDTO;
import com.github.pagehelper.PageInfo;


public interface UserService {

    public UserResponseDTO select(String id);

    public PageInfo<User> userList(PageRequest request);

    public User selectUserByName(String userName);

    public Boolean supports(String name);
}
