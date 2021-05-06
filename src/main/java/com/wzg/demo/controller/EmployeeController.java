package com.wzg.demo.controller;

import com.wzg.demo.dao.EmployeeDao;
import com.wzg.demo.pojo.Employee;
import com.wzg.demo.util.Result;
import com.wzg.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/getAll")
    public Result list(){
        Collection<Employee> employees=employeeDao.getAll();
        Map map=new HashMap();
        map.put("data",employees);
        return ResultUtil.success(map);
    }
}
