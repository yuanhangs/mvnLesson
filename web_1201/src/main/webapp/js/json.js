$(function () {

//json对象
    var stu = {"name": "楼挺好", "age": 20, "sex": "女"};

    $("#dv1").html(stu.name + "&nbsp;" + stu.age + "&nbsp;" + stu.sex);

   //json数组
    var names = ["kit", "mike", "john", "lth"];
    var str="";

    //循环
    $.each(names, function (i, ele) {
        str+=i+" "+ele+",";
        //获得select对象,添加孩子
        $("#uname").append("<option value="+ele+">"+ele+"</option>");
    })
    $("#dv2").html(str);


    //对象数组
    var students=[{"name": "楼挺好", "age": 20, "sex": "女"},
        {"name": "林肯", "age": 21, "sex": "男"},
        {"name": "tim", "age": 18, "sex": "女"}
    ]
    var result="";
    //循环
    $.each(students,function(i,ele){
       result+=ele.name+" "+ele.age+" "+ele.sex+"<br/>";
    })
    $("#dv3").html(result);
});