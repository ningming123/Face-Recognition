package com.example.face.consume.controller;

import com.example.face.consume.model.ConsumeRecordModel;
import com.example.face.consume.service.IConsumeRecordService;
import com.example.face.consume.vo.ConsumeRecordVo;
import com.example.face.utils.constant.Constants;
import com.example.face.utils.core.Result;
import com.example.face.utils.core.ResultUtil;
import com.example.face.utils.string.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumeRecordController {
    
    @Resource
    private IConsumeRecordService consumeRecordService;

    
    @PostMapping("/findList")
    public Result findList(@RequestBody ConsumeRecordVo consumeRecordVo){
        consumeRecordVo.setPageSize(consumeRecordVo.getPageSize() == null ? Constants.PAGE_SIZE : consumeRecordVo.getPageSize());
        //分页时，查询必须放在startPage后，详情参考PageHelper分页原理
        PageHelper.startPage(consumeRecordVo.getPageNumber(), consumeRecordVo.getPageSize());
        List<ConsumeRecordModel> list = consumeRecordService.findList(consumeRecordVo);
        return ResultUtil.getSuccessResult(new PageInfo<ConsumeRecordModel>(list));
      
    }
    
    @PostMapping("/view")
    public Result view(@RequestBody ConsumeRecordVo consumeRecordVo){
        ConsumeRecordModel ConsumeRecordModel = consumeRecordService.view(consumeRecordVo);
        return ResultUtil.getSuccessResult(ConsumeRecordModel);
    }
    
    @PostMapping("/save")
    public Result save(@RequestBody ConsumeRecordModel consumeRecordModel){
        if(StringUtil.isNullOrEmpty(consumeRecordModel.getId())){
            consumeRecordService.insertModel(consumeRecordModel);
        }else{
            consumeRecordService.updateModel(consumeRecordModel);
        }
        return ResultUtil.getSuccessResult();
    }
    
    
    @PostMapping("/delete")
    public Result deleteById(@RequestBody ConsumeRecordModel consumeRecordModel){
        consumeRecordService.deleteById(consumeRecordModel);
        return ResultUtil.getSuccessResult("删除成功");
    }
    
    @PostMapping("/test")
    public Result test(@RequestBody ConsumeRecordModel consumeRecordModel){
        
        return ResultUtil.getSuccessResult("删除成功");
    }
}
