$(function () {
    $(".Commdimaglist").children("li:first-child").addClass("index-Img");
    $(".Commdimaglist").children().mousemove(function () {
        $(".Commdimaglist").children().removeClass("index-Img");
        $(this).addClass("index-Img");
        var imgurl=$(this).children().attr("src");
        $(".CommdImagK>img").attr("src",imgurl);

    })
})