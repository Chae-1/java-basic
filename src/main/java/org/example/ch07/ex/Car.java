package org.example.ch07.ex;

public class Car {
    private String name;
    private static int totalCars;

    public Car(String name) {
        this.name = name;
        System.out.println("차량 구입, " + name);
        totalCars++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량의 수 : " + totalCars);
    }
}
