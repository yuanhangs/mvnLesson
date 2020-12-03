package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * serlvet注解
 */
@WebServlet(name = "TestServlet",urlPatterns = "*.do",initParams ={
      @WebInitParam(name="uname",value = "Tim"),
      @WebInitParam(name="age",value = "20")
} )
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        out.println("哈哈...<br/>");

        //获得参数值
        String name  = getInitParameter("uname");
        String age  = getInitParameter("age");
        out.println(name+"<br/>"+age+"<br/>");


        //获取参数的值
        String find = request.getParameter("find");
        out.println(find+"..<br/>");

        out.flush();
        out.close();
    }
}
