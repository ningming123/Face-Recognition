package com.example.face.sys.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysModule implements Serializable {
    /**
     * 菜单id
     * */
    private String id;
    /**
     * 菜单名称
     * */
    private String label;
    /**
     * 菜单标签
     * */
    private String icon;
    /**
     * 菜单路由
     * */
    private String path;
    /**
     * 父节点
     * */
    private String parentId;
    /**
     * 排序
     * */
    private Integer sort;
    /**
     * 子数据
     * */
    private List<SysModule> childrenList;
}
