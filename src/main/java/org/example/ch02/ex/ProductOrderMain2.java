package org.example.ch02.ex;

import java.util.Scanner;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int count = sc.nextInt();
        ProductOrder[] productOrders = new ProductOrder[count];
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "번째 주문 정보를 입력 하세요.");
            String productName = getProductName(sc);
            int price = getPrice(sc);
            int quantity = getQuantity(sc);
            productOrders[i] = createProductOrder(productName, price, quantity);
        }
        printProductOrder(productOrders);
        int totalAmount = getTotalAmount(productOrders);
        System.out.println("총 결제 금액: " + totalAmount);
    }

    private static String getProductName(Scanner sc) {
        System.out.print("상품명: ");
        String productName = sc.next();
        return productName;
    }

    private static int getPrice(Scanner sc) {
        System.out.print("가격: ");
        int price = sc.nextInt();
        return price;
    }

    private static int getQuantity(Scanner sc) {
        System.out.print("수량: ");
        int quantity = sc.nextInt();
        return quantity;
    }

    static ProductOrder createProductOrder(String productName, int price, int quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName = productName;
        productOrder.price = price;
        productOrder.quantity = quantity;
        return productOrder;
    }

    static void printProductOrder(ProductOrder[] productOrders) {
        for (ProductOrder productOrder : productOrders) {
            System.out.println("상품명: " + productOrder.productName +
                    ", 가격: " + productOrder.price
                    + ", 수량: " + productOrder.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] productOrders) {
        int totalAmount = 0;
        for (ProductOrder productOrder : productOrders) {
            totalAmount += productOrder.price * productOrder.quantity;
        }
        return totalAmount;
    }
}
