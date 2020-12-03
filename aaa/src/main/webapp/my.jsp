<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/29
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前共有<%=application.getAttribute("count").toString()%>人在线<br>
<a href="logout">登出</a>


<%

//    out.println("ServletContextListen....");
    //添加一个属性
    application.setAttribute("uname","Tim");
    //修改一个属性
    application.setAttribute("uname","John");
    //删除一个属性
    application.removeAttribute("uname");



%>
</body>
</html>
