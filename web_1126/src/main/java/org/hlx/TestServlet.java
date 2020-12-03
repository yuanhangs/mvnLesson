package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    /**
     * 构造方法
     */
    public TestServlet() {
        System.out.println("1.加载Servlet！new object");
    }

    /**
     * 初始化数据
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("2.初始化数据 init...");
    }

    //method=post
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //表单提交默认是Get方式(超链接)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理中文
        response.setContentType("text/html;charset=utf-8");

        //2.输出对象
        PrintWriter out = response.getWriter();

        out.println("hello,你好！");

        //获得局部参数
        String string =getInitParameter("name");
        String age =getInitParameter("age");

        out.println(string+"&nbsp;"+age);


        //3.获取全局参数
        String uname =getServletContext().getInitParameter("username");
        String upass =getServletContext().getInitParameter("password");
        out.println("<p/>"+uname+"&nbsp;"+upass);




        System.out.println("3.处理 head...");


        //3.刷新关闭
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("4.被火花 destroy....");
    }
}
