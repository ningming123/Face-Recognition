package com.example.face.dict.service;

import com.example.face.dict.model.BaseDictModel;

import java.util.List;

public interface BaseDictService {
    List<BaseDictModel> getDictList(String dictParentCode);
    
    BaseDictModel getDictByCode(String dictCode);
}
