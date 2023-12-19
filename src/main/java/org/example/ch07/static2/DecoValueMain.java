package org.example.ch07.static2;

import static org.example.ch07.static2.DecoValue.staticCall;

public class DecoValueMain {
    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        staticCall();
        staticCall();
        staticCall();
        staticCall();
        staticCall();

        System.out.println("2. 인스턴스 호출");
        DecoValue decoValue = new DecoValue();
        decoValue.instanceCall();

        System.out.println("3. 인스턴스 호출");
        DecoValue decoValue2 = new DecoValue();
        decoValue2.instanceCall();
    }
}
