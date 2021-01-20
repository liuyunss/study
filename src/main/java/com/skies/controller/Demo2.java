package com.skies.controller;

import com.alibaba.fastjson.JSON;
import com.skies.bean.ComBean;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
public class Demo2 {
    public static void main(String[] args) {
        List<ComBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ComBean(i));
        }
        Collections.sort(list);
        log.info(JSON.toJSONString(list));
//        Comparator comparator = (Comparator<ComBean>) (a,b) -> a.getAge() -b.getAge();
        Collections.sort(list, (a,b) -> a.getAge() - b.getAge());
        log.info(JSON.toJSONString(list));

    }



}
