<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/8/21
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="sqlreq.*" %>
<%@ page import="serice.BrandSerice" %>
<%@ page import="entity.Brand" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
    pageContext.setAttribute("path",Storepath);
    user userinfo=(user)session.getAttribute("Userinfo");
    BrandSerice brandSerice=new BrandSerice();
    List<Brand> brandlist=brandSerice.getBrandList();
    request.setAttribute("brandList",brandlist);
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
    <script>var path='${path}';
        var name="";
        var brand_id="";
        var No="";
        var CommClass_id_1=0;
        var CommClass_id_2=0;
        var putaway=-1;
    </script>

</head>
<body class="listtable">
    <div class="subject">
        <div class="filtrate">
            <form action="${path}/admin/GoodsList.jsp" method="post" class="layui-form">

                <div class="layui-inline">
                    <label class="layui-form-label">商品名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="Commodity_name" value="${name}" class="layui-input" placeholder="品牌名称/关键字">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">商品货号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="Commodity_No" value="${No}" class="layui-input" placeholder="品牌名称/关键字">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">商品品牌：</label>
                    <div class="layui-input-inline">
                        <select name="brand_id"  >
                            <option value="0">请选择</option>
                            <c:forEach items="${requestScope.brandList}" var="br">
                                <option value="${br.id}"><c:out value="${br.brand_name}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <br>
                <div class="layui-inline">
                    <label class="layui-form-label">商品分类：</label>
                    <div class="layui-input-inline">
                        <select name="CommClass_id_1" lay-filter="aihao">
                            <option value="">请选择</option>
                            <%
                                out.print(((admin) userinfo).getFirstClass(0));
                            %>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">子分类：</label>
                    <div class="layui-input-inline">
                        <select name="CommClass_id_2" class="selectB" >
                            <option value="0">请选择</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">上架状态：</label>
                    <div class="layui-input-inline">
                        <select name="putaway" >
                            <option value="-1">全部</option>
                            <option value="1">上架</option>
                            <option value="0">下架</option>
                        </select>
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
        $(function () {
            sun();
            $("form").submit(function () {
                name=$("input[name='Commodity_name']").val();
                if(name == null){
                    name="";
                    alert("sss")
                }
                No=$("input[name='Commodity_No']").val();
                if(name == undefined){
                    No="";
                }
                brand_id=$("Select[name='brand_id']").val();
                CommClass_id_1=$("Select[name='CommClass_id_1']").val();
                CommClass_id_2=$("Select[name='CommClass_id_2']").val();
                putaway=$("Select[name='putaway']").val();
                sun();
                return false;
            })
        })
    </script>
<script>
    function sun(){
        layui.use('table', function(){
            var table = layui.table;
            var form=layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

            table.render({
                elem: '#Commd'
                ,url:'../topic?prol=getCommoditysinfo&name='+name+'&NO='+No+'&brand_id='+brand_id+'&CommClass_id_1='+CommClass_id_1+'&CommClass_id_2='+CommClass_id_2+'&putaway='+putaway
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
    }
    layui.use('form', function(){
        var form = layui.form;

        //各种基于事件的操作，下面会有进一步介绍
        form.on('select(aihao)', function(data){
            if(data.value>0){
                $.ajax({
                    url:'../topic',
                    type:'post',
                    data:{id:data.value,prol:'getClass'},
                    dataType:'text',
                    success:function (rst) {

                        if(rst.indexOf(">")>1){
                            $(".selectB").html(rst);
                            $(".class-2").show();
                            console.log(rst);
                        }else{
                            console.log(rst);
                            $(".selectB").html(rst);
                            $(".class-2").hide();
                        }

                        form.render('select'); //刷新select选择框渲染
                    },
                    error:function(xhr){alert('jsp页面有错误！'+xhr.responseText);}
                })
            }
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