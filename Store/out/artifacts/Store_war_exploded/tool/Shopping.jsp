<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/8/20
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<style type="text/css">
    .Shopping_box{
        position: relative;
    }
    .sp1{
        position: absolute;
        z-index: 10;
        width: 310px;
        left: -210px;

        background: white;
        box-shadow: 0px 0px 5px rgb(169 145 145);
    }
    .sp1 li{
        padding: 5px 8px ;
        border-top: 1px solid #ddd;
    }
    .sp1 li:hover{
        background: #e6e6e6;
    }
    .spname{
        display:inline-block;
        width: 155px;
        overflow: hidden;
        padding: 6px;
        vertical-align: middle;
        font-size: 3px;
        color: gray;
    }
    .spd{
        display: inline-block;
        padding: 6px;
        vertical-align: middle;
    }
    .spd p{
        text-align: right;
    }
    .spd span{
        text-align: right;
        color: red;
    }
    h4{
        padding: 5px;
        margin-bottom: 5px;
        color: #c1c0bd;
    }
    .ck{
        text-align: center;
        line-height: 50px;
        border-top: 1px solid #ddd;
    }
    .ck a{
        color: orange;
    }
    .money a{
        color: black;
    }
    .money a:hover{
        color: red;
    }

</style>
<div class="Shopping_box">
    <div class="Shopping_btn">购物车
        <p>0</p>
    </div>
    <div  class="sp1">
        <h4>最新加入的商品:</h4>
        <ul>

            <%--<li>--%>
            <%--<a><img src="images/oppoerji.3.jpg" width="40px" height="40px"/><a><span class="spname">耳机啊哈哈哈哈哈哈哈哈哈哈哈哈</span></a>--%>
            <%--<div class="spd"><span>￥100.00*x</span>--%>
            <%--<p class="money"><a href="#"> 删除商品</a></p></div>--%>

            <%--</a>--%>

            <%--</li>--%>
            <%--<li>--%>
            <%--<a><img src="images/oppoerji.3.jpg" width="40px" height="40px"/><a><span class="spname">耳机啊哈哈哈哈哈哈哈哈哈哈哈哈</span></a>--%>
            <%--<div class="spd"><span>￥100.00*x</span>--%>
            <%--<p class="money"><a href="#"> 删除商品</a></p></div>--%>

            <%--</a>--%>

            <%--</li>--%>
            <%--<li>--%>
            <%--<a><img src="images/oppoerji.3.jpg" width="40px" height="40px"/><a><span class="spname">耳机啊哈哈哈哈哈哈哈哈哈哈哈哈</span></a>--%>
            <%--<div class="spd"><span>￥100.00*x</span>--%>
            <%--<p class="money"><a href="#"> 删除商品</a></p></div>--%>

            <%--</a>--%>

            <%--</li>--%>

        </ul>
        <p class="ck"><a>查看全部</a></p>
    </div>

</div>
<script>
    $(function () {
        $(".Shopping_box").mousemove(function () {
            $.getJSON("http://localhost:8080/Store/Headershop",function (ls) {
                console.log(ls[0].commd);
                var html="";
                for(var i=0;i<ls.length;i++){

                    var n='<li>\n' +
                        '            <a><img src="images/oppoerji.3.jpg" width="40px" height="40px"/><a><span class="spname">'+ls[i].commd.commodity_Name+'</span></a>\n' +
                        '                <div class="spd"><span>￥100.00*x</span>\n' +
                        '                    <p class="money"><a href="#"> 删除商品</a></p></div>\n' +
                        '\n' +
                        '            </a>\n' +
                        '\n' +
                        '        </li>';
                    html+=n;

                }
                $(".sp1>ul").html(html);
            })
            $(".sp1").show();
        }).mouseout(function () {
            $(".sp1").hide();
        })
        $(".sp1").hide();
    })

</script>