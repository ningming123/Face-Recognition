package com.example.face.sys.controller;

import com.example.face.sys.model.SysUser;
import com.example.face.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @RequestMapping("/test")
    public SysUser getUser(){
        return sysUserServiceImpl.getUser();
    }
}
