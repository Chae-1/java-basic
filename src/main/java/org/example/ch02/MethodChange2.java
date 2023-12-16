package org.example.ch02;

public class MethodChange2 {
    public static void main(String[] args) {
        Data data = new Data();
        data.value = 10;
        System.out.println("메서드 호출 전: data.value = " + data.value);
        changeValue(data);
        System.out.println("메서드 호출 후: data.value = " + data.value);

    }

    static void changeValue(Data data) {
        data.value = 20;
    }
}
