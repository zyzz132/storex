
function del(node) {
    var id=node.parentNode.parentNode.parentNode.firstChild.firstChild.textContent;
    layer.confirm('您确定要删除该商品id？'+id, {
        btn: ['确定','取消'] //按钮
    }, function(){

        $.ajax({
            url:path+'admin/DelCommd',
            type:'post',
            data:{id:id},
            dataType:'JSON',
            success:function (rst) {
                console.log(rst);
                if(rst.code==1){
                    layer.msg('已删除', {icon: 1});

                    var table = layui.table;

                    //执行渲染
                    table.reload('testReload', {elem:'#Commd'})
                }else{
                    layer.msg('删除失败', {icon: 1});
                }

            },
            error:function(xhr){layer.msg('接口异常', {icon: 1});}

        })

    }, function(){
    });
}
function add() {
    alert("add");
    layui.use('add',function () {
        layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            //area: ['420px', '240px'], //宽高
            content: '<iframe src="tool/AddGood.jsp?prol=add" frameborder="0"></iframe>'
        });
    })
}
