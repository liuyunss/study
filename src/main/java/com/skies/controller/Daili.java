package com.skies.controller;

public class Daili implements eat{
    private eat eat1;

    public Daili(){
        super();
    }
    public Daili(eat eat2){
        super();
        this.eat1 = eat2;
    }

    @Override
    public void eating() {
        System.out.println("dailimoshi");
        eat1.eating();
        System.out.println("jieshu");
    }
}
