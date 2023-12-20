package org.example.ch11.ex5;

import org.example.ch11.ex4.AbstractAnimal;

public class Caw implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("음메");
    }

    @Override
    public void move() {
        System.out.println("소 이동");
    }
}
