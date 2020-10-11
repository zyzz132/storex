<%@ page language="java" contentType="text/html;charset=utf-8"%>
<style>
.layui-carousel {
	width: 1200px;
	height: 440px;
}
</style>
<div class="layui-carousel" id="test10">
	<div carousel-item="">
		<div>
			<img src="images/1.png" width="1200px">
		</div>
		<div>
			<img src="images/2.png">
		</div>
		<div>
			<img src="images/3.jpg" width="1200px">
		</div>
		<div>
			<img src="images/4.png">
		</div>
		<div>
			<img src="images/5.png">
		</div>
		<div>
			<img src="images/6.png">
		</div>
		<div>
			<img src="images/7.png">
		</div>
	</div>
</div>
<script>
	layui
			.use([ 'carousel', 'form' ],
					function() {
						var carousel = layui.carousel, form = layui.form;

						//常规轮播
						carousel.render({
							elem : '#test1',
							arrow : 'always'
						});

						//改变下时间间隔、动画类型、高度
						carousel.render({
							elem : '#test2',
							interval : 1800,
							anim : 'fade',
							height : '120px'
						});

						//设定各种参数
						var ins3 = carousel.render({
							elem : '#test3'
						});
						//图片轮播
						carousel.render({
							elem : '#test10',
							width : '1200px',
							height : '440px',
							interval : 5000
						});

						//事件
						carousel.on('change(test4)', function(res) {
							console.log(res)
						});

						var $ = layui.$, active = {
							set : function(othis) {
								var THIS = 'layui-bg-normal', key = othis
										.data('key'), options = {};

								othis.css('background-color', '#5FB878')
										.siblings().removeAttr('style');
								options[key] = othis.data('value');
								ins3.reload(options);
							}
						};

						//监听开关
						form.on('switch(autoplay)', function() {
							ins3.reload({
								autoplay : this.checked
							});
						});

						$('.demoSet').on('keyup', function() {
							var value = this.value, options = {};
							if (!/^\d+$/.test(value))
								return;

							options[this.name] = value;
							ins3.reload(options);
						});

						//其它示例
						$('.demoTest .layui-btn').on('click', function() {
							var othis = $(this), type = othis.data('type');
							active[type] ? active[type].call(this, othis) : '';
						});
					});
</script>

