package sjc.servlet;


import sjc.biz.UserinfoBiz;
import sjc.entity.Userinfo;
import sjc.until.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UserinfoServlet", urlPatterns = "*.do")
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class UserinfoServlet extends HttpServlet {
    /**
     * 必须调用
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求路径   /add.do
        String path = request.getServletPath();

        //截取 add
        String pathName = path.substring(1, path.lastIndexOf("."));

        //利用反射机制
        try {
            //pathName方法名; 后面2个是参数
            Method method = getClass().getDeclaredMethod(pathName, HttpServletRequest.class, HttpServletResponse.class);

            //调用
            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭
        out.flush();
        out.close();

    }


    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        StringBuffer buffer=new StringBuffer();

//        String str=uploadSingle(request);

        //1.获得part对象集合(多个)
        Collection<Part> parts = request.getParts();

        //2.循环 itco
        for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext(); ) {

            //获得part对象
            Part part = iterator.next();

            uploadSingle2(request, part);
            //调用方法
//           buffer.append(uploadSingle2(request, part)).append(",");
        }


        //请求数据
        String name = request.getParameter("textfield");
        String pwd = request.getParameter("textfield2");


        //封装数据
        Userinfo user = new Userinfo(name, pwd);
        user.setPicture(buffer.toString());

        System.out.println(user);

        //业务对象
//        UserinfoBiz biz = new UserinfoBiz();
//
//        //调用业务方法
//        int count = biz.register(user);
//
//        //判断
//        if (count > 0) {
//            response.sendRedirect("index.html");
//        } else {
//            response.sendRedirect("addUser.html");
//        }

        //关闭
        out.flush();
        out.close();

    }

    private String uploadSingle2(HttpServletRequest request, Part part) throws IOException, ServletException {
        //中文处理使用过滤器
        //1>上传的文件保存在Part对象
//        Part part =request.getPart("myfile");

        //2>头信息文件 form-data; name="myfile"; filename="main.png"
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);

        //3.截取上传文件的扩展名 .jpg,.txt, docx...
        String suffix = header.substring(header.lastIndexOf("."), header.length()-1);
        System.out.println("stuf==>"+suffix);


        //4)随机的生存一个32的字符串
        String fileName = UUID.randomUUID() + suffix;
        System.out.println(fileName);

        //5）输入流对象
        InputStream is = part.getInputStream();
        //6)动态获取服务器的路径
        String filePath = request.getServletContext().getRealPath("/upload");
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //7.拼接完整的路径
        String path = filePath + "/" + fileName;
        System.out.println(path);

        //8)写入
        FileOutputStream fos = new FileOutputStream(path);
        byte[] bys = new byte[1024];
        int length = 0;
        while ((length = is.read(bys)) != -1) {
            fos.write(bys, 0, length);
        }
        //关闭流
        fos.close();
        is.close();

        return fileName;
    }

    private String uploadSingle(HttpServletRequest request) throws IOException, ServletException {
        //中文处理使用过滤器
        //1>上传的文件保存在Part对象
        Part part = request.getPart("myfile");

        //2>头信息文件 form-data; name="myfile"; filename="main.png"
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);

        //3.截取上传文件的扩展名 .jpg,.txt, docx...
        String suffix = header.substring(header.lastIndexOf("."), header.length() - 1);
        System.out.println(suffix);

        //4)随机的生存一个32的字符串
        String fileName = UUID.randomUUID() + suffix;
        System.out.println(fileName);

        //5）输入流对象
        InputStream is = part.getInputStream();
        //6)动态获取服务器的路径
        String filePath = request.getServletContext().getRealPath("/upload");
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //7.拼接完整的路径
        String path = filePath + "/" + fileName;
        System.out.println(path);

        //8)写入
        FileOutputStream fos = new FileOutputStream(path);
        byte[] bys = new byte[1024];
        int length = 0;
        while ((length = is.read(bys)) != -1) {
            fos.write(bys, 0, length);
        }
        //关闭流
        fos.close();
        is.close();

        return fileName;
    }
//    protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//
//        //中文处理使用过滤器
//
//        //请求数据
//        String name = request.getParameter("textfield");
//        String pwd = request.getParameter("textfield2");
//
//        //封装数据
//        Userinfo user = new Userinfo(name, pwd);
//
//        //业务对象
//        UserinfoBiz biz = new UserinfoBiz();
//
//        //调用业务方法
//        int count = biz.register(user);
//
//        //判断
//        if (count > 0) {
//            response.sendRedirect("index.html");
//        } else {
//            response.sendRedirect("addUser.html");
//        }
//
//        //关闭
//        out.flush();
//        out.close();
//
//    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //请求数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPass");

        //封装数据
        Userinfo user = new Userinfo(name, pwd);

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

        //调用业务方法
        int count = biz.login(user);

        //判断
        if (count > 0) {
            response.sendRedirect("welcome.html");
        } else {
            response.sendRedirect("index.html");
        }

        //关闭
        out.flush();
        out.close();

    }

//    /**
//     * 显示所有数据
//     *
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//
//        //中文处理使用过滤器
//
//        //业务对象
//        UserinfoBiz biz = new UserinfoBiz();
//
//        //调用业务方法
//        List<Userinfo> list = biz.all();
//
//        //保存数据(request ,使用转发)
//        request.setAttribute("lists", list);
//        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
//
//        //关闭
//        out.flush();
//        out.close();
//
//    }

    /**
     * 显示所有数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

        //设置当前页
//        int currentPage=1;
        String string = request.getParameter("pageIndex");
        int currentPage = (string == null) ? (1) : (Integer.parseInt(string));

        //总个数
        int count = biz.all().size();


        //每页个数
        int pageSize = 5;

        //封装对象
        PageInfo pageInfo = new PageInfo(count, pageSize, currentPage);

        //注意计算总页数
        pageInfo.setCount(count);


        //调用业务方法
        List<Userinfo> list = biz.getPageInfo(pageInfo);

        //保存数据(request ,使用转发)
        request.setAttribute("lists", list);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);

        //关闭
        out.flush();
        out.close();

    }

    /**
     * 更新
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //中文处理使用过滤器

        //请求数据
        String strId = request.getParameter("userID");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");

        //注意是2个提交按钮，获取参数值
        String sub = request.getParameter("Submit");


        //变量
        int count = 0;
        UserinfoBiz biz = null;

        //判断
        if ("修改".equals(sub)) {
            //封装数据
            Userinfo user = new Userinfo(Integer.parseInt(strId), name, pwd);
            //业务对象
            biz = new UserinfoBiz();
            //调用业务方法
            count = biz.update(user);
        } else {  //删除
            //业务对象
            biz = new UserinfoBiz();
            //调用业务方法
            count = biz.del(Integer.parseInt(strId));
        }

        //判断
        if (count > 0) {
            response.sendRedirect("all.do");
        } else {
            response.sendRedirect("userInfo.jsp");
        }

        //关闭
        out.flush();
        out.close();

    }


}
