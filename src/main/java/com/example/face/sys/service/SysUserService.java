package com.example.face.sys.service;

import com.example.face.sys.model.SysUser;

import java.util.List;

public interface SysUserService {
    SysUser getUserById(String id);

    void insert(SysUser user);

    List<SysUser> getUserList();

    void update(SysUser user);
}
