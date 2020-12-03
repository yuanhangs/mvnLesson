<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'cart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/car.css">
	<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="js/shopping.js"></script>

</head>



<body style="text-align: center">
<div class="dv">
	<h1>我的购物车</h1>
	<table border="1" >
		<tr class="tr1">
			<td>商品名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>金额</td>
			<td>操作</td>
		</tr>
		<%--cart车=>items集合--%>
		<c:forEach var="entry" items="${cart.items}">
			<tr>
				<td>${entry.value.book.name}</td>
				<td>${entry.value.book.price}.00</td>
				<td>
					<input type="button" name="minus" value="-" onclick="minus(${entry.key},this);">

					<input type="number" value="${entry.value.quantity}" name="amount"
						   onblur="changeNumber(${entry.key},this)" id="amount" />

					<input type="button" name="plus" value="+" onclick="plus(${entry.key},this);">
				</td>
				<td>${entry.value.book.price * entry.value.quantity }.00</td>
				<td><a href="javascript:del(${entry.key})">删除</a>
				</td>
			</tr>
		</c:forEach>

		<tr>
			<td><a href="javascript:clears()">清空购物车</a>
			</td>
			<td><a href="all.action">继续购物</a>
			</td>
			<td><a href="#">下订单</a>
			</td>
			<td colspan="2">总价：￥${cart.total}.00元</td>
		</tr>
	</table>
</div>
</body>

</html>
