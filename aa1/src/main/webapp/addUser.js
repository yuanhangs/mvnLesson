$(function(){
    alert("用户名不能为空！");
    //表单提交
    $("form").submit(function(){
        //参数
       var name= $("[name=\"textfield\"]").val();
       if(name==""){
           alert("用户名不能为空！");
           return false;
       }else{
           return true;
       }

    })
})