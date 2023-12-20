package org.example.ch12.ex;

public class SmsSender implements Sender{

    @Override
    public void sendMessage(String message) {
        System.out.println("SMS를 발송합니다: " + message);
    }
}
