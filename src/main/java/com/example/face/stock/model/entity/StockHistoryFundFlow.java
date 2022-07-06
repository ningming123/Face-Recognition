package com.example.face.stock.model.entity;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 历史资金流实体（资金字段以九方智投为准）
 *
 * @author ning
 * @date 2022-06-28
 */
@Table(name = "stock_history_fund_flow")
public class StockHistoryFundFlow {
    /**
     * id
     */
    private String id;
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 股票名称
     */
    private String stockName;
    /**
     * 当前日期
     */
    private String currentDate;
    
    /**
     * 超大单流入
     */
    private BigDecimal r0_in;
    /**
     * 超大单流出
     */
    private BigDecimal r0_out;
    /**
     * 大单流入
     */
    private BigDecimal r1_in;
    /**
     * 大单流出
     */
    private BigDecimal r1_out;
    /**
     * 中单流入
     */
    private BigDecimal r2_in;
    /**
     * 中单流出
     */
    private BigDecimal r2_out;
    /**
     * 小单流入
     */
    private BigDecimal r3_in;
    /**
     * 小单流出
     */
    private BigDecimal r3_out;
    /**
     * 超大单净流入
     */
    private BigDecimal r0_net_in;
    /**
     * 大单净流入
     */
    private BigDecimal r1_net_in;
    /**
     * 中单净流入
     */
    private BigDecimal r2_net_in;
    /**
     * 小单净流入
     */
    private BigDecimal r3_net_in;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 记录创建人
     */
    private String createUser;
    
    /**
     * 记录创建时间
     */
    private Date createTime;
    
    /**
     * 记录更新人
     */
    private String updateUser;
    
    /**
     * 记录更新时间
     */
    private Date updateTime;
    

    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getStockCode() {
        return stockCode;
    }
    
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
    
    public String getStockName() {
        return stockName;
    }
    
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    
    public String getCurrentDate() {
        return currentDate;
    }
    
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    public BigDecimal getR0_in() {
        return r0_in;
    }
    
    public void setR0_in(BigDecimal r0_in) {
        this.r0_in = r0_in;
    }
    
    public BigDecimal getR0_out() {
        return r0_out;
    }
    
    public void setR0_out(BigDecimal r0_out) {
        this.r0_out = r0_out;
    }
    
    public BigDecimal getR1_in() {
        return r1_in;
    }
    
    public void setR1_in(BigDecimal r1_in) {
        this.r1_in = r1_in;
    }
    
    public BigDecimal getR1_out() {
        return r1_out;
    }
    
    public void setR1_out(BigDecimal r1_out) {
        this.r1_out = r1_out;
    }
    
    public BigDecimal getR2_in() {
        return r2_in;
    }
    
    public void setR2_in(BigDecimal r2_in) {
        this.r2_in = r2_in;
    }
    
    public BigDecimal getR2_out() {
        return r2_out;
    }
    
    public void setR2_out(BigDecimal r2_out) {
        this.r2_out = r2_out;
    }
    
    public BigDecimal getR3_in() {
        return r3_in;
    }
    
    public void setR3_in(BigDecimal r3_in) {
        this.r3_in = r3_in;
    }
    
    public BigDecimal getR3_out() {
        return r3_out;
    }
    
    public void setR3_out(BigDecimal r3_out) {
        this.r3_out = r3_out;
    }
    
    public BigDecimal getR0_net_in() {
        return r0_net_in;
    }
    
    public void setR0_net_in(BigDecimal r0_net_in) {
        this.r0_net_in = r0_net_in;
    }
    
    public BigDecimal getR1_net_in() {
        return r1_net_in;
    }
    
    public void setR1_net_in(BigDecimal r1_net_in) {
        this.r1_net_in = r1_net_in;
    }
    
    public BigDecimal getR2_net_in() {
        return r2_net_in;
    }
    
    public void setR2_net_in(BigDecimal r2_net_in) {
        this.r2_net_in = r2_net_in;
    }
    
    public BigDecimal getR3_net_in() {
        return r3_net_in;
    }
    
    public void setR3_net_in(BigDecimal r3_net_in) {
        this.r3_net_in = r3_net_in;
    }

    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
