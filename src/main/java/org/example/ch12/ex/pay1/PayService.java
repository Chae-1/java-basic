package org.example.ch12.ex.pay1;

/*
1. 결제 수단을 추가하면 if문이 늘어난다.
 -> 결제 수단을 하나로 다룰 수 있어야 한다.
 -> 다형성을 활용하자.

*/


public class PayService {

    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);
        Pay pay = PayStore.searchPay(option);

        boolean payResult = pay.pay(amount);
        if (payResult) {
            System.out.println("결제가 성공했습니다.");
            return;
        }
        System.out.println("결제가 실패했습니다.");
    }
}
