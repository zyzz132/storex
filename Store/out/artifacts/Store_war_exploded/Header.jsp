<%@ page language="java" contentType="text/html;charset=utf-8" import="sqlreq.*" %>
<% String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
	pageContext.setAttribute("path",Storepath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
	<script src="${path}layui/layui.js" charset="utf-8"></script>
	<script src="${path}js/jquery-1.12.2.js"></script>
	<script src="${path}js/head.js"></script>
	<link rel="stylesheet" href="${path}layui/css/layui.css">
	<link rel="stylesheet" href="${path}css/style.css">

</head>
<body>
<div class="head">
	<div class="top_1">
		<div class="nav_top">
			<ul class="kjsc">
				<li><a href="${path}index.jsp">首页</a></li>
				<li><a href="">武汉</a></li>
			</ul>
			<ul class="loginInfo">
				<% 	user userinfo=(user)session.getAttribute("Userinfo");
					if(userinfo!=null){%>
					<li><a href="" id="user_info"><%=userinfo.get_name()%></a></li>
					<li><a href="">我的订单</a></li>
				<% 	}else{%>
					<li><a href="${path}login.jsp" id="login_a">登录</a></li>
					<li><a href="${path}admin/admin.jsp" >后台</a></li>
					<li><a href="${path}Register.jsp" id="reg_a">注册</a></li>
				<%	}%>

			</ul>
		</div>
	</div>
	<div class="top_2">
		<div class="logo"><img src="${path}images/logo.png" width=100%></div>
		
		<%@ include file="tool/searc.jsp" %>
		<%@ include file="tool/Shopping.jsp" %>
	</div>
	<%@ include file="nav.jsp" %>
</div>