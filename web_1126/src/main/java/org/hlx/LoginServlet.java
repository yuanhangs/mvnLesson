package org.hlx;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理中文
        response.setContentType("text/html;charset=utf-8");
        //2.输出对象
        PrintWriter out = response.getWriter();

        ////////////////////////////////////////////////
        //登录处理
        //处理中文乱码
        //request.setCharacterEncoding("utf-8");

        //参数值
        String uname = request.getParameter("username");
        String upass = request.getParameter("userpass");
        //判断
        if("林肯".equals(uname) && "12345".equals(upass)){
            out.println("登录成功！");
//            保存数据

            //会话对象
//            HttpSession session = request.getSession();
//            //保存
//            session.setAttribute("uname",uname);
//            //跳转
//            response.sendRedirect("show.jsp");


//            //请求对象保存数据 ==>(使用转发)
//            request.setAttribute("unames",uname);
//            request.getRequestDispatcher("show.jsp").forward(request,response);

             //上下文对象保存数据(整个工程)
             ServletContext application= this.getServletContext();
             application.setAttribute("app",uname);
             //跳转
             response.sendRedirect("show.jsp");

        }else{
            out.println("登录失败！");
        }

        //////////////////////////////////////
        //3.刷新关闭
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理中文
        response.setContentType("text/html;charset=utf-8");
        //2.输出对象
        PrintWriter out = response.getWriter();

        //登录页面
        out.println("<html><head><title>登录页面</title></head><body>");
        out.println("<form action='login' method='post'>");
        out.println("用户名:<input type='text' name='username'><p/>");
        out.println("密码:<input type='password' name='userpass'><p/>");
        out.println("<input type='submit' name='sub' value='登录'>");
        out.println("</form></body>");

//
//        //3.获取全局参数
//        String uname =getServletContext().getInitParameter("username");
//        String upass =getServletContext().getInitParameter("password");
//        out.println("<p/>"+uname+"&nbsp;"+upass);


        //3.刷新关闭
        out.flush();
        out.close();
    }
}
