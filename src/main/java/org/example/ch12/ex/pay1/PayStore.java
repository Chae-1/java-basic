package org.example.ch12.ex.pay1;

public class PayStore {
    // 이 코드 때문에 OCP 를 지킬수 없다.
    public static Pay searchPay(String option) {
        if (option.equals("kakao")) {
            return new KakaoPay();
        }

        if (option.equals("naver")) {
            return new NaverPay();
        }

        if (option.equals("toss")) {
            return new TossPay();
        }
        return new NonePay();
    }
}
