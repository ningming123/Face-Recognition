package com.example.face.sys.service;

import com.example.face.sys.model.SysUser;

import java.util.List;

public interface SysUserService {
    SysUser getUser(String id);

    void saveUser(SysUser user);

    List<SysUser> getUserList();

    void updateUser(SysUser user);
}
