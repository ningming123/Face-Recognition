package com.example.face.consume.service;

import com.example.face.consume.model.ConsumeRecordModel;
import com.example.face.consume.vo.ConsumeRecordVo;

import java.util.List;

public interface IConsumeRecordService {
    
    List<ConsumeRecordModel> findList(ConsumeRecordVo consumeRecordVO);
    
    boolean insertModel(ConsumeRecordModel consumeRecordModel);
    
    void updateModel(ConsumeRecordModel consumeRecordModel);
    
    void deleteById(ConsumeRecordModel consumeRecordModel);
    
    ConsumeRecordModel view(ConsumeRecordVo consumeRecordVo);
    
}
