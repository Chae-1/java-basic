package org.example.ch09.parent;

public class Parent {
    public int publicValue;
    int defaultValue;
    protected int protectedValue;
    private int privateValue;

    protected void protectedMethod() {
        System.out.println("Parent.protectedMethod");
    }

    void defaultMethod() {
        System.out.println("Parent.defaultMethod");
    }

    public void publicMethod() {
        System.out.println("Parent.publicMethod");
    }

    private void privateMethod() {
        System.out.println("Parent.privateMethod");
    }

    public void printParent() {
        System.out.println("==Parent 메서드 안==");
        System.out.println("publicValue = " + publicValue);
        System.out.println("defaultValue = " + defaultValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("privateValue = " + privateValue);

        defaultMethod();
        protectedMethod();
    }

}
