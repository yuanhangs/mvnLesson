<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/25
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<img src="<%=request.getContextPath()%>/images/1.gif">
  <%
      //取出Cookie值
      Cookie[] cookies =request.getCookies();
      //循环
      for (int i = 0; i <cookies.length ; i++) {
          //判断是否是这个JSESSIONID
          if(!cookies[i].getName().equals("JSESSIONID")) {
              out.print(cookies[i].getName() + "=" + cookies[i].getValue() + "<br/>");
          }
      }
  %>
</body>
</html>
