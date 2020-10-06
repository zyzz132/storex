$(function () {

    var aggregate=0.00;
    $(".count").each(function () {
        var count =$(this).val();
        var price=$(this).parent().prev().children(".Commd-info-selling-price").children("span").text();
        $(this).parent().next().children("p").children().text(parseFloat(price*count).toFixed(2));

    })
    $(".minusCount").click(function () {
        if($(this).next().val()>1){
            $(this).next().val($(this).next().val()-1);
            var count =$(this).next().val();
            var price=$(this).parent().prev().children(".Commd-info-selling-price").children("span").text();
            $(this).parent().next().children("p").children().text(parseFloat(price*count).toFixed(2));
            jisuan(aggregate);
        }
    })
    $(".addCount").click(function () {
        aggregate=0.00;
        if($(this).prev().val()<20){
            $(this).prev().val(parseInt($(this).prev().val())+1);
            var count =$(this).prev().val();
            var price=$(this).parent().prev().children(".Commd-info-selling-price").children("span").text();
            $(this).parent().next().children("p").children().text(parseFloat(price*count).toFixed(2));
            jisuan(aggregate);
        }
    })
    //购物车选中事件
    $(".Commd-checkbox").children().change(function () {
        jisuan(aggregate);
    })
    $(".check-all").change(function () {
        if($(".check-all").is(':checked')){
            $(".chang").each(function () {
                $(this).prop("checked",true);
            })
            //$(".chang").attr("checked",true);
        }else{
            $(".chang").each(function () {
                $(this).prop("checked",false);
            })
            //$(".chang").attr("checked",false);
        }
        jisuan(aggregate);
    })
    $(".shopv-del").click(function () {
        layer.confirm('删除后不可恢复、确定操作吗？',{
            btn:['确定','取消']
        });
    })
})
//计算选中价格方法
function jisuan(aggregate) {
    aggregate=0.00
    $(".chang").each(function () {
        if($(this).is(':checked')){
            var price=$(this).parent().parent().children(".Commd-count-price").children("p").children().text();
            aggregate=parseFloat(parseFloat(aggregate)+parseFloat(price)).toFixed(2);
        }
    })
    $(".aggregate").text(aggregate);
}
function delShopv() {
    alert("asd")
}