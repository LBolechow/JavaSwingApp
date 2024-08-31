package com.company;

public class Main {
    public Main() {}

    public static void main(String[] args) {
        Panel pan = new Panel();
        pan.setVisible(true);
        new Sterowanie(pan);

    }
}