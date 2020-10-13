<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/8/21
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="sqlreq.*" %>
<% String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
    pageContext.setAttribute("path",Storepath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="../js/jquery-1.12.2.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="css/style.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script>var path='${path}';</script>
</head>
<body class="listtable">
    <div class="subject">
        <div class="box_B">
            <span>数据列表</span>
            <a href="javascript:add2()" class="btn_B">添加</a>
        </div>

        <table id="Commd" lay-filter="test"></table>

    </div>


<script src="../layui/layui.js" charset="utf-8"></script>
<script src="js/GoodsList.js"></script>
<style>
	td>.layui-table-cell{height: 110px;}
	td>.layui-table-cell>p{padding: 5px;}
	th>.layui-table-cell{height: 41px;line-height: 41px;}
    .laytable-cell-1-0-0{line-height: 110px;}
</style>

<script>
    layui.use('table', function(){
        var table = layui.table;
        var form=layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        table.render({
            elem: '#Commd'
            ,url:'../topic?prol=getCommoditysinfo'
            ,method:'post'
            ,align:'center'		
            ,page: true 
            ,cols: [[
                {field:'Commodity_Id', width:80, title: 'ID', sort: true,align:'center'	}
				,{field:'CommImage_Url',width:140,title:'商品图片',style:"height:80px",templet:function(d){
					return "<img src='../upload/"+d.CommImage_Url+"' alt='' style='width:80px;height: 80px;'/>"},align:'center'	}
                ,{title: '商品名称',align:'center',templet:function(d){
                	return '<div style="padding: 5% 0px;"><p><a href="../Commod?Commd_id='+d.Commodity_Id+'"  target="_blank">'+d.Commodity_Name+'</a></p>'+'<p>品牌:'+d.brand_name+'</p></div>';
                }}
                ,{width:200, title: '副标题',align:'center',templet:function(d){
                	return '<div style="padding: 5% 0px;"><p>价格：￥'+d.selling_price+'</p>'+'<p>货号：'+d.Commodity_No+'</p></div>';
                }}
				,{width:150, title: '标签',align:'center'	,templet:function(d){
					var putawayHtml='<p>上架：<input type="checkbox" name="putaway" lay-skin="switch" lay-filter="putaway" ></p>';
					if(d.putaway==1){
						putawayHtml='<p>上架：<input type="checkbox" checked="" name="putaway" lay-skin="switch" lay-filter="putaway" ></p>';
					}
					var new_recommendHtml='<p>新品：<input type="checkbox" name="new_recommend" lay-skin="switch" lay-filter="new_recommend" ></p>';
					if(d.new_recommend==1){
						new_recommendHtml='<p>新品：<input type="checkbox" checked="" name="new_recommend" lay-skin="switch" lay-filter="new_recommend" ></p>';
					}
					var recommendHtml='<p>推荐：<input type="checkbox" name="recommend" lay-skin="switch" lay-filter="recommend" ></p>';
					if(d.recommend==1){
						recommendHtml='<p>推荐：<input type="checkbox" checked="" name="recommend" lay-skin="switch" lay-filter="recommend" ></p>';
					}
					return putawayHtml+new_recommendHtml+recommendHtml;
				}}
                ,{field:'sort', width:120,title: '排序', minWidth: 150,sort: true,align:'center'	}
                ,{width:80, title: 'SKU库',align:'center',templet:function(){
                    return '<div class="commd-sku"><button type="button" class="Commd-btn-1"><i></i><img src="../images/upsku.png" alt=""></button></div>';
                    }}
                ,{field:'market_price', width:135, title: '财富',align:'center'	 }
				,{title:'是否显示', width:130, templet:function(){
                    var button1='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs upbtn" >编辑</button>';
                    var button2='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs delbtn" onclick="del(this)">删除</button></td>';
                    return button1+button2;
				}}
            ]]
        	,limit:5
			,limits:[5,10,15,20]

        });
        //监听指定开关
        form.on('switch(putaway)', function(data){
            var value=this.checked ? 1 : 0;
            var id=this.parentNode.parentNode.parentNode.parentNode.firstChild.firstChild.textContent;
            $.getJSON('${path}admin/UpCommdStatic',{id:id,value:value,type:'putaway'},function (rst) {
                if(rst.code==1){
                    layer.msg('已更改');
                }else{
                    layer.msg('更改失败');
                }
            })
        });
        form.on('switch(new_recommend)', function(data){
            var value=this.checked ? 1 : 0;
            var id=this.parentNode.parentNode.parentNode.parentNode.firstChild.firstChild.textContent;
            $.getJSON('${path}admin/UpCommdStatic',{id:id,value:value,type:'new_recommend'},function (rst) {
                if(rst.code==1){
                    layer.msg('已更改');
                }else{
                    layer.msg('更改失败');
                }
            })
        });
        form.on('switch(recommend)', function(data){
            var value=this.checked ? 1 : 0;
            var id=this.parentNode.parentNode.parentNode.parentNode.firstChild.firstChild.textContent;
            $.getJSON('${path}admin/UpCommdStatic',{id:id,value:value,type:'recommend'},function (rst) {
                if(rst.code==1){
                    layer.msg('已更改');
                }else{
                    layer.msg('更改失败');
                }
            })
        });

    });
  //页面层
    function add2() {

        layer.open({
            type: 2,
            title:'添加品牌',
            area: ['765px', '750px'],
            fixed: false, //不固定
            maxmin: true,
            content: 'tool/AddGood.jsp?prol=add'
        });
    }

</script>

</body>
</html>