package org.example.ch11.ex5;

import org.example.ch11.ex4.AbstractAnimal;

public class Cat implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("냐옹");
    }

    @Override
    public void move() {
        System.out.println("고양이 이동");
    }
}
