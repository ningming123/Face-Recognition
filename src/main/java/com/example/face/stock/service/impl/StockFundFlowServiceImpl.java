package com.example.face.stock.service.impl;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.example.face.stock.mapper.StockFundFlowMapper;
import com.example.face.stock.mapper.StockHistoryFundFlowMapper;
import com.example.face.stock.model.entity.StockFundFlow;
import com.example.face.stock.model.entity.StockHistoryFundFlow;
import com.example.face.stock.service.IStockFundFlowService;
import com.example.face.utils.core.Result;
import com.example.face.utils.date.DateUtil;
import com.example.face.utils.http.HttpResultUtil;
import com.example.face.utils.http.HttpUtil;
import com.example.face.utils.string.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service("stockFundFlowService")
public class StockFundFlowServiceImpl implements IStockFundFlowService {
    
    /**
     * 九方智投-获取实时单子流入
     */
    @Value("${stock.jfzt.level2.lv2DayInfoUrl}")
    private String lv2DayInfoUrl;
    
    /**
     * 九方智投-获取五日单子资金流入
     */
    @Value("${stock.jfzt.level2.lv2Day5InfoUrl}")
    private String lv2Day5InfoUrl;
    
    /**
     * 九方智投-各单净流入
     */
    @Value("${stock.jfzt.level2.lv2AdayMinUrl}")
    private String lv2AdayMinUrl;
    
    @Resource
    StockFundFlowMapper stockFundFlowMapper;
    @Resource
    StockHistoryFundFlowMapper stockHistoryFundFlowMapper;
    
    @Override
    public StockFundFlow getRealTimeFundFlowByJFZT(String stockCode) {
        if (StringUtil.isNullOrEmpty(stockCode)) {
            log.info("股票代码为空，无法请求");
            return null;
        }
        String resultStr = HttpUtil.getJson(lv2DayInfoUrl + stockCode);
        Result result = HttpResultUtil.getResultByJFZT(resultStr);
        try {
            // 拿到实时数据
            StockFundFlow stockFundFlow = JSON.parseObject(result.getData().toString(), StockFundFlow.class);
            // 计算各单资金净流（尽量别调用接口获取，防止频繁调用被封ip）
            stockFundFlow = (StockFundFlow)computeNetFlowFund(stockFundFlow);
            stockFundFlow.setCurrentDate(DateUtil.getSystemDate());
            stockFundFlow.setStockCode(stockCode);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("[九方智投实时资金流接口数据转换异常]");
        }
        
        return null;
    }
    
    @Override
    public List<StockHistoryFundFlow> get5DayFundFlowByJFZT(String stockCode) {
        if (StringUtil.isNullOrEmpty(stockCode)) {
            log.info("股票代码为空，无法请求");
            return null;
        }
        String resultStr = HttpUtil.getJson(lv2Day5InfoUrl + stockCode);
        Result result = HttpResultUtil.getResultByJFZT(resultStr);
        try {
            // 拿到历史5日数据
            Map<String,Object> last5DayList = JSON.parseObject(result.getData().toString(), Map.class);
            Set<String> last5Days = last5DayList.keySet();
            for (String day : last5Days){
                StockHistoryFundFlow historyFundFlow = JSON.parseObject(JSON.toJSONString(last5DayList.get(day)),StockHistoryFundFlow.class);
                historyFundFlow.setId(UUID.randomUUID().toString());
                // 计算资金净流
                historyFundFlow = (StockHistoryFundFlow)computeNetFlowFund(historyFundFlow);
                historyFundFlow.setStockCode(stockCode);
                historyFundFlow.setCurrentDate(day);
                stockHistoryFundFlowMapper.insert(historyFundFlow);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("[九方智投实时资金流接口数据转换异常]");
        }
        
        return null;
    }
    
    /**
     * 计算资金净流
     * */
    private Object computeNetFlowFund(Object object){
        if(object == null){
            return null;
        }
        if (object.getClass().isInstance(StockFundFlow.class)) {
            StockFundFlow stockFundFlow = (StockFundFlow)object;
            stockFundFlow.setUpdateTime(new Date());
            stockFundFlow.setR0_net_in(stockFundFlow.getR0_in().subtract(stockFundFlow.getR0_out()));
            stockFundFlow.setR1_net_in(stockFundFlow.getR1_in().subtract(stockFundFlow.getR1_out()));
            stockFundFlow.setR2_net_in(stockFundFlow.getR2_in().subtract(stockFundFlow.getR2_out()));
            stockFundFlow.setR3_net_in(stockFundFlow.getR3_in().subtract(stockFundFlow.getR3_out()));
            stockFundFlow.setUpdateTime(new Date());
            return stockFundFlow;
        }else {
            StockHistoryFundFlow stockHistoryFundFlow = (StockHistoryFundFlow)object;
            stockHistoryFundFlow.setUpdateTime(new Date());
            stockHistoryFundFlow.setR0_net_in(stockHistoryFundFlow.getR0_in().subtract(stockHistoryFundFlow.getR0_out()));
            stockHistoryFundFlow.setR1_net_in(stockHistoryFundFlow.getR1_in().subtract(stockHistoryFundFlow.getR1_out()));
            stockHistoryFundFlow.setR2_net_in(stockHistoryFundFlow.getR2_in().subtract(stockHistoryFundFlow.getR2_out()));
            stockHistoryFundFlow.setR3_net_in(stockHistoryFundFlow.getR3_in().subtract(stockHistoryFundFlow.getR3_out()));
            stockHistoryFundFlow.setCreateTime(new Date());
            return stockHistoryFundFlow;
        }
    }
}
