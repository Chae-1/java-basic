package org.example.ch10.override;

public class OverridingMain {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("Child -> Child");
        child.method();

        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        parent.method();

        Parent poly = new Child();
        System.out.println("Parent -> Child");
        poly.method();

    }
}
