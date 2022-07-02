package com.example.face.utils.http;

import com.alibaba.fastjson.JSON;
import com.example.face.utils.core.Result;
import com.example.face.utils.core.ResultCode;
import com.example.face.utils.core.ResultUtil;
import com.example.face.utils.string.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 请求结果处理类
 * */
@Slf4j
public class HttpResultUtil {
    
    /**
     * 处理九方智投接口返回值
     * @param resultStr
     * @return Result
     * */
    public static Result getResultByJFZT(String resultStr){
        if(StringUtil.isNullOrEmpty(resultStr)){
            return null;
        }
        // {"result":{"status":{"code":0},"data":{"r0_in":35433891,"r0_out":71095827,"r1_in":108840303,"r1_out":130008097,"r2_in":231982728,"r2_out":225235163,"r3_in":270560968,"r3_out":220478803}}}
       try {
           Map<String,Object> resultMap = JSON.parseObject(resultStr, Map.class);
           if (resultMap.containsKey("code") && ResultCode.FAIL.equals(String.valueOf(resultMap.get("code")))) {
               log.info("[九方智投实时资金流接口请求异常]");
               return ResultUtil.getFailResult();
           }
           // 获取到data层
           Map<String,Object> dataMap = JSON.parseObject(resultMap.get("result").toString(), Map.class);
           return ResultUtil.getSuccessResult(dataMap.get("data"));
       } catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.getFailResult();
       
    }
}
