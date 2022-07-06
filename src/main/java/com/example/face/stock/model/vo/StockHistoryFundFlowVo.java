package com.example.face.stock.model.vo;

import com.example.face.stock.model.entity.StockHistoryFundFlow;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 历史资金流实体（资金字段以九方智投为准）
 *
 * @author ning
 * @date 2022-06-28
 */
@Data
public class StockHistoryFundFlowVo extends StockHistoryFundFlow {
   
   private String startDate;
   
   private String endDate;
  
}
