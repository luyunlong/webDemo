package com.lu.spring.test;


import com.lu.spring.bean.Department;
import com.lu.spring.bean.Employee;
import com.lu.spring.dao.DepartmentMapper;
import com.lu.spring.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test(){

//        departmentMapper.insertSelective( new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));

//        employeeMapper.insertSelective(new Employee(null,"luyunlong","M","luyunlong@sis.sh.cn",1));

//        for (int i=0 ;i<100;i++){
//            String uid = UUID.randomUUID().toString().substring(0,5)+i;
//            employeeMapper.insertSelective(new Employee(null,uid,"F",uid+"@sis.sh.cn",2));
//
//        }

        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(2);
        System.out.println(employee);

    }
}
