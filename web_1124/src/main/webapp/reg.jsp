<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/24
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="doReg.jsp" method="post">
      用户名:<input type="text" name="uname" /><br/>
      密&nbsp;码:<input type="password" name="upass" /><br/>
      爱&nbsp;好:<input type="checkbox" name="hobby" value="网游" />网游
      <input type="checkbox" name="hobby" value="看书" />看书
      <input type="checkbox" name="hobby" value="看电影" />看电影
      <br/>
      <input type="submit" name="sub" value="注册" />
  </form>
</body>
</html>
