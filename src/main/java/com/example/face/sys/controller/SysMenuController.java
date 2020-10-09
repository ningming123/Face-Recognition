package com.example.face.sys.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.face.sys.service.SysModuleService;
import com.example.face.utils.web.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class SysMenuController {
    @Autowired
    private SysModuleService moduleService;

    @RequestMapping("/createMenu")
    public void createMenu(HttpServletResponse response){
        String menu = "[" + moduleService.createMenu() + "]";
        WebUtils.out(response,menu);
    }

}
