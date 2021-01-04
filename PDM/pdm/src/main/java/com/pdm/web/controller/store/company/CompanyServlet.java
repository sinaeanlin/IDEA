package com.pdm.web.controller.store.company;

import com.github.pagehelper.PageInfo;
import com.pdm.service.store.CompanyService;
import com.pdm.service.store.impl.CompanyServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store/company")
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if("list".equals(operation)){
            CompanyService companyService = new CompanyServiceImpl();
            PageInfo all = companyService.findAll(1, 5);
            request.setAttribute("page",all);
            request.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(request,response);
        }
//        System.out.println("11111111");
//        String operation = request.getParameter("operation");
//        if("list".equals(operation)){
//            CompanyService companyService = new CompanyServiceImpl();
//            int page = 1;
//            int size = 5;
//            if(StringUtils.isNotBlank(request.getParameter("page"))){
//                page = Integer.parseInt(request.getParameter("page"));
//            }
//            if(StringUtils.isNotBlank(request.getParameter("size"))){
//                size = Integer.parseInt(request.getParameter("size"));
//            }
//            PageInfo all = companyService.findAll(page, size);
//            //PageInfo all = companyService.findAll(1, 100);
//            //将数据保存到指定的位置
//            request.setAttribute("page",all);
//            //跳转页面
//            request.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(request,response);
//        }else if("toAdd".equals(operation)){
//
//        }else if("list".equals(operation)){
//
//        }else if("list".equals(operation)){
//
//        }else if("list".equals(operation)){
//
//        }else if("list".equals(operation)){
//
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
