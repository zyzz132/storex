$(function(){

	$("#reg").click(function(){
		location.href="register.jsp";
	})
	$(".allClass").mousemove(function () {

		$(".CommdClassList").show();
	}).mouseout(function () {
		$(".CommdClassList").hide();
	})
})