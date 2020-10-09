package com.example.face.sys.service.impl;

import com.example.face.sys.service.SysModuleService;
import org.springframework.stereotype.Service;

@Service(value = "moduleService")
public class SysModuleServiceImpl implements SysModuleService {

    @Override
    public String createMenu(){
        String menuJson = "{ label: '颜值打分', icon: 'fa fa-dashboard', path: '/faceDetect' }";
        return menuJson;
    }
}
