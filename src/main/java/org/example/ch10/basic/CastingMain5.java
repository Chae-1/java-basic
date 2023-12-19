package org.example.ch10.basic;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        call(parent1);

        Parent parent2 = new Parent();
        call(parent2);
    }

    public static void call(Parent parent) {
        parent.parentMethod();
        if (parent instanceof Child) {
            System.out.println("Child 인스턴스가 맞다.");
            // 다운캐스팅을 하면 안전할 것이다.
            ((Child)parent).childMethod();
        }
    }
}
