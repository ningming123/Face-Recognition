package com.example.face.sys.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysModule implements Serializable {

    private String label;
    private String icon;
    private String path;
    private String parentId;
}
