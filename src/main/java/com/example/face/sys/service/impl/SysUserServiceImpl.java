package com.example.face.sys.service.impl;

import com.example.face.sys.mapper.SysUserMapper;
import com.example.face.sys.model.SysUser;
import com.example.face.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser getUser(String id){
        return sysUserMapper.getUserById(id);
    }
    @Override
    public void saveUser(SysUser user){
         sysUserMapper.insert(user);
    }
    @Override
    public List<SysUser> getUserList(){
        return sysUserMapper.getUserList();
    }

    @Override
    public void updateUser(SysUser user){
        sysUserMapper.update(user);
    }
}
