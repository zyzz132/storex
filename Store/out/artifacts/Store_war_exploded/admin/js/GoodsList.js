// $(function () {
//     $(".btn_B").click(function () {
//         layui.use('add',function () {
//             layer.open({
//                 type: 1,
//                 skin: 'layui-layer-rim', //加上边框
//                 //area: ['420px', '240px'], //宽高
//                 content: '<iframe src="tool/AddGood.jsp?prol=add" frameborder="0"></iframe>'
//             });
//         })
//         // location.href="tool/AddGood.jsp";
//     })
// })
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