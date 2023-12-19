package org.example.ch09.super2;

public class ClassC extends ClassB {

    public ClassC(int a) {
        this(a, 20);
        System.out.println("ClassC 생성자");
    }

    public ClassC(int a, int b) {
        super(a, b);
        System.out.println("ClassC(a,b) 호출");
    }
}
