package org.example.ch07.static2;

public class DecoMain1 {
    public static void main(String[] args) {
        String s = "Hello Java";
        DecoUtil decoUtil = new DecoUtil();

        String deco = decoUtil.deco(s);
        System.out.println("before : " + s);
        System.out.println("after : " + s);

    }
}
