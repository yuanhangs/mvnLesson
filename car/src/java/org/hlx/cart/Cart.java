package org.hlx.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车
 */
public class Cart {
    //1>书项的集合:
    private Map<String, CartItem> items = new HashMap<>();

    //2>统计总计:
    private double total;

    public Cart(Map<String, CartItem> items, double total) {
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
     * 获得总金额
     * @return
     */
    public double getTotal() {
        int sum =0;
        for(CartItem item: items.values()){
            //累计金额
            sum+=item.getQuantity()*item.getBook().getPrice();

        }
        //赋值给总金额
        this.total =sum;
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
