package com.example.face.sys.controller;

import com.example.face.sys.model.SysUser;
import com.example.face.sys.service.SysUserService;
import com.example.face.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserServiceImpl t;

    @RequestMapping("/test")
    public List<SysUser> getUser(){
        return userService.getUserList();
    }

    @RequestMapping("/saveUser")
    public void saveUser(){
        SysUser user = new SysUser();
        user.setUserName("admin");
        user.setPassWord("123456");
        user.setEmail("1111@qq.com");
        user.setIp("127.0.0.1");
        user.setPhone("13700711111");
        //t.saveUser(user);
       // t.getUser("1");
         userService.saveUser(user);
    }
}
