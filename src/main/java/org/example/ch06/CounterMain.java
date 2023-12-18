package org.example.ch06;

import org.example.ch06.ex.MaxCounter;

public class CounterMain {
    public static void main(String[] args) {
        MaxCounter maxCounter = new MaxCounter(3);

        maxCounter.increment();
        maxCounter.increment();
        maxCounter.increment();
        maxCounter.increment();

        int count = maxCounter.getCount();
        System.out.println(count);
    }
}
