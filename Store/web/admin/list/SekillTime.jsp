<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/10/10
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
    request.setAttribute("Spage",Storepath);
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="../css/style.css">
</head>

<body class="listtable">
<div class="subject">
    <div class="filtrate">
        <form action="${Spage}/admin/BrandList.jsp" method="post">

            <div class="layui-inline">
                <label class="layui-form-label">输入查询</label>
                <div class="layui-input-inline">
                    <input type="text" name="sousuo" lay-verify="required|phone" value="${suo}" autocomplete="off" class="layui-input" placeholder="品牌名称/关键字">
                </div>
            </div>
            <div class="layui-inline">

                <div class="layui-input-inline">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">搜索</button>
                </div>
            </div>
        </form>

    </div>
    <div class="box_B">

        <a href="javascript:add2()" class="btn_B">添加</a>
        <a href="javascript:" class="btn_B">时间段</a>
    </div>
    <table class="layui-hide" id="test"></table>
    <script src="../../layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('table',function () {
            var table=layui.table;
            table.render({
                elem:'#test',
                url:'${Spage}/admin/SekillServlet?type=seckillTime',
                type:'post',
                cellMinWidth:100,
                page:true,
                cols:[[
                    {field:'id',title:'编号',align:'center',width:80},
                    {field:"name",title: "秒杀时间段名称",align:'center'},
                    {title: "活动状态",align:'center',width:120},
                    {title: "每日开始时间",align:'center',width:140,templet:function(d){
                            var date = new Date(d.openTime);
                            var YY = date.getFullYear() + '-';
                            var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                            var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
                            var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
                            var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
                            var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
                            return hh + mm + ss;
                        }},
                    {title: "每日结束时间",align:'center',width:140,templet:function(d){
                            var date = new Date(d.stopTime);
                            var YY = date.getFullYear() + '-';
                            var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                            var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
                            var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
                            var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
                            var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
                            return hh + mm + ss;
                        }},
                    {title: "启用",align:'center',width:120,templet:function(d) {
                            var isShow='<input type="checkbox"  name="isShow" lay-skin="switch" lay-filter="switchTest" >';
                            if(d.isOpen==1){
                                isShow='<input type="checkbox" checked="" name="isShow" lay-skin="switch" lay-filter="switchTest" >';
                            }
                            return isShow;
                        }},
                    {field:"count",title: "商品数量",align:'center',width:120},
                    {title: "操作",align: 'center',width:150,templet:function (d) {
                            var button1='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs upbtn">编辑</button>';
                            var button2='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs delbtn" >删除</button></td>';
                            return button1+button2;
                        }}
                ]]
            })
        });
        function add2() {

            layer.open({
                type: 2,
                title:'添加品牌',
                area: ['765px', '750px'],
                fixed: false, //不固定
                maxmin: true,
                content: 'tool/AddBrand.jsp'
            });
        }
        function formatDate(date) {
            var date = new Date(date.openDate);
            var YY = date.getFullYear() + '-';
            var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
            var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
            var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
            var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
            var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
            return YY + MM + DD +" "+hh + mm + ss;
        }
    </script>
</div>
</body>
</html>
