package com.pdm.service.store;

import com.github.pagehelper.PageInfo;
import com.pdm.domain.store.Company;
import com.pdm.service.store.impl.CompanyServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class CompanyServiceTest {
    private static CompanyService companyService = null;
    @BeforeClass
    public static void init(){
        companyService = new CompanyServiceImpl();
    }

    /*@Test
    public  void testSave(){
        Company company = new Company();
        company.setName("测试数据");
        companyService.save(company);
    }*/

    @Test
    public void testFindAll(){
        PageInfo all = companyService.findAll(1, 100);
        System.out.println(all);
    }

    @AfterClass
    public static void destory(){
        companyService = null;
    }
}
