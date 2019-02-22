package com.springboot.transacltional.entity;

public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /*根据 id 查找枚举类型*/
    public static SexEnum getEnumById(int id) {
        for (SexEnum value : SexEnum.values()) {
            if (value.code == id) {
                return value;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
