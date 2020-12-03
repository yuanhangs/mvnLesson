<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'doCook.jsp' starting page</title>

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
 <a href="cook/show.jsp">查看已浏览过的图片</a>
	<%
		//获得?的参数值
		String id = request.getParameter("id");
		String strPath = request.getParameter("paths");

		//遍历
		for (int i = 1; i <= 6; i++) {

			//判断编号是否相等
			if (i == Integer.parseInt(id)) {
				//保存用户信息
				Cookie c1 = new Cookie("N"+id, strPath);

				//写入
				//c1.setMaxAge(5 * 60);

				response.addCookie(c1);
			}

		}
		
	%>
</body>
</html>
