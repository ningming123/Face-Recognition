package com.example.face.sys.service.impl;

import com.example.face.sys.mapper.SysModuleMapper;
import com.example.face.sys.model.SysModule;
import com.example.face.sys.service.SysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "moduleService")
public class SysModuleServiceImpl implements SysModuleService {
    @Autowired
    private SysModuleMapper sysModuleMapper;

    @Override
    public List<SysModule> createMenu(){
        return sysModuleMapper.createMenu();
    }
}
