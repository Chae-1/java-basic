package org.example.ch07;

import org.example.ch07.Counter;
import org.example.ch07.Data2;

public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 data1 = new Data2("A", counter);
        System.out.println("A counter.count = " + counter.count);

        Data2 data2 = new Data2("B", counter);
        System.out.println("B counter.count = " + counter.count);

    }
}
