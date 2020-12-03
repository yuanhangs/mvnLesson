<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/25
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //初始化值
        Integer count=0;

        //获得值
        Integer num=(Integer)application.getAttribute("count");//0

        //判断
        if(num==null){
            count=1;
        }else{
            count = Integer.valueOf(num);
            //累计
            count++;
        }

        //设置值
        application.setAttribute("count",count);  //1
    %>

 占线人数：<%=application.getAttribute("count")%>
</body>
</html>
