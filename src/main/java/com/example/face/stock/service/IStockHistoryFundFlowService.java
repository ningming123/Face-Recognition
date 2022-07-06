package com.example.face.stock.service;

import com.example.face.stock.model.entity.StockFundFlow;
import com.example.face.stock.model.entity.StockHistoryFundFlow;
import com.example.face.stock.model.vo.StockHistoryFundFlowVo;

import java.util.List;

/**
 * 股票资金流处理
 *
 * @author ning
 * @date 2022-06-28
 * */
public interface IStockHistoryFundFlowService {
    
    /**
     * 历史记录查询
     *
     * @param stockHistoryFundFlowVo
     */
    List<StockHistoryFundFlow> findList(StockHistoryFundFlowVo stockHistoryFundFlowVo);

}
