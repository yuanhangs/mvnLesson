package org.hlx.cart;

import org.hlx.entity.Book;

/**
 * @ClassName CartItem
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/31
 * @Version V1.0
 * 购物车 每一项（书，数量）
 **/
public class CartItem {
//    每一项（书，数量）
    private Book book;  //书
    private int quantity;   //数量

    public CartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
