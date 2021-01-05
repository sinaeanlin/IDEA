package com.pdm.web.controller.store.company;

import com.github.pagehelper.PageInfo;
import com.pdm.domain.store.Company;
import com.pdm.service.store.CompanyService;
import com.pdm.service.store.impl.CompanyServiceImpl;
import com.pdm.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/store/company")
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if("list".equals(operation)) {
            this.list(request,response);
        }else if ("toAdd".equals(operation)){
            this.toAdd(request,response);
        }else if("save".equals(operation)){
            this.save(request,response);
        }
//        if("list".equals(operation)){
//            CompanyService companyService = new CompanyServiceImpl();
//            PageInfo all = companyService.findAll(1, 5);
//            request.setAttribute("page",all);
//            request.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(request,response);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        CompanyService companyService = new CompanyServiceImpl();
        int page = 1;
        int size = 5;
        if(StringUtils.isNotBlank(request.getParameter("page"))){
            page = Integer.parseInt(request.getParameter("page"));
        }
        if(StringUtils.isNotBlank(request.getParameter("size"))){
            size = Integer.parseInt(request.getParameter("size"));
        }
        PageInfo all = companyService.findAll(page, size);
        request.setAttribute("page",all);
        request.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(request,response);
    }
    private void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //请求转发
        request.getRequestDispatcher("/WEB-INF/pages/store/company/add.jsp").forward(request,response);
    }

    private void save(HttpServletRequest request,HttpServletResponse response) throws IOException {
        CompanyService companyService = new CompanyServiceImpl();
        Company company = BeanUtil.fillBean(request,Company.class,"yyyy-MM-dd");
        companyService.save(company);
        //重定向
        response.sendRedirect(request.getContextPath()+"/WEB-INF/pages/store/company/list.jsp");
    }
}
