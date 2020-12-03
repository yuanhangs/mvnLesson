package org.hlx.servlet;

import org.hlx.cart.Cart;
import org.hlx.cart.CartItem;
import org.hlx.dao.BookDao;
import org.hlx.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@WebServlet(name = "MyServlet", urlPatterns = "*.action")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //具体操作
        //获得提交路径  /save.action
        String path = request.getServletPath();
//        out.println(path);
        //截取文件名 save
        String fileName = path.substring(1, path.lastIndexOf("."));
//        out.println(fileName);
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

        //获得所有的数据
        Collection<Book> colls = BookDao.getAll();

        //保存数据
        request.setAttribute("books", colls);
        //跳转
        request.getRequestDispatcher("index.jsp").forward(request, response);


        System.out.println("book==>" + colls.size());


//        out.println("add !");
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
        //获得bookID
        String id = request.getParameter("id");
        //获得书
        Book book = BookDao.getBook(id);

        //会话对象（存放商品）
        HttpSession session = request.getSession();

        //获得购物车
        Cart cart = (Cart) session.getAttribute("cart");
        //判断第一次是否车空的
        if (cart == null) {
            cart = new Cart(); //车对象
            //保存车
            session.setAttribute("cart", cart);
        }

        //放入书
        addBook(book, cart);

        //跳转
        response.sendRedirect("cart.jsp");

//        out.println("update !");
        //关闭
        out.flush();
        out.close();
    }

    /**
     * 添加到购物车上
     *
     * @param book
     * @param cart
     */
    private void addBook(Book book, Cart cart) {
        //获得车上的所有的书
        Map<String, CartItem> items = cart.getItems();

        //书的每一项CartItem(key)(是否购买相同的书)
        CartItem item = items.get(book.getId());

        //判断没有购买过！
        if (item == null) {
            item = new CartItem(book, 1); //添加新的书

            //放入购物车
            items.put(book.getId(), item);
        } else {
            //买过，则数量+1
            item.setQuantity(item.getQuantity() + 1);
        }

    }


    /**
     * 购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();
        //////////////
        String param = request.getParameter("param");

        //购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //判断
        switch (param) {
            case "1":  //修改数量
                //获得参数值
                String id = request.getParameter("id");
                String quantity = request.getParameter("quantity");

                //购物车数量
                cart.getItems().get(id).setQuantity(Integer.parseInt(quantity));
                break;
            case "2":  //删除
                //获得参数值
                id = request.getParameter("id");
                //购物车数量
                cart.getItems().remove(id);
                break;
            case "3":  //清空
                //购物车数量
                cart.getItems().clear();
                break;
        }


        //跳转
        response.sendRedirect("cart.jsp");

        //关闭
        out.flush();
        out.close();
    }
}
