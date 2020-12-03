$(function () {
    //失去焦点事件
    $("#name").blur(function () {
        //获得值
        var name = $(this).val();
        //判断
        if (name == "") {
            $("#nameDiv").html("用户名不能为空！").css("color", "red");
            return;
        } else {  //不为空进行处理
            $.ajax({
                type: "GET",  //post or get
                url: "user",
                data: "name=" + name,
                success: function (msg) {
                    // alert( "返回数据 " + msg );
                    //判断
                    if (msg == 1) {
                        $("#nameDiv").html("用户名已存在啦！").css("color", "red");
                    } else {
                        $("#nameDiv").html("用户名可以使用啦！").css("color", "blue");
                    }
                }
            });
        }

    });


});