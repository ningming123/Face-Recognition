package com.example.face.consume.mapper;

import com.example.face.consume.model.ConsumeRecordModel;
import com.example.face.consume.vo.ConsumeRecordVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ConsumeRecordMapper extends Mapper<ConsumeRecordModel> {
    
    List<ConsumeRecordModel> findList(ConsumeRecordVo consumeRecordVO);
    
    void insertModel(ConsumeRecordModel consumeRecordModel);
    
    void updateModel(ConsumeRecordModel consumeRecordModel);
    
    void deleteById(ConsumeRecordModel consumeRecordModel);
    
    ConsumeRecordModel view(ConsumeRecordVo consumeRecordVo);
    
}
