<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/15/2023
  Time: 11:07 AM
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
    </style>
</head>
<body>
<%--1.查询区域--%>
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">用户名：</label>
        <div class="layui-input-inline">
            <input type="text" id="name" name="userName" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <button id="btn_search" type="button" class="layui-btn layui-btn-normal">
                <i class="layui-icon layui-icon-search"></i>
                查询
            </button>
            <button id="btn_add" type="button" class="layui-btn" style="display: none">新增</button>
        </div>
    </div>
</div>
<%--2.列表区域--%>
<table class="layui-hide" id="tbl_user" lay-filter="test"></table>
<%--3.模板内容--%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="js/layui.js"></script>
<script>
    var table,$,layer;
    var row;

    layui.use(['table','jquery','layer'], function(){
        table = layui.table
            ,layer=layui.layer
            ,$=layui.jquery;

        initTable();

        //为查询按钮设置点击事件
        $("#btn_search").click(function(){
            query();
        })

        //为新增按钮设置点击事件
        $("#btn_add").click(function(){
            row=null;
            edit('新增');
        })

    });

    //新增/修改的点击事件
    function edit(title){
        layer.open({
            type: 2,                    //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            title:title,
            area: ['50%', '70%'],   //宽高
            shadeClose: true,
            shade: 0.8,
            maxmin: true,
            skin: 'layui-layer-rim',    //样式类名
            content:  'toUserEdit', //书本编辑页面
            btn:['保存','关闭'],
            yes: function(index, layero){
                //调用子页面中提供的getData方法，快速获取子页面的form表单数据
                let data= $(layero).find("iframe")[0].contentWindow.getData();
                console.log(data);
                $.post('sysUser',
                    data,function(rs){
                        if(rs.code==="0"){
                            //关闭对话框
                            layer.closeAll();
                            //调用查询方法刷新数据
                            query();
                        }else{
                            layer.msg("操作失败！");
                        }
                    },'json');
            },
            btn2: function(index, layero){
                layer.closeAll();
            }
        });
    }

    function remove(data){
        console.log(data)
        layer.confirm('确认删除吗?', {icon: 3, title:'提示'}, function(index){
            let obj = {
                'ids': data
            }
            $.post('sysUser/remove', obj, function (res){
                if(res.data){
                    //调用查询方法刷新数据
                    query();
                }else{
                    layer.msg("删除失败！");
                }
            }, 'json');
            layer.close(index);
        });
    }

    //查询的点击事件
    function query(){
        //表格的重载
        table.reload('tbl_user', {
            where: { //设定异步数据接口的额外参数，任意设
                userName: $("#name").val()
            }
        }); //只重载数据
    }

    //将分页查询方法封装
    function initTable(){
        table.render({
            elem: '#tbl_user'
            ,url:'sysUser'
            ,method:'get'
            //,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,toolbar: 'default'
            ,defaultToolbar: ['filter', 'exports', 'print']
            ,request:{
                pageName: 'page', // 页码的参数名称，默认：page
                limitName: 'size' // 每页数据条数的参数名，默认：limit
            }
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{type: 'numbers', fixed: 'left'}
                ,{field:'deptName', title:'部门', sort: true}
                ,{field:'userName', title:'用户名'}
                ,{field:'userType', title:'类型', templet: function(res){
                    if(res.userType==="00")
                        return "系统用户";
                    else
                        return "普通用户";
                    }}
                ,{field:'status', title:'状态', templet: function(res){
                        if(res.status==="0")
                            return '<span class="layui-badge layui-bg-green">正常</span>';
                        else
                            return '<span class="layui-badge">禁用</span>';
                    }}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            row = obj.data;
            if(obj.event === 'del'){
                let ids = new Array();
                ids.push(row.userId);
                remove(ids);
            } else if(obj.event === 'edit'){
                edit('编辑');
            }
        });

        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data;
            switch(obj.event){
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        row = data[0];
                        edit('编辑');
                    }
                    break;
                case 'add':
                    row = null;
                    edit('新增');
                    break;
                case 'delete':
                    if(data && data.length>0){
                        let ids = new Array();
                        for(var i=0;i<data.length;i++){
                            ids.push(data[i].userId);
                        }
                        remove(ids);
                    } else{
                        layer.msg('请至少选择一行');
                    }
                    break;
            }
        });
    }
</script>
</body>
</html>
