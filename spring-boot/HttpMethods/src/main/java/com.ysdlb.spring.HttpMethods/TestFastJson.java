package com.ysdlb.spring.HttpMethods;

import com.alibaba.fastjson.JSON;

public class TestFastJson {
    static class Person {
        Person(int n1, Integer n2, String name) {
            this.num1 = n1;
            this.num2 = n2;
            this.name = name;
        }
        int num1;
        Integer num2;
        String name;

        public String getName() {
            return name;
        }

        public int getNum1() {
            return num1;
        }

        public Integer getNum2() {
            return num2;
        }
    }
    public static void main(String[] args) {
        Object p = new Person(1, 2, "woshi");
        Person m = new Person(1, 2, "woshi");
        System.out.println(JSON.toJSONString(p));
        System.out.println(JSON.toJSONString(m));
    }
}
