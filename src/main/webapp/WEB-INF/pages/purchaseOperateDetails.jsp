<%--
  Created by IntelliJ IDEA.
  User: Nanaya
  Date: 2023/12/21
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>确认进货记录</title>
    <link rel="stylesheet" href="/css/milligram.min.css">
</head>
<body>
<h2>确认进货记录</h2>

<!-- 表单 -->
<form action="/addPurchaseRecords" method="post" class="margin-bottom">
    <input type="hidden" id="productId" name="productId" value="${productsData.id}" required>
    <!-- 商品名 -->
    <label for="name">商品名：</label>
    <input type="text" id="name" name="name" value="${productsData.name}" required readonly>

    <!-- 商品编号 -->
    <label for="code">商品编号：</label>
    <input type="text" id="code" name="code" value="${productsData.code}" required readonly>

    <!-- 成本价 -->
    <label for="unitPrice">成本价：</label>
    <input type="text" id="unitPrice" name="unitPrice" value="${productsData.purchasePrice}" required readonly>

    <!-- 售价 -->
    <label for="salePrice">售价：</label>
    <input type="text" id="salePrice" name="salePrice" value="${productsData.salePrice}" required readonly>

    <!-- 总价 -->
    <label for="totalPrice">进货总价：</label>
    <input type="text" id="totalPrice" name="totalPrice" value="" required readonly>



    <!-- 收货人 -->
    <label for="supplierName">请填写收货人：</label>
    <input type="text" id="supplierName" name="supplierName" value="" required >

    <!-- 买入人 -->
    <label for="purchaserName">请填写买入人：</label>
    <input type="text" id="purchaserName" name="purchaserName" value="" required >

    <!-- 库存 -->
    <label for="quantity">请填写进货数量：</label>
    <input type="text" id="quantity" name="quantity" value="" required oninput="calculateTotalPrice()">

    <!-- 提交按钮 -->
    <button type="submit" class="button">确认进货记录</button>
</form>

<script>
    function calculateTotalPrice() {
        // 获取进货数量和成本价
        var quantity = document.getElementById('quantity').value;
        var unitPrice = document.getElementById('unitPrice').value;

        // 计算总价
        var totalPrice = quantity * unitPrice;

        // 更新总价输入框的值
        document.getElementById('totalPrice').value = totalPrice;
    }
</script>
<!-- 返回按钮 -->
<button class="button button-clear" onclick="history.back()">返回首页</button>
</body>
</html>
