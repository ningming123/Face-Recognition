package com.example.face.sys.service.impl;

import com.example.face.sys.mapper.SysModuleMapper;
import com.example.face.sys.model.SysModule;
import com.example.face.sys.service.SysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "moduleService")
public class SysModuleServiceImpl implements SysModuleService {
    @Resource
    private SysModuleMapper sysModuleMapper;

    @Override
    public List<SysModule> createMenu(){
        return sysModuleMapper.createMenu();
    }
    
    /**
     * 转换为树结构
     * */
//    public List<SysModule> getMenuTreeList(List<SysModule> menuList){
//        List<SysModule> menuTreeList = new ArrayList<>();
//        if(menuList == null || menuList.size() < 1){
//            return menuTreeList;
//        }
//        for (SysModule sysModule: menuList) {
//
//        }
//    }
    
    
}
