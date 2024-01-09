<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/12/5
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/css/milligram.min.css">
</head>
<body>
<!-- 登录表单 -->
<form action="login" method="post">
    <label for="userName">账号：</label>
    <input type="text" id="userName" name="userName" value="admin"/><br/>

    <label for="password">密码：</label>
    <input type="password" id="password" name="password" value="123456"/><br/>

    <input type="submit" class="button-primary" value="登录"/>
</form>

</body>
</html>
