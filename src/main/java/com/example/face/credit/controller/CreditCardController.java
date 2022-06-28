package com.example.face.credit.controller;

import com.example.face.credit.model.CreditCardModel;
import com.example.face.credit.service.ICreditCardService;
import com.example.face.credit.vo.CreditCardVO;
import com.example.face.utils.core.Result;
import com.example.face.utils.core.ResultUtil;
import com.example.face.utils.string.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditCardController {
    
    @Resource
    private ICreditCardService creditCardService;

    
    @PostMapping("/findList")
    public Result findList(@RequestBody CreditCardVO creditCardVo){
        List<CreditCardModel> list = creditCardService.findList(creditCardVo);
        return ResultUtil.getSuccessResult(list);
    }
    
    @PostMapping("/view")
    public Result view(@RequestBody CreditCardVO creditCardVo){
        CreditCardModel CreditCardModel = creditCardService.view(creditCardVo);
        return ResultUtil.getSuccessResult(CreditCardModel);
    }
    
    @PostMapping("/save")
    public Result save(@RequestBody CreditCardModel creditCardModel){
        if(StringUtil.isNullOrEmpty(creditCardModel.getId())){
            creditCardService.insert(creditCardModel);
        }else{
            creditCardService.update(creditCardModel);
        }
        return ResultUtil.getSuccessResult();
    }
    
    
    @PostMapping("/delete")
    public Result deleteById(@RequestBody CreditCardModel creditCardModel){
        creditCardService.deleteById(creditCardModel);
        return ResultUtil.getSuccessResult("删除成功");
    }
}
