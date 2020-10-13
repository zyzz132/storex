//页面层
function add2() {

    layer.open({
        type: 2,
        title:'添加商品分类',
        area: ['765px', '750px'],
        fixed: false, //不固定
        maxmin: true,
        content: 'tool/AddClass.jsp',
        end:function () {
            sun();
        }
    });

}

function del(node) {
    var id=node.parentNode.parentNode.parentNode.firstChild.firstChild.textContent;
    layer.confirm('您确定要删除该分类？'+id, {
        btn: ['确定','取消'] //按钮
    }, function(){

        $.ajax({
            url:path+'admin/DelCommdClass',
            type:'post',
            data:{id:id},
            dataType:'JSON',
            success:function (rst) {
                console.log(rst);
                if(rst.code==1){
                    layer.msg('已删除', {icon: 1});

                    sun();
                }else{
                    layer.msg('删除失败', {icon: 1});
                }

            },
            error:function(xhr){layer.msg('接口异常', {icon: 1});}

        })

    }, function(){
    });
}