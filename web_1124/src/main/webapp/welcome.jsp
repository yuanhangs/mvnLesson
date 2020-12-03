<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/24
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  欢迎!~~~~ <h1>
      <%=session.getAttribute("uname")%><br/>
      <%=session.getAttribute("upass")%>

      <a href="out.jsp">退出</a>

      <%
          out.print("<p/>会话ID："+session.getId());
          out.print("会话周期："+session.getMaxInactiveInterval()+"秒");
          out.print("访问会话最后时间："+session.getLastAccessedTime());


      %>
  </h1>

</body>
</html>
