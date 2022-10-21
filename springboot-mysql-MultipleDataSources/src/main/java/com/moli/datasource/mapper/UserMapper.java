package com.moli.datasource.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moli.datasource.domain.entity.TSysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<TSysUser> {

}
