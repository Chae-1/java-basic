package org.example.ch10.basic;

public class CastingMain3 {
    public static void main(String[] args) {
        Child child = new Child();
        // 자식타입을 부모타입으로 변환 -> 업캐스팅
        Parent parent = (Parent) child;
        // 업캐스팅은 생략이 가능하다.
        Parent parent2 = child;

        parent2.parentMethod();
    }
}
