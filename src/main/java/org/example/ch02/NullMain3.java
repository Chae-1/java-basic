package org.example.ch02;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count = " + bigData.count); // 0
        System.out.println("bigData.data = " + bigData.data); // null

        //NullPointerException
        System.out.println("bigData.data = " + bigData.data.value);
    }
}
