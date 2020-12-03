package org.hlx.cart;

import org.hlx.entity.Book;

/**
 * 购物车的中的书每一项
 */
public class CartItem {
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
