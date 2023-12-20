package org.example.ch12.car1;

public class CarMain1 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        K3Car k3Car = new K3Car();
        Model3Car model3Car = new Model3Car();

        driver.setCar(k3Car);
        driver.drive();

        driver.setCar(model3Car);
        driver.drive();

        // 새로운 기능 추가
        NewCar newCar = new NewCar();
        newCar.startEngine();
        newCar.pressAccelerator();
        newCar.offEngine();

    }
}
