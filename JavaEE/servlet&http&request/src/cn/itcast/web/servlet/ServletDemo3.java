package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/demo3")定义多个访问路劲
/*
    定义规则
    1./xxx
    @WebServlet("/demo")
    2./xx/xx
    @WebServlet("/demo/demo3")
    @WebServlet("/demo/*")
    3.*.do
    @WebServlet("*.do")
    @WebServlet("demo4.haha")
 */
@WebServlet({"/d3","/dd3","/demo3"})
public class ServletDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("doget");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("dopost");
    }
}
