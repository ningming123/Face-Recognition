package com.example.face.credit.service;

import com.example.face.credit.model.CreditCardModel;
import com.example.face.credit.vo.CreditCardVO;

import java.util.List;

public interface ICreditCardService {
    
    List<CreditCardModel> findList(CreditCardVO creditCardVO);
    
    void insert(CreditCardModel creditCardModel);
    
    void update(CreditCardModel creditCardModel);
    
    void deleteById(CreditCardModel creditCardModel);
    
    CreditCardModel view(CreditCardVO creditCardVo);
    
}
