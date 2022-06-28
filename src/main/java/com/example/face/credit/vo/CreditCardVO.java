package com.example.face.credit.vo;

import lombok.Data;

/**
 * 信用卡查询
 * */
@Data
public class CreditCardVO {
    private String id;
    /**
     * 卡号
     * */
    private String creditCardNo;
    /**
     * 卡片机构
     * */
    private String cardOrg;
    /**
     * 卡片类型（信用卡、花呗）
     * */
    private String cardType;
    /**
     * 账单日
     * */
    private String billingDate;
    /**
     * 还款日
     * */
    private String repaymentDate;
    /**
     * 额度
     * */
    private double totalQuota;
    /**
     * 剩余额度
     * */
    private double surplusQuota;
}
