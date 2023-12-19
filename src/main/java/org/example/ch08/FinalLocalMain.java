package org.example.ch08;

public class FinalLocalMain {
    public static void main(String[] args) {
        final int data1;
        data1 = 10; // final 변수는 최초 1번만 할당 가능
//        data1 = 20; // 컴파일 오류

        final int data2 = 10;
//        data2 = 20; // 컴파일 오류

    }

    static void method(final int parameter) {
        //parameter = 30; // 컴파일 오류 값을 변경 못함.

    }
}
