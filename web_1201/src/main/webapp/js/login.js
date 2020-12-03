$(function () {
    //单击事件
    $("#btn").click(function () {
        //获得值
        var name = $("#name").val();
        var pass = $("#pass").val();
        //判断
        if (name == "") {
            $("#sp1").html("用户名不能为空！").css("color", "red");
            return;
        }
        if (pass == "") {
            $("#sp2").html("密码不能为空！").css("color", "red");
            return;
        }
        else {  //不为空进行get处理
            $("#sp1").html("");
            $("#sp2").html("");

           $.get("login",{"name":name,"pass":pass},function(data){
               alert(data);
           });
        }

    });


});