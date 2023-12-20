package org.example.ch12.ex.pay1;

import java.util.Scanner;

public class PayMain1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayService payService = new PayService();
        while (true) {
            System.out.print("결제 수단을 입력하세요:");
            String option = sc.nextLine();
            if (option.equals("exit"))
                break;
            System.out.print("결제 금액을 입력하세요:");
            int amount = Integer.parseInt(sc.nextLine());
            payService.processPay(option, amount);
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
