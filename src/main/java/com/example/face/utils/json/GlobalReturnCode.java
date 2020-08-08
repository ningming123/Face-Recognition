package com.example.face.utils.json;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:ReturnCode公共返回码
 * @author: 孔垂云
 * @version: 1.0
 * @date: 2019/8/28 17:00
 */
@Getter
@AllArgsConstructor
public enum GlobalReturnCode {

    OK("00200", "OK"),
    URI_NOT_FOUND("00404", "请求路径不存在！"),
    REQUEST_METHOD_ERROR("00405", "非法请求方式"),
    JSON_ERROR("00420", "JSON格式错误"),
    PARAMS_ERROR("00421", "参数格式错误"),
    TOO_MANG_REQUESTS("00429", "请求限流中！"),
    SERVER_ERROR("00500", "服务器异常，请稍后重试！"),
    REQUEST_NO_BODY("00600", "请求缺失body"),
    REFERER_ERROR("00602", "B/S项目非法referer"),
    BUSINESS_ERROR("00900", "操作失败！"),

    /*网关鉴权*/
    GATEWAY_TIME_OUT("00504", "网关超时，请重试一次!"),

    USER_LOGIN_FAIL("02002", "用户名或密码错误！"),
    INVALID_TOKEN("00601", "无效的TOKEN!"),
    NO_PERMISSION_TOKEN("00603", "TOKEN无对应权限!"),
    INVALID_APPID("00604", "APPID无效!"),
    NO_PREMISSION_BANAPPID("00605", "APPID已被禁用!"),
    NO_PREMISSION_OVERDUE("00606", "APPID已过期!"),
    NO_PERMISSION_URL("00607", "APPID无请求URL权限！"),
    INVALID_REFRESHTOKEN("00608", "无效的REFRESH_TOKEN!"),
    AUTH_ERROR("00610", "鉴权服务异常！"),

    /*系统管理部分*/
    CODE_NOT_EXIST("25001", "模块代码已存在"),
    EXIST("00430","已存在");

    final String returnCode;
    final String msg;
}