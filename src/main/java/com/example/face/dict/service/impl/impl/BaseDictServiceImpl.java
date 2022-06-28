package com.example.face.dict.service.impl.impl;

import com.example.face.dict.model.BaseDictModel;
import com.example.face.dict.service.BaseDictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
    
    @Override
    public List<BaseDictModel> getDictList(String dictParentCode) {
        return null;
    }
    
    @Override
    public BaseDictModel getDictByCode(String dictCode) {
        return null;
    }
}
