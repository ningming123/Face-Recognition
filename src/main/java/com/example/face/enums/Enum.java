package com.example.face.enums;

/**
 * @description 车辆状态
 *
 * @author NingMingFei
 * @date 2021-11-26 21:40:00
 * */
public enum Enum {
    /**
     * 道闸出场状态
     * */
    GATE_EXIST("2","出场"),
    
    /**
     * 上客位停车
     * */
    ONPLACE_PARKING("2","上客位停车"),
    /**
     * 离开上客位
     * */
    LEAVE_ONPLACE("3","离开上客位"),
    /**
     * 上客位停车
     * */
    PLACE_PARKING("4","停车位停车"),
    /**
     * 离开停车位
     * */
    LEAVE_PLACE("5","离开停车位"),
    /**
     * 占用上客位
     * */
    OCCUPY_ONPLACE("6","占用上客位"),
    /**
     * 停车位类型
     * */
    PARKING_TYPE("1","停车位"),
    /**
     * 上客位类型
     * */
    ONPLACE_TYPE("2","上客位"),
    /**
     * 上客位类型
     * */
    UPPLACE_TYPE("3","下客位"),
    /**
     * 站发车
     * */
    STATION_VEHICLE_TYPE("1","站发车"),
    /**
     * 过路车
     * */
    PASS_VEHICLE_TYPE("2","过路车"),
    /**
     * 车辆状态-未到出场时间
     * */
    BUS_STATUS_WDCCSJ("01","未到出场时间"),
    /**
     * 车辆状态-已回场车辆
     * */
    BUS_STATUS_YHCCL("02","已回场车辆"),
    /**
     * 车辆状态-已过出场时间
     * */
    BUS_STATUS_YGCCSJ("03","已过出场时间"),
    /**
     * 车辆状态-正在上客车辆
     * */
    BUS_STATUS_ZZSKCC("04","正在上客车辆"),
    /**
     * 屏幕左侧位置
     * */
    SCREEN_LEFT_POSITION("0","屏幕左侧位置"),
    /**
     * 屏幕右侧位置
     * */
    SCREEN_RIGHT_POSITION("1","屏幕右侧位置")
    ;
    
    private String code;
    private String name;
    
     Enum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
}
