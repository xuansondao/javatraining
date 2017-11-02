package com.xuansondao.lab2;

public class SaiSoException extends Exception {
    private String so;

    public SaiSoException(String so) {
        this.so = so;
    }

    @Override
    public String getMessage() {
        return "gia tri \' " + so + " \' Khong phai la so";
    }
}
