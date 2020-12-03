//jquery加载事件
$(function () {
    // 1） 创建XMLHttpRequest对象
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //文本框失去焦点事件
    $("#name").blur(function () {
        //获得值
        var name = $(this).val();
        //判断
        if (name == "") {
            $("#nameDiv").html("username isn't empty！").css("color", "red");
            return;
        }

        // 2） 创建回调函数，根据响应状态动态更新页面
        xmlhttp.onreadystatechange = goBack;

        // 3） 通过XMLHttpRequest对象设置请求信息
        xmlhttp.open("POST", "user", true);

        //必须请求头信息
        xmlhttp.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded" );

        // 4）向服务器发送请求  (post传的参数)
        xmlhttp.send("name=" + name);

    });

    // 5） 处理回调函数
    function goBack() {
        //判断响应成功状态；
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            // alert(xmlhttp.responseText);

            if(xmlhttp.responseText==1){
                $("#nameDiv").html("username is already！").css("color", "brown");
            }else{
                $("#nameDiv").html("username is not！").css("color", "green");
            }
        }
    }

});