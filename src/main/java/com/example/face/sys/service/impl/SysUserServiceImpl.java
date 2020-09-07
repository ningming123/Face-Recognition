package com.example.face.sys.service.impl;

import com.example.face.sys.mapper.SysUserMapper;
import com.example.face.sys.model.SysUser;
import com.example.face.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    public SysUser getUser(){
        return sysUserMapper.getUser();
    }
}
