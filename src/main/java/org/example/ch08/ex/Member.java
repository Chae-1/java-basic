package org.example.ch08.ex;

public class Member {
    private final String id;
    private final String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changeData(String id, String name) {
        //this.id = id; // final
    }

    public void print() {
        System.out.println("id = " + id + ", name : " + name);
    }
}
