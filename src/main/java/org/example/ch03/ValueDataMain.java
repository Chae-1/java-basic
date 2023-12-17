package org.example.ch03;

public class ValueDataMain {
    public static void main(String[] args) {
        ValueDate valueDate = new ValueDate();
        add(valueDate);
        add(valueDate);
        add(valueDate);
        System.out.println("최종 숫자=" + valueDate.value);
    }

    static void add(ValueDate valueDate) {
        valueDate.value++;
        System.out.println("숫자 증가 value=" + valueDate.value);
    }
}
