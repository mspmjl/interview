package com.interview.javase;

/**
 * Created by Miaojiale on 2021/2/25.
 */
class Father {
    static String s = initString();
    int i = initInt();

    public Father() {
        System.out.println("Father Constructor");
    }

    static String initString() {
        System.out.println("Father static init string");
        return "";
    }

    int initInt() {
        System.out.println("Father init int");
        return 1;
    }

    static {
        System.out.println("Father static java code");
    }

    {
        System.out.println("Father  java code");
    }

}

class Son extends Father {
//    static String s = initStringSon();
//    int i = initIntSon();
    static String s = initString();
    int i = initInt();

    public Son() {
        System.out.println("Son Constructor");
    }

//    static String initStringSon() {
//        System.out.println("Son static init string");
//        return "";
//    }
//
//    int initIntSon() {
//        System.out.println("Son init int");
//        return 1;
//    }
    static String initString() {
        System.out.println("Son static init string");
        return "";
    }

    int initInt() {
        System.out.println("Son init int");
        return 1;
    }

    static {
        System.out.println("Son static java code");
    }

    {
        System.out.println("Son  java code");
    }
}

public class ClassInitialization {
    public static void main(String[] args) {
        Son son = new Son();
        Son son1 = new Son();
    }
}
