package com.example.face.utils.http;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求调度erp接口工具类
 * @author Ning
 * */
public class HttpUtil {
    // 默认连接、超时时间
    public static int CONNECT_TIME_OUT = 10000;
    public static int READ_TIME_OUT = 10000;
    
    /**
     * post请求调度
     * */
    public static String postJson( String url, Object obj) {
        String requestJson = JSON.toJSONString(obj);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> entity = new HttpEntity(requestJson, headers);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(CONNECT_TIME_OUT);
        requestFactory.setReadTimeout(READ_TIME_OUT);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String result = null;
        try {
            result = restTemplate.postForObject(url, entity, String.class, new Object[0]);
        } catch (Exception var14) {
            
            Map resultErrorMap = new HashMap();
            resultErrorMap.put("code", "400");
            return "";
        }
        return result;
    }
    
    /**
     * 请求调度系统接口
     * */
    public static String getJson(String url, Map paramMap) {
        try{
            String resultStr =
                HttpRequest.get(url)
                    .form(paramMap)
                    .execute()
                    .body();
            return resultStr;
        } catch (Exception e){
            
            Map resultErrorMap = new HashMap();
            resultErrorMap.put("code", "400");
            return "";
        }
        
    }
}
