<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/14/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户管理</title>
    <link href="css/layui.css" rel="stylesheet">
    <style>
        body{
            padding: 20px;
        }
        .layui-form-select dl{
            max-height:150px;
        }
    </style>
</head>
<body>
    <form class="layui-form layui-form-pane" lay-filter="user">
        <input type="hidden" name="userId"/>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" id="name" name="userName" autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-block">
                <select name="userType">
                    <option value="">---请选择---</option>
                    <option value="00">系统用户</option>
                    <option value="01">普通用户</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <input type="text" name="nickName" lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
    </form>
    <script src="js/layui.js"></script>
    <script>
        let layer,form,$;
        layui.use(['layer','form','jquery'],function(){
            layer=layui.layer, form=layui.form, $=layui.jquery;
            initData();
        });

        function initData(){
            console.log(parent.row);
            if(null!=parent.row){
                //因为layui.each内部的逻辑问题导致的所以要先深拷贝一份然后再去val
                //parent.row：表格行对象
                form.val('user',$.extend({}, parent.row||{}));
                $('#name').attr('readonly','readonly');
            }
        }

        function getData(){
            return form.val('user');
        }
    </script>
</body>
</html>
