package org.example.class1.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] productOrders = new ProductOrder[3];

        ProductOrder dobu = new ProductOrder();
        dobu.productName = "두부";
        dobu.price = 2000;
        dobu.quantity = 2;
        productOrders[0] = dobu;

        ProductOrder kimchi = new ProductOrder();
        kimchi.productName = "김치";
        kimchi.price = 5000;
        kimchi.quantity = 1;
        productOrders[1] = kimchi;

        ProductOrder cola = new ProductOrder();
        cola.productName = "콜라";
        cola.price = 1500;
        cola.quantity = 2;
        productOrders[2] = cola;

        int totalPrice = 0;
        for (ProductOrder order : productOrders) {
            System.out.println("상품명 : " + order.productName + ", 가격 : " + order.price + ", 수량 : " + order.quantity);
            totalPrice += order.price * order.quantity;
        }
        System.out.println("총 결제 금액: " + totalPrice);


    }
}
