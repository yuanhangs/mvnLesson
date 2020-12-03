<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/26
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%--欢迎~~~ <h3><%=session.getAttribute("uname")%></h3>--%>

<h5 style="color:blue;"><%=request.getAttribute("unames")%></h5>
<h5 style="color:brown;"><%=application.getAttribute("app")%></h5>
</body>
</html>
