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
    <title>进货详情</title>
    <link rel="stylesheet" href="/css/milligram.min.css">
</head>
<body>
<h2>进货详情</h2>

<!-- 显示进货详情数据 -->
<table class="striped">
    <thead>
    <tr>
        <th>商品ID</th>
        <th>购买时间</th>
        <th>数量</th>
        <th>单价</th>
        <th>总价</th>
        <th>收货人</th>
        <th>购买人</th>
    </tr>
    </thead>
    <tbody>
    <!-- 使用循环动态生成表格行 -->
    <c:forEach var="purchaseData" items="${purchaseResults}">
        <tr>
            <td>${purchaseData.productId}</td>
            <td>${purchaseData.purchaseTime}</td>
            <td>${purchaseData.quantity}</td>
            <td>${purchaseData.unitPrice}</td>
            <td>${purchaseData.totalPrice}</td>
            <td>${purchaseData.supplierName}</td>
            <td>${purchaseData.purchaserName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- 返回按钮 -->
<button class="button button-clear" onclick="history.back()">返回首页</button>
</body>
</html>
