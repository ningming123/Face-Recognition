package com.example.face.sys.controller;

import com.example.face.sys.model.SysUser;
import com.example.face.sys.service.SysUserService;
import com.example.face.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @RequestMapping("/getUserList")
    public List<SysUser> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/insert")
    public void insert(SysUser sysUser){
         userService.insert(sysUser);
    }
}
