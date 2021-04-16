package cn.wjs.controller;


import cn.wjs.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/aaa")
    @ResponseBody
    public String aaa(){
        return "aaa";
    }
    @RequestMapping("/bbb")
    @ResponseBody
    public String bbb(){
        userInfoMapper.selectAll();
        return "bbb";
    }
}
