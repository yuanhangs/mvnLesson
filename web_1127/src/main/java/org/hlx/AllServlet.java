package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
//只能是一个
//@WebServlet(name = "AllServlet", urlPatterns = {"/add.user"})

@WebServlet(name = "AllServlet", urlPatterns = {"*.user"})
public class AllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //查看路径：http://localhost:8889/add.user
//        String name = request.getParameter("name");
//        out.println(".<br/>"+name);

        //获取请求路径   /add.user
        String path = request.getServletPath();
        //out.println(path + "<p/>");

        //截取 add
        String pathName = path.substring(1, path.lastIndexOf("."));
       // out.println(pathName);

        //利用反射机制
        try {
            //pathName方法名; 后面2个是参数
            Method method = getClass().getDeclaredMethod(pathName,HttpServletRequest.class,HttpServletResponse.class);

            //调用
            method.invoke(this,request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }


        out.flush();
        out.close();

    }


    /**
     *  添加方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        out.println("<br/>" + name);
        out.flush();
        out.close();

    }

    /**
     * 修改方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("addr");
        out.println("<br/>" + name);
        out.flush();
        out.close();

    }

    /**
     * 删除方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("tel");
        out.println("<br/>" + name);
        out.flush();
        out.close();

    }
}
