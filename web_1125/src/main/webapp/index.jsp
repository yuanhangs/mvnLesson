<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/25
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.创建Cookie对象 (key,value) 只能字符串 ，servlet3.0版本或以下如果是中文值,会有异常；
    Cookie cookie = new Cookie("unames", "mike");

    //sevlet4.0可以存中文
    Cookie cookie2 = new Cookie("addr", "杭州市");

    //控制台打印数据:默认值：-1,直到浏览器关闭就结束
    System.out.println(cookie.getMaxAge());

    //设置生命周期 :秒为单位
    cookie2.setMaxAge(60);


    //2.添加
    response.addCookie(cookie);
    response.addCookie(cookie2);

    //3.跳转
    response.sendRedirect("show.jsp");

%>
</body>
</html>
