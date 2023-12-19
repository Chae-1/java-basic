package org.example.ch07;

public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }

    static void method1(int m1) {
        System.out.println("method1 start");
        Data data = new Data(m1);
        method2(data);
        System.out.println("method1 end");
    }

    static void method2(Data data) {
        System.out.println("method2 start");
        System.out.println("data.getValue() = " + data.getValue());
        System.out.println("method2 end");
    }
}
