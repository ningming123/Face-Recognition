package com.example.face.dict.mapper;

import com.example.face.dict.model.BaseDictModel;

import java.util.List;

public interface BaseDictMapper {
    
    List<BaseDictModel> getDictList(String dictParentCode);
    
    BaseDictModel getDictByCode(String dictCode);
}
