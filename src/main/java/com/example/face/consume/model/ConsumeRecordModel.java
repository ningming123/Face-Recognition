package com.example.face.consume.model;

import com.example.face.common.AbstractModel;
import lombok.Data;

import java.util.Date;

/**
 * 信用卡实体
 * */
@Data
public class ConsumeRecordModel extends AbstractModel {
    private String id;
    /**
     * 卡片管理id
     * */
    private String creditCardId;
    /**
     * 卡片
     * */
    private String creditCardNo;
    
    /**
     * 消费金额
     * */
    private double consumeMoney;
    /**
     * 消费日期
     * */
    private String consumeDate;
    /**
     * 卡片机构
     * */
    private String cardOrg;
    /**
     * 卡片类型（信用卡、花呗）
     * */
    private String cardType;
    /**
     * 消费类型（1：消费、2：还款）
     * */
    private String consumeType;
}
