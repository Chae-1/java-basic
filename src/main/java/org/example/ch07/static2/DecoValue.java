package org.example.ch07.static2;

public class DecoValue {
    private int instanceValue;
    private static int staticValue;
    public static void staticCall() {
//        instanceValue++;
//        instanceMethod();

        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근
    }

    public void instanceCall() {
        staticValue++;
        staticMethod();

        instanceValue++;
        instanceMethod();
    }

    public static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }

    public void instanceMethod() {
        System.out.println("instanceValue=" + instanceValue);
    }
}
