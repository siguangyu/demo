package com.example.demo.response;

/**
 * @Author: Gosin
 * @Date: 2020/8/21 16:47
 */
public enum TestEnum {
    one("操作成功","00000"),
    two("500001","系统错误");

    private String describe;
    private String code;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    TestEnum(String describe, String code) {
        this.describe = describe;
        this.code = code;

    }
}
