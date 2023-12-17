package org.example.ch03.ex;

public class Account {
    int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액 부족");
        } else {
            balance -= amount;
        }
    }

    void showBalance() {
        System.out.println("잔고 : " + balance);
    }
}
