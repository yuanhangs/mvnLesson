package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1）响应编码处理
        response.setContentType("text/html;charset=utf-8");

        //2）获得输出对象
        PrintWriter out = response.getWriter();

        out.println("HelloWorld！");
        out.println("<h1>杭州</h1>");

        //3)刷新,关闭
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //必须调用post方法
         doPost(request,response);
    }
}
