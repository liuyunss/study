package com.skies.controller;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Demo {
    @Autowired
    private Demo2 demo2;
    @Autowired
    private Demo2 demo3;

    @Test
    public void Test(){
       String a = "abcdef";
       String b = "123456";
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        Object o = new Object();
        Thread thread1 = null;
        Thread thread2 = null;
        thread1 = new Thread(() -> {

                for (int i = 0; i < chars1.length; i++) {
                    synchronized (o){
                        o.notifyAll();
                        System.out.print(chars1[i]);
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
//            o.notifyAll();
        });

        thread2 = new Thread(() -> {

                for (int i = 0; i < chars2.length; i++) {
                    synchronized (o){
                        o.notifyAll();
                        System.out.print(chars2[i]);
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
//            o.notifyAll();
        });

        thread1.start();
        thread2.start();
    }

}
