package cn.wjs.service;


import cn.wjs.domain.PageRequest;
import cn.wjs.domain.SysUser;
import cn.wjs.domain.UserResponseDTO;
import com.github.pagehelper.PageInfo;


public interface UserService {

    public UserResponseDTO select(Long id);

    public PageInfo<SysUser> userList(PageRequest request);

    public SysUser selectUserByName(String userName);

    public Boolean supports(String name);
}

