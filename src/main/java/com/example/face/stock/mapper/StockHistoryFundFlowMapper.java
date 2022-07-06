package com.example.face.stock.mapper;

import com.example.face.stock.model.entity.StockHistoryFundFlow;
import com.example.face.stock.model.vo.StockHistoryFundFlowVo;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

/**
 * 历史资金净流mapper
 * @author ning
 * */
public interface StockHistoryFundFlowMapper extends Mapper<StockHistoryFundFlow> {

    /**
     * 列表查询
     * @param stockHistoryFundFlowVo
     * @return list
     * */
    List<StockHistoryFundFlow> findList(StockHistoryFundFlowVo stockHistoryFundFlowVo);

}
