<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/11/30
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>上传文件</title>
    <link href="css/layui.css" rel="stylesheet">
    <style>
        .span-line{
            color:blue
        }
        .span-line:hover{
            text-decoration:underline;
        }
        .layui-form-pane .layui-form-label {
            width: 161px !important;
        }
        .layui-form-pane .layui-input-block {
            margin-left: 161px !important;
        }
        .my-span-file {
            display: block;
            position: absolute;
            top: 0;
            float: left;
            margin-left: 95px;
            white-space: nowrap;
            width: calc(100% - 95px);
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body style="padding: 20px;">
<div style="padding-bottom: 8px;">
    <a class="span-line" href="language?loc=zh_CN"><spring:message code="chinese"/></a>&nbsp;|
    <a class="span-line" href="language?loc=en_US"><spring:message code="english"/></a>&nbsp;
</div>
<!-- 给容器追加 class="layui-form-pane"，即可显示为方框风格 -->
<form id="myform" class="layui-form layui-form-pane">
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="act"/></label>
        <div class="layui-input-block">
            <input type="text" name="userName" autocomplete="off" placeholder="请输入账号" lay-verify="required" class="layui-input" value="admin">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="pwd"/></label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入密码" lay-verify="required" autocomplete="off" class="layui-input" value="admin123">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="cardNo"/></label>
        <div class="layui-input-block">
            <input type="text" name="cardNo" autocomplete="off" placeholder="请输入身份证号" lay-verify="required" class="layui-input" value="500233199908081032">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="birthDay"/></label>
        <div class="layui-input-block">
            <input type="text" name="birthDay" id="mydate" lay-verify="required|date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="isAdmin"/></label>
        <div class="layui-input-block">
            <input type="radio" name="isAdmin" value="T" title="<spring:message code="yes"/>" checked>
            <input type="radio" name="isAdmin" value="F" title="<spring:message code="no"/>">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="headImage"/></label>
        <div class="layui-input-block">
            <label class="layui-input">
                <div style="line-height: 37px">
                    <i class="layui-icon layui-icon-upload"></i><spring:message code="chooseFile"/><span id="sp_file" class="my-span-file"></span><input id="ip_file" type="file" style="display: none;"  name="file" accept="image/*" title="Select Image">
                </div>
            </label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><spring:message code="showImage"/></label>
        <div class="layui-input-block" style="padding-left: 10px;">
            <img id="img_head" src="img/icon_default.png" height="150"/>
            <a class="span-line" href="download"><spring:message code="download"/></a>
        </div>
    </div>
    <div class="layui-form-item">
        <button type="button" class="layui-btn" lay-submit lay-filter="demo2" ><spring:message code="btnConfirm"/></button>
        <button type="reset" class="layui-btn layui-btn-primary"><spring:message code="btnReset"/></button>
    </div>
</form>

<!-- 请勿在项目正式环境中引用该 layui.js 地址 -->
<script src="js/layui.js"></script>
<script>
    layui.use(['form'], function(){
        var form = layui.form;
        var layer = layui.layer;
        var laydate = layui.laydate;
        var $ = layui.jquery;

        // 渲染
        laydate.render({
            elem: '#mydate'
        });

        $("#ip_file").change(function (){
            let file = this.files[0];
            console.log(file)
            $("#sp_file").html(file.name);
        });

        // 提交事件
        form.on('submit(demo2)', function(data){
            let field = data.field; // 获取表单字段值
            //var files = document.querySelector('#file_upload').files;
            let formData = new FormData($("#myform")[0]);
            /*formData.append("userName", field.userName);
            formData.append("pwd", field.pwd);
            formData.append("file", files[0]);*/
            /*方式二：使用jquery的ajax上传*/
            /*$.ajax({
                url:"upload",
                type:"POST",
                data: formData,
                processData: false, //当设置为true的时候，jquery ajax 提交的时候不会序列化 data，而是直接使用data
                contentType: false, //contentType设置为false，为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
                success:function (res){
                    if(res.data){
                        layer.msg(res.msg);
                        $("#img_head").attr("src", res.data);
                    } else
                        layer.msg("上传失败！");
                }
            });*/

            /*方式一：原生文件上传*/
            // 此处可执行 Ajax 等操作
            let xhr = new XMLHttpRequest();
            xhr.onreadystatechange=function (res){
                if(xhr.readyState === 4 && xhr.status === 200){
                    let result = null;
                    if(xhr.responseText)
                        result = JSON.parse(xhr.responseText);
                    if(result){
                        $("#img_head").attr("src", result.data );
                        layer.msg(result.msg);
                    } else
                        layer.msg("上传失败！");
                }
            }
            xhr.open("POST", "/upload", true);
            //xhr.setRequestHeader("Content-Type", "multipart/form-data;charset:utf-8");
            xhr.send(formData);
            return false; // 阻止默认 form 跳转
        });
    });
</script>

</body>
</html>
