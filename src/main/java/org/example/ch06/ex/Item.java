package org.example.ch06.ex;

public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void showItemInfo() {
        int totalPrice = totalPrice();
        System.out.println("상품명:" + name + ", 합계:" + totalPrice);
    }

    public int totalPrice() {
        return price * quantity;
    }
}
