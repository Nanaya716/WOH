


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/12/5
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>进销存管理系统</title>
    <link rel="stylesheet" href="/css/milligram.min.css">
</head>
<body>
<h2>首页</h2>
${sessionScope.user.userName}
${message}
<h1>进销存管理系统</h1>

<!-- 搜索框表单 -->
<form action="/search" method="get" class="margin-bottom">
    <input type="text" name="keyword" value="冰箱" placeholder="输入关键字进行搜索">
    <button type="submit" class="button">搜索</button>
</form>
<button class="button" onclick="window.location='/addData'">添加商品</button>
<table class="striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>商品名</th>
        <th>库存量</th>
        <th>进货记录详情</th>
        <th>出货记录详情</th>
        <th>商品详情</th>
        <th>操作</th>
        <!-- 可以根据需要添加其他列 -->
    </tr>
    </thead>
    <tbody>
    <!-- 使用循环动态生成表格行 -->
    <c:forEach var="data" items="${SearchResults}">
        <tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.quantity}</td>
            <td>
                <!-- 进货记录详情 -->
                <button class="button button-clear" onclick="window.location='/purchaseDetails?id=${data.id}'">查看进货详情</button>
            </td>
            <td>
                <!-- 出货记录详情 -->
                <button class="button button-clear" onclick="window.location='/shippingDetails?id=${data.id}'">查看出货详情</button>
            </td>
            <td>
                <!-- 商品详情 -->
                <button class="button button-clear" onclick="window.location='/productDetails?id=${data.id}'">查看商品详情</button>
            </td>
            <td>
                <!-- 修改 -->
                <button class="button button-clear" onclick="window.location='/purchaseOperateDetails?id=${data.id}'">进货</button>
                <button class="button button-clear" onclick="window.location='/salesOperateDetails?id=${data.id}'">出货</button>
                <button class="button button-clear" onclick="window.location='/updateDetails?id=${data.id}'">修改</button>
                <button class="button button-clear" onclick="window.location='/deleteData?id=${data.id}'">删除</button>
            </td>
            <td><!-- 操作按钮等 --></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
</body>
</html>
