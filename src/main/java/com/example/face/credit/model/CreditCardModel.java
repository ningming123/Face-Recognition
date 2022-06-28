package com.example.face.credit.model;

import com.example.face.common.AbstractModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 信用卡实体
 * */
@Data
@Table(name = "df")
public class CreditCardModel extends AbstractModel {
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 父id
     * */
    @Transient
    private String creditCardId;
    /**
     * 卡号
     * */
    @Column(name = "credit_card_no")
    private String creditCardNo;
    /**
     * 卡片机构
     * */
    @Column(name = "card_org")
    private String cardOrg;
    /**
     * 卡片类型（信用卡、花呗）
     * */
    @Column(name = "card_type")
    private String cardType;
    /**
     * 账单日
     * */
    @Column(name = "billing_date")
    private String billingDate;
    /**
     * 还款日
     * */
    @Column(name = "repayment_date")
    private String repaymentDate;
    /**
     * 额度
     * */
    @Column(name = "total_quota")
    private double totalQuota;
    /**
     * 剩余额度
     * */
    @Column(name = "surplus_quota")
    private double surplusQuota;
    /**
     * 消费金额
     * */
    @Transient
    private double consume;
    /**
     * 剩余天数
     * */
    @Transient
    private int remainDays;
}
