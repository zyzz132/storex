<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/5
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ include file="../Header.jsp" %>
<div class="shopv-section">
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">全部商品</li>

        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div>
                    <ul class="table-title">
                        <li class="Commd-checkbox"><input type="checkbox" > 全选</li>
                        <li class="Commd-info">商品信息</li>
                        <li class="Commd-price">单价</li>
                        <li class="Commd-count">数量</li>
                        <li class="Commd-count-price">金额</li>
                        <li class="operation">操作</li>
                    </ul>
                </div>
                <div class="shopv-Commds">
                    <ul>
                        <li>
                            <div class="Commd-checkbox">
                                <input type="checkbox">
                                <img src="../images/test1.jpg" alt="">
                            </div>
                            <div class="Commd-info">
                                <div class="Commd-info-title"><a href="">商品名称</a></div>
                                <div class="Commd-info-Class">商品型号</div>
                            </div>
                            <div class="Commd-price">
                                <div class="Commd-info-market-price">￥<span>1232</span></div>
                                <div class="Commd-info-selling-price">￥<span>1232</span></div>
                            </div>
                            <div class="tool Commd-count">
                                <a href="javascript:" class="countbtn">-</a>
                                <input type="text" value="1" class="count">
                                <a href="javascript:" class="countbtn">+</a>
                            </div>
                            <div class="Commd-count-price"><p>￥<span>200.00</span></p></div>
                            <div>
                                <p><a href="javascipt:">加入收藏</a></p>
                                <p><a href="javascipt:">删除</a></p>

                            </div>
                        </li>
                        <li>
                            <div class="Commd-checkbox">
                                <input type="checkbox">
                                <img src="../images/test1.jpg" alt="">
                            </div>
                            <div class="Commd-info">
                                <div class="Commd-info-title"><a href="">商品名称</a></div>
                                <div class="Commd-info-Class">商品型号</div>
                            </div>
                            <div class="Commd-price">
                                <div class="Commd-info-market-price">￥<span>1232</span></div>
                                <div class="Commd-info-selling-price">￥<span>1232</span></div>
                            </div>
                            <div class="tool Commd-count">
                                <a href="javascript:" class="countbtn">-</a>
                                <input type="text" value="1" class="count">
                                <a href="javascript:" class="countbtn">+</a>
                            </div>
                            <div class="Commd-count-price"><p>￥<span>200.00</span></p></div>
                            <div>
                                <p><a href="javascipt:">加入收藏</a></p>
                                <p><a href="javascipt:">删除</a></p>

                            </div>
                        </li><li>
                        <div class="Commd-checkbox">
                            <input type="checkbox">
                            <img src="../images/test1.jpg" alt="">
                        </div>
                        <div class="Commd-info">
                            <div class="Commd-info-title"><a href="">商品名称</a></div>
                            <div class="Commd-info-Class">商品型号</div>
                        </div>
                        <div class="Commd-price">
                            <div class="Commd-info-market-price">￥<span>1232</span></div>
                            <div class="Commd-info-selling-price">￥<span>1232</span></div>
                        </div>
                        <div class="tool Commd-count">
                            <a href="javascript:" class="countbtn">-</a>
                            <input type="text" value="1" class="count">
                            <a href="javascript:" class="countbtn">+</a>
                        </div>
                        <div class="Commd-count-price"><p>￥<span>200.00</span></p></div>
                        <div >
                            <p><a href="javascipt:">加入收藏</a></p>
                            <p><a href="javascipt:">删除</a></p>

                        </div>
                    </li>
                    </ul>

                </div>
                <div class="shopv-allC">
                    <ul>
                        <li><input type="checkbox" >全选</li>
                        <li><a href="">删除</a></li>
                        <li><a href="">清除失效商品</a></li>
                        <li><a href="">加入收藏</a></li>
                        <li><a href="">分享</a></li>
                    </ul>
                    <ul class="shopv-js">
                        <li>已选商品 <span>0</span>件</li>
                        <li>合计: <span>0.0</span></li>
                        <li><a href="">结算</a></li>
                    </ul>
                </div>
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

<%@ include file="../Footer.jsp" %>
