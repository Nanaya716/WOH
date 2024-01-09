<%--
  Created by IntelliJ IDEA.
  User: Nanaya
  Date: 2023/12/21
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" href="/css/milligram.min.css">
</head>
<body>
<h2>商品详情</h2>

<table class="striped">
    <thead>
    <tr>
        <th>商品ID</th>
        <th>商品名</th>
        <th>商品编号</th>
        <th>成本价</th>
        <th>售价</th>
        <th>库存</th>
    </tr>
    </thead>
    <tbody>
    <!-- 使用循环动态生成表格行 -->
        <tr>
            <td>${productDetails.id}</td>
            <td>${productDetails.name}</td>
            <td>${productDetails.code}</td>
            <td>${productDetails.purchasePrice}</td>
            <td>${productDetails.salePrice}</td>
            <td>${stockDetails.quantity}</td>
        </tr>
    </tbody>
</table>

<!-- 返回按钮 -->
<button class="button button-clear" onclick="history.back()">返回首页</button>
</body>
</html>
