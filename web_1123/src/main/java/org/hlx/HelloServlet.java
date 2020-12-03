package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码统一
        response.setContentType("text/html;charset=utf-8");

        //写入对象
        PrintWriter out = response.getWriter();

        out.println("掌声");

        System.out.println("HelloWorld");


        //刷新和关闭
        out.flush();
        out.close();

    }
}
