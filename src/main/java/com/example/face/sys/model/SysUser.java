package com.example.face.sys.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {

    private String id;
    private String userName; //用户名
    private String passWord;   //密码
    private String randomCode; //随机码
    private String realName; //真实姓名
    private String department; //部门
    private String roleId; //角色id
    private String phone; //电话
    private String email; //邮箱
    private String ip; //IP地址
    private Date createTime; //创建时间
    private Date updateTime; //更新时间
    private String flag; //0删除，1未删除

}
