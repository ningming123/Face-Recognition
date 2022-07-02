package com.example.face.stock.service;

import com.example.face.stock.model.entity.StockFundFlow;

/**
 * 股票资金流处理
 *
 * @author ning
 * @date 2022-06-28
 * */
public interface IStockFundFlowService {
    
    /**
     * 从九方智投获取实时资金流数据
     *
     * @param stockCode 股票代码
     */
    StockFundFlow getFundFlowRealTimeByJFZT(String stockCode);
}
