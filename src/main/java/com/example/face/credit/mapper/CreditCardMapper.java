package com.example.face.credit.mapper;

import com.example.face.credit.model.CreditCardModel;
import com.example.face.credit.vo.CreditCardVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CreditCardMapper{
    
    List<CreditCardModel> findList(CreditCardVO creditCardVO);
    
    void insert(CreditCardModel creditCardModel);
    
    void update(CreditCardModel creditCardModel);
    
    void deleteById(CreditCardModel creditCardModel);
    
    CreditCardModel view(CreditCardVO creditCardVo);
    
}
