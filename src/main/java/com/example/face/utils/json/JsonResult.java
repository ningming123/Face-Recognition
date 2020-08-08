package com.example.face.utils.json;

import java.io.Serializable;

/**
 * @description:所有Rest接口返回公共对象
 * @author: 孔垂云
 * @version: 1.0
 * @date: 2019/8/28 17:00
 */
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 8193557574460148697L;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回码
     */
    private String returnCode;

    /**
     * 额外的数据
     */
    private T data;

    JsonResult() {
        this(GlobalReturnCode.OK);
    }

    public JsonResult(String returnCode, String msg, T data) {
        this.msg = msg;
        this.returnCode = returnCode;
        this.data = data;
    }

    public JsonResult(String returnCode, String msg) {
        this.msg = msg;
        this.returnCode = returnCode;
    }

    public JsonResult(GlobalReturnCode globalReturnCode) {
        this.returnCode = globalReturnCode.getReturnCode();
        this.msg = globalReturnCode.getMsg();
    }

    public JsonResult(GlobalReturnCode globalReturnCode, T data) {
        this.returnCode = globalReturnCode.getReturnCode();
        this.msg = globalReturnCode.getMsg();
        this.data = data;
    }

    public JsonResult(GlobalReturnCode globalReturnCode, String msg, T data) {
        this.returnCode = globalReturnCode.getReturnCode();
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResult<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public JsonResult<T> returnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public T getData() {
        return data;
    }

    public JsonResult<T> data(T data) {
        this.data = data;
        return this;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return GlobalReturnCode.OK.getReturnCode().equals(this.returnCode);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "msg='" + msg + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", data=" + data +
                '}';
    }
}