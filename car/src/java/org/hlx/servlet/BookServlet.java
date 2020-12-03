package org.hlx.servlet;


import org.hlx.dao.BookDao;
import org.hlx.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@WebServlet(name = "BookServlet", urlPatterns = {"*.do"})
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //具体操作
        //获得提交路径  /save.action
        String path = request.getServletPath();
        //截取文件名 save
        String fileName = path.substring(1, path.lastIndexOf("."));
        try {
            //利用反射机制
            Method method = this.getClass().getDeclaredMethod(fileName, HttpServletRequest.class, HttpServletResponse.class);
            //调用
            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 所有数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();
        //////////////
//        业务数据
        BookDao dao = new BookDao();

        //获得所有的书数据
        Map<Integer, Book> books=dao.all();

        //书信息
        Collection<Book> colls = dao.getBooks(books);

        //保存数据
        request.setAttribute("books", colls);

        //跳转
        request.getRequestDispatcher("index.jsp").forward(request, response);

        System.out.println("book==>" + colls.size());

        //关闭
        out.flush();
        out.close();
    }


    /**
     * 购买
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();
        //////////////

        //id
        Integer id = Integer.parseInt(request.getParameter("id"));

//        业务数据
        BookDao dao = new BookDao();

        //获得所有的书数据
        Map<Integer, Book> books=dao.all();

        //每一本书
        Book book =dao.getBook(books, id);



        //跳转
        response.sendRedirect("cart.jsp");



        //关闭
        out.flush();
        out.close();
    }


}
