package com.example.face.common;

import lombok.Data;

import java.util.Date;
@Data
public abstract class AbstractModel {
    private String createUser;
    private Date createTime;
    private Date updateTime;
    /**
     * 是否有效：标识数据是否可用：1：可用；0：不可用
     * */
    private String isValid;
}
