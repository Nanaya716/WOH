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
    <title>修改商品</title>
    <link rel="stylesheet" href="/css/milligram.min.css">
</head>
<body>
<h2>修改商品</h2>

<!-- 表单 -->
<form action="/updateData" method="post" class="margin-bottom">
    <input type="hidden" name="Id" value="${productDetails.id}">

    <!-- 商品名 -->
    <label for="productName">商品名：</label>
    <input type="text" id="productName" name="name" value="${productDetails.name}" required>

    <!-- 商品编号 -->
    <label for="productCode">商品编号：</label>
    <input type="text" id="productCode" name="Code" value="${productDetails.code}" required>

    <!-- 成本价 -->
    <label for="purchasePrice">成本价：</label>
    <input type="text" id="purchasePrice" name="purchasePrice" value="${productDetails.purchasePrice}" required>

    <!-- 售价 -->
    <label for="salePrice">售价：</label>
    <input type="text" id="salePrice" name="salePrice" value="${productDetails.salePrice}" required>

    <!-- 库存 -->
    <label for="stockQuantity">库存：</label>
    <input type="text" id="stockQuantity" name="quantity" value="${stockDetails.quantity}" required>

    <input type="hidden" id="unit" name="unit" value="0" required>

    <!-- 提交按钮 -->
    <button type="submit" class="button-primary">提交修改</button>
</form>

<!-- 返回按钮 -->
<button class="button button-clear" onclick="history.back()">返回首页</button>
</body>
</html>
