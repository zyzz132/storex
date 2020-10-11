<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/9/28
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ include file="../Header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="Commod_info">
    <div class="Commod_images">
        <div class="CommdImagK"><img src="${requestScope.path}upload/${requestScope.commd.imageList.get(0).commImage_Url}" alt=""></div>
        <ul class="Commdimaglist">
            <c:forEach items="${requestScope.commd.imageList}" var="Cimg">
                <li><img src="${requestScope.path}upload/${Cimg.commImage_Url}" alt=""></li>
            </c:forEach>

        </ul>
    </div>
    <%--商品信息--%>
    <div class="Commod_typeInfo">
        <h2 class="Commod_title">${requestScope.commd.commodity_Name}</h2>
<%--        <p class="Commod_subname">商品副标题</p>--%>
        <div class="price">
            <p class="original"><span>原价 </span><span>￥${requestScope.commd.market_price}</span></p>
            <p class="cuoshou"><span>秒杀价 </span><span>￥100.00</span></p>
            <p class="cuoshou"><span>价格</span><span>￥${requestScope.commd.selling_price}</span></p>
        </div>
        <div class="liouliang">
            <ul>
                <li>累计销量 <span class="liouliang-value">0</span></li>
                <li>浏览次数 <span class="liouliang-value">0</span></li>
                <li>累计评论 <span class="liouliang-value">0</span></li>
            </ul>
        </div>


        <div class="Commod_type">选择规格
            <c:forEach items="${requestScope.commd.commTypeList}" var="Ctype">
                <div class="guige">${Ctype.commType_Name}</div>
            </c:forEach>

        </div>
        <div class="tool">数量
            <a href="javascript:" class="countbtn">-</a>
            <input type="text" value="1" class="count">
            <a href="javascript:" class="countbtn">+</a>

        </div>
        <div class="buy-Storev">
            <a href="javascipt:" class="buy">立即购买</a>
            <a href="javascipt:" class="AddStorev">加入购物车</a>
        </div>

    </div>


</div>
<div class="Commod-dtls">
    <!--左侧推荐-->
    <div class="layui-col-md6 left-rcmd">
        <div class="layui-card">
            <div class="layui-card-header" style="background-color: #f2f2f2">好品推荐</div>
            <div class="layui-card-body">
                卡片式面板面板通常用于非白色背景色的主体内<br>
                从而映衬出边框投影
            </div>
        </div>
    </div>

    <!--商品详情与评论 -->
    <div class="Commod-dtl-comment">
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
                <li class="layui-this">详情</li>
                <li>评论</li>
                <li>权限分配</li>
                <li>商品管理</li>
                <li>订单管理</li>
            </ul>
            <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show">${requestScope.commd.particulars.particulars}</div>
                <div class="layui-tab-item">2</div>
                <div class="layui-tab-item">3</div>
                <div class="layui-tab-item">4</div>
                <div class="layui-tab-item">5</div>
                <div class="layui-tab-item">6</div>
            </div>
        </div>
    </div>
</div>
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
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('demo', '44'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
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
<script src="js/Commodity.js"></script>
<%@ include file="../Footer.jsp" %>
