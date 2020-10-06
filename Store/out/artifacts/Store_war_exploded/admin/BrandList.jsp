<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/9/2
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=UTF-8");
    request.setAttribute("Spage",Storepath);
    String sousuo= request.getParameter("sousuo");
    if(sousuo!=null){
        request.setAttribute("suo",sousuo);
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="css/style.css">
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
        </div>
        <table class="layui-hide" id="test"></table>
        <script src="../layui/layui.js" charset="utf-8"></script>
        <script>
            layui.use('table',function () {
                var table=layui.table;
                table.render({
                    elem:'#test',
                    url:'${Spage}/admin/brand?suo=${suo}',
                    type:'post',
                    cellMinWidth:100,
                    page:true,
                    cols:[[
                        {field:'id',title:'编号',align:'center',width:80},
                        {field:"brand_name",title: "品牌名称",align:'center'},
                        {field: "brand_letter",title: "品牌首字母",align:'center',width:100},
                        {field: "sort",title: "排序",align:'center',width:80},
                        {title: "品牌制造商",align:'center',width:120,templet:function(d) {
                                var brand_manufacturer='<input type="checkbox"  name="brand_manufacturer" lay-skin="switch" lay-filter="switchTest" >';
                                if(d.brand_manufacturer==1){
                                    brand_manufacturer='<input type="checkbox" checked="" name="brand_manufacturer" lay-skin="switch" lay-filter="switchTest" >';
                                }
                                return brand_manufacturer;
                            }},
                        {title: "是否显示",align:'center',width:120,templet:function(d) {
                                var isShow='<input type="checkbox"  name="isShow" lay-skin="switch" lay-filter="switchTest" >';
                                if(d.isShow==1){
                                    isShow='<input type="checkbox" checked="" name="isShow" lay-skin="switch" lay-filter="switchTest" >';
                                }
                                return isShow;
                            }},
                        {title: "相关",align:'center',width:150,templet:function (d) {
                                var commdCount='商品： '+d.commodCount;
                                return commdCount;
                            }},
                        {title: "操作",align: 'center',width:150,templet:function (d) {
                                var button1='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs upbtn">编辑</button>';
                                var button2='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs delbtn" >删除</button></td>';
                                return button1+button2;
                            }}
                    ]]
                })
            })
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
        </script>
    </div>


</body>
</html>
