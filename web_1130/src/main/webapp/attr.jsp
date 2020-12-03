<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/30
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Session属性的操作</h3>
<%
    //保存数据
    session.setAttribute("username","林坤");
    //修改数据
    session.setAttribute("username","楼挺号");
    //移除
    session.removeAttribute("username");
%>
</body>
</html>
