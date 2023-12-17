package org.example.ch06.b;

import org.example.ch06.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();

        //public 호출 가능
        accessData.publicMethod();
        accessData.publicField = 100; // 호출 가능

        // 다른 패키지에서 default 호출 불가능
        //accessData.defaultMethod();
        //accessData.defaultField = 200;

        //private 호출 불가능
        //  accessData.privateMethod();
        //  accessData.privateField = 200;

    }
}
