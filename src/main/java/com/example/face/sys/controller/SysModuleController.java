package com.example.face.sys.controller;

import com.example.face.sys.model.SysModule;
import com.example.face.sys.service.SysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/sys/module")
public class SysModuleController {
    @Autowired
    private SysModuleService moduleService;

    @RequestMapping(value = "/createMenu",method = RequestMethod.GET)
    public List<SysModule> createMenu(HttpServletResponse response){
        return moduleService.createMenu();
    }

}
