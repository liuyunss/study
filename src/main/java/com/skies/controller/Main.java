package com.skies.controller;

public class Main {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Daili daili = new Daili(girl);
        daili.eating();
    }
}
