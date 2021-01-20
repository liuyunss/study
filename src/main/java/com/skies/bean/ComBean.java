package com.skies.bean;

import lombok.Data;

@Data
public class ComBean implements Comparable<ComBean>{
    private int age;

    @Override
    public int compareTo(ComBean o) {
        return o.getAge() - age;
    }

    public ComBean(int age){
        this.age = age;
    }
}
