$(function () {
    //下拉列表事件
    $("#selectPage").change(function () {
        document.location.href="all.do?pageIndex="+$(this).val();
    });

});

