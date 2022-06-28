package com.example.face.credit.service.impl;

import com.example.face.credit.mapper.CreditCardMapper;
import com.example.face.credit.model.CreditCardModel;
import com.example.face.credit.service.ICreditCardService;
import com.example.face.credit.vo.CreditCardVO;
import com.example.face.utils.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("creditCardService")
public class CreditCardServiceImpl implements ICreditCardService {
    @Resource
    private CreditCardMapper creditCardMapper;
    
    @Override
    public List<CreditCardModel> findList(CreditCardVO creditCardVO) {
        List<CreditCardModel> list = creditCardMapper.findList(creditCardVO);
        
        for(CreditCardModel creditCardModel : list){
            //1.计算消费金额
            creditCardModel.setConsume(creditCardModel.getTotalQuota() - creditCardModel.getSurplusQuota());
            //2.剩余还款天数
            int repayDate = Integer.parseInt(creditCardModel.getRepaymentDate());
            int currentDay = DateUtil.getCurrentDay();
            int remainDay = repayDate > currentDay ? repayDate - currentDay : 30 + repayDate - currentDay;
            creditCardModel.setRemainDays(remainDay);
        }
        return list;
    }
    
    @Override
    public CreditCardModel view(CreditCardVO creditCardVo) {
        return creditCardMapper.view(creditCardVo);
    }
    
    @Override
    public void insert(CreditCardModel creditCardModel) {
        creditCardMapper.insert(creditCardModel);
    }
    
    @Override
    public void update(CreditCardModel creditCardModel) {
        creditCardMapper.update(creditCardModel);
    }
    
    @Override
    public void deleteById(CreditCardModel creditCardModel) {
        creditCardMapper.deleteById(creditCardModel);
    }
}
