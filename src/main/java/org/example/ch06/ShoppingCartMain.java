package org.example.ch06;

import org.example.ch06.ex.Item;
import org.example.ch06.ex.ShoppingCart;

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        shoppingCart.displayItems();
    }
}
