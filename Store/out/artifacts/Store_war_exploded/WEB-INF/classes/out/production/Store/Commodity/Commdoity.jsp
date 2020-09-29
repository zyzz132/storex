<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/9/28
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ include file="../Header.jsp" %>

<div class="Commod_info">
    <div class="Commod_images"></div>
    <%--商品信息--%>
    <div class="Commod_typeInfo">
        <h2 class="Commod_title">商品名称</h2>
        <p class="Commod_subname">商品副标题</p>
        <p class="price">价格: <span>￥100.00</span>降价通知</p>
        <p class="adress">配 送 至: <select name="" id="">
            <option value="0">请选择收货地址</option></select></p>
        <div class="Commod_type">选择规格 <div class="guige">规格1</div><div class="guige">规格2</div></div>
        <div class="tool">
            <a href="javascript:" class="countbtn">-</a>
            <input type="text" value="1" class="count">
            <a href="javascript:" class="countbtn">+</a>
            <div class="AddStorev">加入购物车</div>
        </div>
    </div>

    <div class="tuijian"></div>
</div>
