package net.jsrbc.security.tools;

/**
 * 加密算法
 * @author ZZZ on 2021/3/6 15:56
 * @version 1.0
 */
enum Algorithm {

    AES("AES"),

    PKCS5Padding("AES/ECB/PKCS5Padding")
    ;


    private final String value;

    Algorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
