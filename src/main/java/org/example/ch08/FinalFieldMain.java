package org.example.ch08;

public class FinalFieldMain {
    public static void main(String[] args) {
        System.out.println("생성자 초기화");
        ConstructInit init1 = new ConstructInit(10);
        ConstructInit init2 = new ConstructInit(20);
        System.out.println(init1.value);
        System.out.println(init2.value);

        System.out.println("필드 초기화");
        FieldInit fInit1 = new FieldInit();
        FieldInit fInit2 = new FieldInit();
        FieldInit fInit3 = new FieldInit();
        System.out.println(fInit1.value);
        System.out.println(fInit2.value);
        System.out.println(fInit3.value);

        // 상수 static final 둘 다 붙은 변수를 상수라고 한다.
        System.out.println("상수");
        System.out.println(FieldInit.CONST_VALUE);

    }
}
