<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/8/19
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="sqlreq.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>易购物</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../js/jquery-1.12.2.js" type="text/javascript"></script>
    <script src="js/admin.js" type="text/javascript"></script>
    <style>
        .layui-tab-content{
            padding: 0px;
        }
        .layui-layout-admin .layui-body{bottom: 0px}
        .layui-tab-content{height: calc(100% - 61px);}
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">商品后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li> -->
        </ul>
        <% 	user userinfo=(user)session.getAttribute("Userinfo");
            if(userinfo!=null){
                if(userinfo.get_type()==3){
                %>
                    <ul class="layui-nav layui-layout-right">
                        <li class="layui-nav-item">
                            <a href="javascript:;">
                                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                                <span id="user_name"><%=userinfo.get_name()%></span>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="">基本资料</a></dd>
                                <dd><a href="">安全设置</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item"><a href="../index.jsp">网站首页</a></li>
                        <li class="layui-nav-item"><a href="../topic?prol=exit" id="ExitLogin">退出</a></li>
                    </ul>
            <%  }else { %>
                    <script>
                        alert("您不是管理人员，不能登录后台系统！");
                        location.href="login.jsp";
                    </script>
            <%}%>
        <% }else{%>
        <script>
            location.href="login.jsp";
        </script>
        <% }%>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a  href="#" class="site-demo-active" data-id="" data-type="CommclassList" >商品分类</a></dd>
                        <dd><a href="#" class="site-demo-active" data-type="GoodsList">商品管理</a></dd>
                        <dd><a href="#" class="site-demo-active" data-type="BrandList">品牌管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">订单记录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="Bill.jsp"  target="myiframe">订单记录</a></dd>
                        <dd><a href="javascript:;">订单设置</a></dd>
                        <dd><a href="">退货处理</a></dd>
                        <dd><a href="">退货处理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">营销</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#" class="site-demo-active" data-type="SskillList">秒杀活动列表</a></dd>
                        <dd><a href=""  target="myiframe">优惠券列表</a></dd>
                        <dd><a href=""  target="myiframe">品牌推荐</a></dd>
                        <dd><a href=""  target="myiframe">新品推荐</a></dd>
                        <dd><a href=""  target="myiframe">人气推荐</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="UserList.jsp" target="myiframe">用户信息</a></dd>
                        <dd><a href="javascript:;">用户订单</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="11">控制台</li>

            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">内容1</div>

            </div>
        </div>
    </div>
</div>
<script src="../layui/layui.js"></script>

<script>
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项'+ (Math.random()*1000|0) //用于演示
                    ,content: '内容'+ (Math.random()*1000|0)
                    ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
            },
            CommclassList:function () {
                var id= new Date().getTime();
                element.tabAdd('demo',{
                    title: '商品分类' //用于演示
                    ,content: '<iframe src="Commclassl.jsp" frameborder="0" width="100%" height="100%"></iframe>'
                    ,id: id//实际使用一般是规定好的id，这里以时间戳模拟下
                });
                element.tabChange('demo', id);
            },
            GoodsList:function () {
                var id= new Date().getTime();
                element.tabAdd('demo',{
                    title: '商品管理' //用于演示
                    ,content: '<iframe src="GoodsList.jsp" frameborder="0" width="100%" height="100%"></iframe>'
                    ,id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                element.tabChange('demo', id);
            },
            BrandList:function () {
                var id= new Date().getTime();
                element.tabAdd('demo',{
                    title: '商品分类' //用于演示
                    ,content: '<iframe src="BrandList.jsp" frameborder="0" width="100%" height="100%"></iframe>'
                    ,id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                element.tabChange('demo', id);
            },
            SskillList:function () {
                var id= new Date().getTime();
                element.tabAdd('demo',{
                    title: '秒杀管理' //用于演示
                    ,content: '<iframe src="list/SekillList.jsp" frameborder="0" width="100%" height="100%"></iframe>'
                    ,id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                element.tabChange('demo', id);
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('demo', '44'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
</script>
</body>
</html>
