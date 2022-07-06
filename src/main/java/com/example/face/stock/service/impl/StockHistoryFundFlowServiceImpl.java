package com.example.face.stock.service.impl;

import com.example.face.stock.mapper.StockHistoryFundFlowMapper;
import com.example.face.stock.model.entity.StockHistoryFundFlow;
import com.example.face.stock.model.vo.StockHistoryFundFlowVo;
import com.example.face.stock.service.IStockHistoryFundFlowService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service("stockHistoryFundFlowService")
public class StockHistoryFundFlowServiceImpl implements IStockHistoryFundFlowService {

    @Resource
    private StockHistoryFundFlowMapper stockHistoryFundFlowMapper;

    @Override
    public List<StockHistoryFundFlow> findList(StockHistoryFundFlowVo stockHistoryFundFlowVo) {
        return stockHistoryFundFlowMapper.findList(stockHistoryFundFlowVo);
    }

    @Override
    public List<StockHistoryFundFlow> getRecordByStockCode(StockHistoryFundFlowVo stockHistoryFundFlowVo) {
        Example example = new Example(StockHistoryFundFlow.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stockCode", stockHistoryFundFlowVo.getStockCode());
        example.orderBy("statisticsDate").asc();
        List<StockHistoryFundFlow> list = stockHistoryFundFlowMapper.selectByExample(stockHistoryFundFlowVo);
        return list;
    }

    public Map<String, Object> getEveryFundNetInFlow(StockHistoryFundFlowVo stockHistoryFundFlowVo) {

        List<StockHistoryFundFlow> list = getRecordByStockCode(stockHistoryFundFlowVo);
        if (list != null && list.size() > 0) {
            // 超级资金净流
            List<String> r0NetInList = new ArrayList<>();
            // 超级资金5日平均净流
            List<String> r0NetInAverList = new ArrayList<>();
            // 大户资金净流（大单+中单=大户资金）
            List<String> r1NetInList = new ArrayList<>();
            // 大户资金5日平均净流
            List<String> r1NetInAverList = new ArrayList<>();
            // 散户资金净流
            List<String> r3NetInList = new ArrayList<>();
            // 散户资金5日平均净流
            List<String> r3NetInAverList = new ArrayList<>();
            list.forEach(stockHistoryFundFlow -> {
                System.out.println(1);

            });
        }
        return null;
    }

}
