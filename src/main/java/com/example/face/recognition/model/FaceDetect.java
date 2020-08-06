package com.example.face.recognition.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FaceDetect implements Serializable {

    private static final long serialVersionUID = 8716314246936550427L;

    private Integer id;
    private String gender;  //性别
    private String emotion; //情绪
    private String face_shape; //脸型
    private double beauty; //颜值
    private Integer age; //年龄
    private String error_msg; //错误信息
    private Date timestamp; //检测时间
    private Integer error_code; //错误代码

}
