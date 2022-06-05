package com.TcherW;

import sun.management.Agent;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Demo1")
public class servletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//
//        resp.setHeader("content-type", "text/html;charset=utf-8");
//        resp.getWriter().write("<h1>" + name + ", welcome!</h1>");


//      获取请求方式
        String method = req.getMethod();
        System.out.println(method);

//      获取虚拟路劲
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

//        获取URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

//        获取URI
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

//        获取请求参数（get方式）
        String queryString = req.getQueryString();
        System.out.println(queryString);


//      打印请求头
        String header = req.getHeader("user-agent");
        System.out.println(header);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        获取请求参数（POST方式）
        BufferedReader reader = req.getReader();

        String line = reader.readLine();

        System.out.println(line);
    }
}
