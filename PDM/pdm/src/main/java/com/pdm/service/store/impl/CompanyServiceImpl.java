package com.pdm.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdm.dao.store.CompanyDao;
import com.pdm.domain.store.Company;
import com.pdm.factory.MapperFactory;
import com.pdm.service.store.CompanyService;
import com.pdm.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;

import java.util.List;
import java.util.UUID;

public class CompanyServiceImpl implements CompanyService{
    @Override
    public void save(Company company) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            String id = UUID.randomUUID().toString();
            company.setId(id);
            companyDao.save(company);
            TransactionUtil.commit(sqlSession);
        }catch(Exception e){
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        }finally {
            try{
                TransactionUtil.close(sqlSession);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Company company) {
        SqlSession sqlSession = null;
        try{
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            companyDao.delete(company);
            TransactionUtil.commit(sqlSession);
        }catch(Exception e){
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        }finally {
            try{
                TransactionUtil.close(sqlSession);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Company company) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            companyDao.update(company);
            TransactionUtil.commit(sqlSession);
        }catch(Exception e){
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        }finally{
            try{
                TransactionUtil.close(sqlSession);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Company findById(String id) {
        SqlSession sqlSession = null;
        try{
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            return companyDao.findById(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            try{
                TransactionUtil.close(sqlSession);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Company> findAll() {
        SqlSession sqlSession = null;
        try{
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            return companyDao.findAll();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                TransactionUtil.close(sqlSession);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        try{
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            PageHelper.startPage(page,size);
            List<Company> all = companyDao.findAll();
            PageInfo pageInfo = new PageInfo(all);
            return pageInfo;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try{
                TransactionUtil.close(sqlSession);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
