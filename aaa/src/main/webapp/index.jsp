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
        body{
            /*background: coral;*/
        }

    </style>
</head>
<%--引入Jquery--%>
<script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
<%--外部JS--%>
<%--<script type="text/javascript" src="js/index2.js"></script>--%>
<script type="text/javascript" src="js/indexPost.js"></script>
<%--<script type="text/javascript" src="js/indexUser.js"></script>--%>
<%--<script type="text/javascript" src="js/indexUserGet.js"></script>--%>
<%--<script type="text/javascript" src="js/indexUserJson.js"></script>--%>

<body>
<table>
    <tr>
        <td>用 户 名：</td>
        <td><input type="text" name="name" id="name"/>&nbsp;<span style="color:crimson">*</span></td>
        <td>
            <div id="nameDiv" style="display: inline"></div>
        </td>
    </tr>
</table>
</body>
</html>
