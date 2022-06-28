package com.example.face.consume.vo;

import com.example.face.consume.model.ConsumeRecordModel;
import lombok.Data;


/**
 * 信用卡查询
 * */
@Data
public class ConsumeRecordVo extends ConsumeRecordModel {
    /**
     * 当前页 默认 0
     * */
    protected Integer pageNum;
    /**
     * 当前页 默认 0
     * */
    protected Integer pageNumber;
    /**
     * 页大小 默认 10
     * */
    protected Integer pageSize;
    /**
     * 卡号
     * */
    private String creditCardNo;
    /**
     * 卡号
     * */
    private String repaymentDate;
    
}
