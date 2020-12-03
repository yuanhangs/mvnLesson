package org.hlx.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Cart
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/31
 * @Version V1.0
 **/
public class Cart {
    //      1>书项的集合:
    private Map<String, CartItem> items = new HashMap<>();

    //      2>统计总计:
    private int total;

    public Cart(Map<String, CartItem> items, int total) {

        this.items = items;
        this.total = total;
    }

    public Cart() {
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }

    /**
     * 计算总计
     *
     * @return
     */
    public int getTotal() {
        int sum = 0;
        //遍历
        for (CartItem item:
            items.values() ) {
            //累计金额
            sum+=item.getBook().getPrice()*item.getQuantity();
        }

        //赋值
        total =sum;
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
