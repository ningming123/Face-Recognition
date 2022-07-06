package com.example.face.stock.controller;

import com.example.face.stock.model.entity.StockHistoryFundFlow;
import com.example.face.stock.model.vo.StockHistoryFundFlowVo;
import com.example.face.stock.service.IStockHistoryFundFlowService;
import com.example.face.utils.core.Result;
import com.example.face.utils.core.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockFundFLowController {
    
    @Resource
    private IStockHistoryFundFlowService stockHistoryFundFlowService;
    /**
     * 获取历史资金净流
     * @param stockCode 股票代码
     * */
    @ApiOperation(value = "获取历史资金净流", notes = "/stock/getHistoryFundFlowByCode")
    @GetMapping("/getHistoryFundFlowByCode")
    public Result getHistoryFundFlowByCode(@RequestParam String stockCode){
        StockHistoryFundFlowVo stockHistoryFundFlowVo = new StockHistoryFundFlowVo();
        stockHistoryFundFlowVo.setStockCode(stockCode);
        List<StockHistoryFundFlow> list = stockHistoryFundFlowService.findList(stockHistoryFundFlowVo);
        return ResultUtil.getSuccessResult(list);
    }
}
