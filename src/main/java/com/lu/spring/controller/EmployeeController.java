package com.lu.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lu.spring.bean.Employee;
import com.lu.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    /*这是个员工查询*/
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model){
        //这是个分页查询
        //导入PageHelper分页插件
        //在查询之前只需要跳用，并传入页码以及每页的大小

        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是个分页查询
        List<Employee> list = employeeService.getAll();
        //使用PageInfo包装查询后的结果，只需要将pageInfo交给页面
        //封装类详细的分页信息，以及查询出来的数据,传入连续显示的页数
        PageInfo info = new PageInfo(list,5);


        model.addAttribute("pageInfo",info);

        return "list";

    }
}
