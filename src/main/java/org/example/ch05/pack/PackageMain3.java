package org.example.ch05.pack;

import org.example.ch05.pack.a.User;

public class PackageMain3 {
    public static void main(String[] args) {
        User userA = new User();
        org.example.ch05.pack.b.User userB = new org.example.ch05.pack.b.User();
    }
}
