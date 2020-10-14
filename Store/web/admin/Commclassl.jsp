<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <script src="../js/jquery-1.12.2.js"></script>
  <link rel="stylesheet" href="css/style.css">
  <script>var path='${path}';</script>
</head>
<body class="listtable">
  <div class="subject">
    <div class="tool box_B">

      <a href="javascript:add2()" class="btn_B">添加</a>
    </div>

    <table class="layui-hide" id="test"></table>
  </div>

 
<script type="text/html" id="switchTpl">
  <!-- 这里的 checked 的状态只是演示 -->
  <input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="是|否" lay-filter="sexDemo" {{ d.id == 10003 ? 'checked' : '' }}>
</script>
 
<script type="text/html" id="checkboxTpl">
  <!-- 这里的 checked 的状态只是演示 -->
<%--  <input type="checkbox" name="lock" value="{{d.id}}" title="锁定" lay-filter="lockDemo" {{ d.id == 10006 ? 'checked' : '' }}>--%>
</script>

              
<script src="../layui/layui.js" charset="utf-8"></script>
  <script src="js/commclass.js"></script>
<script>
  sun();
function sun() {
  layui.use('table', function(){
    var table = layui.table
            ,form = layui.form;

    table.render({
      elem: '#test'
      ,url:'../topic?prol=getCommClass'
      ,method:'post'
      ,cellMinWidth: 100
      ,cols: [[
        {field:'CommClass_Id', title:'ID', width:100, unresize: true, sort: true,align:'center'}
        ,{field:'CommClass_Name', title:'用户名', templet: '#usernameTpl',align:'center'}
        ,{field:'commodiyCount', title:'商品数量',align:'center'}
        ,{field:'parentClass', title: '级别',align:'center', minWidth:120, sort: true}
        ,{title:'是否显示',align:'center', width:85, templet:function (d) {
            var isShow='<input type="checkbox" name="isShow" lay-skin="switch" lay-filter="switchTest" >';
            if(d.isShow=="是"){
              isShow='<input type="checkbox" checked="" name="isShow" lay-skin="switch" lay-filter="switchTest" >'
            }
            return isShow;
          }}
        ,{field: 'sort',title: '排序',width: 100,align:'center'}
        ,{title: '操作',width: 140,align: "center",templet: function () {
            var button1='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs upbtn">编辑</button>';
            var button2='<button type="button" class="layui-btn layui-btn-primary layui-btn-xs delbtn" onclick="del(this)">删除</button></td>';
            return button1+button2;
          }}
      ]]
      ,page: true
    });

  });
}
</script>

</body>
</html>