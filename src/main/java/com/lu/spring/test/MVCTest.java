package com.lu.spring.test;


import com.github.pagehelper.PageInfo;
import com.lu.spring.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MVCTest {

    //虚拟mvc请求，获取处理结果
    private MockMvc mockMvc;
    //传入springmvc的ioc容器
    @Autowired
    private WebApplicationContext context;

    @Before
    public void initMockMvc(){

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void mockMvcTest() throws  Exception{
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1")).andReturn();

       //请求成功后，请求域中会有pageInfo，我们可以去除pageinfo进行验证
        MockHttpServletRequest request = result.getRequest();

        PageInfo info = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：");
        System.out.println("总页数"+info.getPages());
        System.out.println("总数目"+info.getTotal());


        List<Employee> emps = info.getList();
        for (Employee emp:emps) {
            System.out.println("emp:"+emp.getEmpId() + "," + emp.getEmpName());
        }

    }
}
