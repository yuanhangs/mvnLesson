<%--
  Created by IntelliJ IDEA.
  User: 44401
  Date: 2020/3/24
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        body {
            /*background: coral;*/
        }

    </style>
</head>
<%--引入Jquery--%>
<script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
<%--外部JS--%>
<script type="text/javascript" src="js/login.js"></script>

<body>
<table>
    <caption><h1>用户登录</h1></caption>
    <td>
        <div id="nameDiv" style="display: inline"></div>
    </td>
    <tr>
        <td>用 户 名：</td>
        <td><input type="text" name="name" id="name"/>&nbsp;<span id="sp1">*</span></td>

    </tr>
    <tr>
        <td> 密&nbsp;码：</td>
        <td><input type="password" name="pass" id="pass"/>&nbsp;<span id="sp2">*</span></td>
    </tr>
    <tr >
        <%--这个按钮必须是普通按钮--%>
        <td colspan="2" ><input type="button" name="but" id="btn" value="登录"/></td>
    </tr>
</table>
</body>
</html>
