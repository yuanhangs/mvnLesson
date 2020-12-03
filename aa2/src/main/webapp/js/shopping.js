$(function () {

});

//1.值改变数量要发生编号;
function changeNumber(id, inputObj) {
    //获得值
    var quantity = $(inputObj).val();

    if (quantity == null || quantity == "") {
        alert("数量不能为空");
        $(this).val(quantity);
        return;
    }
    if (parseInt(quantity) >100) {
    alert("您购买的数量已达到团购标准，请致电800-820-8820");
    $(this).val(quantity);
    return;
}
//跳转
window.location = "cart.action?id=" + id + "&quantity=" + quantity + "&param=1";
}


/**
 * -
 * @param id
 * @param inputObj
 */
function minus(id, inputObj) {
    //获得值
    var quantity = $(inputObj).parent().find('input[id*=amount]').val();
    if (quantity <= 1) {
        alert("不能再减了，再减就没有啦！");
    } else {   //数量-1
        $(inputObj).parent().find('input[id*=amount]').val(--quantity);

    }
    //计算
    window.location = "cart.action?id=" + id + "&quantity=" + quantity + "&param=1";
}


/**
 * +
 * @param id
 * @param inputObj
 */
function plus(id, inputObj) {
    //获得=>当前文本框的值
    var quantity = $(inputObj).parent().find('input[id*=amount]').val();

    //数量+1
    $(inputObj).parent().find('input[id*=amount]').val(++quantity);

    //计算
    window.location = "cart.action?id=" + id + "&quantity=" + quantity + "&param=1";
}

/**
 * 删除
 * @param id
 */
function del(id) {
    var flag = confirm("您确定要删除吗?");
    if (flag) {
        window.location = "cart.action?id=" + id +"&param=2";
    }
}

/**
 * 清空购物车
 */
function clears(){
    var flag = confirm("您确定要清空购物车吗?");
    if (flag) {
        window.location ="cart.action?param=3";
    }
}