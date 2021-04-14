package com.example.face.sys.mapper;

import com.example.face.sys.model.SysUser;
import java.util.List;

public interface SysUserMapper {

    SysUser getUserById(String userId);

    void insert(SysUser user);

    List<SysUser> getUserList();

    void update(SysUser user);
}
