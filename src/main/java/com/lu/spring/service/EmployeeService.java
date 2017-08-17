package com.lu.spring.service;

import com.lu.spring.bean.Employee;
import com.lu.spring.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> getAll(){

        return employeeMapper.selectByExampleWithDept(null);
    }
}
