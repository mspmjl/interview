package com.common;

/**
 * Created by Miaojiale on 2021/2/7.
 */
public enum EnumDemo {
    ONE("1", "1"), TWO("2", "3"), THREE("3", "3");
    private String code;
    private String value;

    EnumDemo(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getDesc(String s){
        EnumDemo[] values = EnumDemo.values();
        for (EnumDemo value : values) {
            if (value.getCode().equals(s)){
                return value.getValue();
            }
        }
        return null;
    }
}
