package com.example.face.stock.service.impl;

import com.example.face.stock.mapper.StockHistoryFundFlowMapper;
import com.example.face.stock.model.entity.StockHistoryFundFlow;
import com.example.face.stock.model.vo.StockHistoryFundFlowVo;
import com.example.face.stock.service.IStockHistoryFundFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stockHistoryFundFlowService")
public class StockHistoryFundFlowServiceImpl implements IStockHistoryFundFlowService {
    
    @Resource
    private StockHistoryFundFlowMapper stockHistoryFundFlowMapper;
    
    @Override
    public List<StockHistoryFundFlow> findList(StockHistoryFundFlowVo stockHistoryFundFlowVo) {
        return stockHistoryFundFlowMapper.findList(stockHistoryFundFlowVo);
    }
}
