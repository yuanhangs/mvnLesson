package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //获得参数值
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        int flag = 0;

        //判断
        if ("林坤".equals(name) && "aaa".equals(pass)) {
            flag = 1;
        } else {
            flag = 0;
        }

        //响应结果
        out.print(flag);

        out.flush();
        out.close();
    }
}
