package org.example.ch09.ex2;

import org.example.ch09.ex1.ElectricCar;
import org.example.ch09.ex1.GasCar;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();
    }
}
