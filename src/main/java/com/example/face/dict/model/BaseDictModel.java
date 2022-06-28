package com.example.face.dict.model;

import lombok.Data;

@Data
public class BaseDictModel {
    /**
     * 编码
     * */
    private String dictCode;
    /**
     * 名称
     * */
    private String dictValue;
    /**
     * 字典类型编码
     * */
    private String dictParentCode;
    /**
     * 字典类型
     * */
    private String dictParentName;
}
