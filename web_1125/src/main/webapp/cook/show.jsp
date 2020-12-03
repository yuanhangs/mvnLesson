<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="cook/cook.jsp">back</a><p/>
   <%
      //获得保存的cookie
      Cookie[] cookies = request.getCookies();
      
      //遍历数据
      for(int i=0;i<cookies.length-1;i++){
      
      
      %>
      <%= cookies[i].getValue()%>
      <img border="0" src="<%= cookies[i].getValue()%>">
      <%
      //解码
     //   out.println(cookies[i].getName()+":"+ cookies[i].getValue()  +"<p/>");
      }
    %>
  </body>
</html>
