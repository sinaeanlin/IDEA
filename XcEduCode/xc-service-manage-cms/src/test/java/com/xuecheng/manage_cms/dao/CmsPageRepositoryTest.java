package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;
    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }
    @Test
    public void testUpdate(){
        Optional<CmsPage> option = cmsPageRepository.findById("");
        if (option.isPresent()){
            CmsPage cmsPage = option.get();
            cmsPage.setPageAliase("test001");
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }

    }
}
