package com.example.face.consume.service.impl;

import com.example.face.constant.Constants2;
import com.example.face.consume.mapper.ConsumeRecordMapper;
import com.example.face.consume.model.ConsumeRecordModel;
import com.example.face.consume.service.IConsumeRecordService;
import com.example.face.consume.vo.ConsumeRecordVo;
import com.example.face.credit.model.CreditCardModel;
import com.example.face.credit.service.ICreditCardService;
import com.example.face.credit.vo.CreditCardVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("consumeRecordService")
public class ConsumeRecordServiceImpl implements IConsumeRecordService {
    @Resource
    private ConsumeRecordMapper consumeRecordMapper;
    @Resource
    private ICreditCardService creditCardService;
    
    @Override
    public List<ConsumeRecordModel> findList(ConsumeRecordVo consumeRecordVO) {
        List<ConsumeRecordModel> list = consumeRecordMapper.findList(consumeRecordVO);
        return list;
    }
    
    @Override
    public ConsumeRecordModel view(ConsumeRecordVo consumeRecordVo) {
        return consumeRecordMapper.view(consumeRecordVo);
    }
    
    @Override
    public boolean insertModel(ConsumeRecordModel consumeRecordModel) {
        consumeRecordMapper.insertModel(consumeRecordModel);
        // 更新信用卡实时额度
        CreditCardVO creditCardVo = new CreditCardVO();
        creditCardVo.setId(consumeRecordModel.getCreditCardId());
        //实时额度
        CreditCardModel creditCard = creditCardService.view(creditCardVo);
        if(Constants2.CREDIT_TYPE_CONSUME.equals(consumeRecordModel.getConsumeType())){
            //消费减少卡片额度
            creditCard.setSurplusQuota(creditCard.getSurplusQuota() - consumeRecordModel.getConsumeMoney());
        } else if(Constants2.CREDIT_TYPE_REPAYMENT.equals(consumeRecordModel.getConsumeType())){
            //还款增加卡片额度
            creditCard.setSurplusQuota(creditCard.getSurplusQuota() + consumeRecordModel.getConsumeMoney());
        }
        creditCardService.update(creditCard);
        return true;
    }
    
    @Override
    public void updateModel(ConsumeRecordModel consumeRecordModel) {
        consumeRecordMapper.updateModel(consumeRecordModel);
    }
    
    @Override
    public void deleteById(ConsumeRecordModel consumeRecordModel) {
        // 删除时更新信用卡实时额度
        CreditCardVO creditCardVo = new CreditCardVO();
        creditCardVo.setId(consumeRecordModel.getCreditCardId());
        //实时额度
        CreditCardModel creditCard = creditCardService.view(creditCardVo);
        if(Constants2.CREDIT_TYPE_CONSUME.equals(consumeRecordModel.getConsumeType())){
            //消费减少卡片额度
            creditCard.setSurplusQuota(creditCard.getSurplusQuota() + consumeRecordModel.getConsumeMoney());
        } else if(Constants2.CREDIT_TYPE_REPAYMENT.equals(consumeRecordModel.getConsumeType())){
            //还款增加卡片额度
            creditCard.setSurplusQuota(creditCard.getSurplusQuota() - consumeRecordModel.getConsumeMoney());
        }
        creditCardService.update(creditCard);
        consumeRecordMapper.deleteById(consumeRecordModel);
    }
}
