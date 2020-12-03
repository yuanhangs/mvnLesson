<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/24
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%  //小脚本

       request.setCharacterEncoding("utf-8");

      //获取请求的参数值<input type="text" name="uname" />
       String uname = request.getParameter("uname");
       String upwd = request.getParameter("upass");

       //只有复选框是多选
       String[] hobbys = request.getParameterValues("hobby");
       //判断
       if(hobbys!=null) {
           //循环
           for (String str : hobbys) {
               out.println(str + " ");
           }
       }
       out.print("<br/>");
       //显示数据
       out.println(uname+"<p/>");
       out.println(upwd);


       //保存数据
       session.setAttribute("uname",uname);
       session.setAttribute("upass",upwd);

       //5分钟=5*60；
       //1分钟=1*60；
       session.setMaxInactiveInterval(60);

       response.sendRedirect("welcome.jsp");


   %>
</body>
</html>
