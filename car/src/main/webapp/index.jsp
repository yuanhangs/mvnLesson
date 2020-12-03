<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--要加入这个EL--%>
<%@ page isELIgnored="false" %>
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

<title>显示所有的商品</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%--外部样式--%>
<link rel="stylesheet" type="text/css" href="css/index2.css">


<%--脚本--%>
<script type="text/javascript">
    function buy(id){
        document.location.href = "${pageContext.request.contextPath}/buy.do?id="+id;
    }
</script>

	<%
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);
		response.flushBuffer();
	%>
</head>

<body style="text-align: center">


<div class="dv">
	<h1>商品列表</h1>
	<table border="0" >
		<tr>
			<th>图片</th>
			<th>名称</th>
			<th>作者</th>
			<th>价格</th>
			<th>购买</th>
		</tr>
		<%--等同于foreach循环--%>
 		<c:forEach var="book" items="${books}">
			<tr align="center">
				<td><img src="imgs/${book.picture}" id="imgs"/></td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td><input type="button" value="购买" onclick="buy(${book.id})"  id="btn"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>


</body>
</html>
