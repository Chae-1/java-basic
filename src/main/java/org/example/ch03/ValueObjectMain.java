package org.example.ch03;

public class ValueObjectMain {
    public static void main(String[] args) {
        ValueDate valueDate = new ValueDate();
        valueDate.add();
        valueDate.add();
        valueDate.add();
        System.out.println("valueDate.value = " + valueDate.value);
    }
}
