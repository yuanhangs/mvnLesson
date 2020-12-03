package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MyServlet", urlPatterns = {"/user"})
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        System.out.println("invoke doPost.....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        //列表数据
        List<String> list = Arrays.asList("何伟", "john", "mike");
        //
        int flag = 0;
        for (String str : list) {
            if (name.equals(str)) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        System.out.println(flag);
        //结果
        out.print(flag);

        //
        out.flush();
        out.close();
    }
}
