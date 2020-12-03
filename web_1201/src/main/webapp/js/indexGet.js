$(function () {
    //失去焦点事件
    $("#name").blur(function () {
        //获得值
        var name = $(this).val();
        //判断
        if (name == "") {
            $("#nameDiv").html("用户名不能为空！").css("color", "red");
            return;
        } else {  //不为空进行get处理
           $.get("user",{"name":name},function(data){
              alert(data);
           });
        }

    });


});