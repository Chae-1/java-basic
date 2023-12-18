package org.example.ch06.ex;

public class ShoppingCart {
    private Item[] items;
    private int itemCount;

    public ShoppingCart() {
        items = new Item[10];
        itemCount = 0;
    }

    public void addItem(Item item) {
        if (itemCount >= items.length) {
            System.out.println("더 이상 담을 수 없습니다.");
            return;
        }

        items[itemCount++] = item;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            item.showItemInfo();
        }
        System.out.println("전체 가격 합: " + calculateTotalPrice());
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < itemCount; i++) {
            totalPrice += items[i].totalPrice();
        }
        return totalPrice;
    }
}
