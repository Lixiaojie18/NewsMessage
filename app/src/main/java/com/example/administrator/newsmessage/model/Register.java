package com.example.administrator.newsmessage.model;

/**
 * Created by ${Administrator} on 2016/11/11 0011.
 */

public class Register {
    private int result;
    private String explain;
    private String token;

    public Register(int result, String explain, String token) {
        this.result = result;
        this.explain = explain;
        this.token = token;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Register{" +
                "result=" + result +
                ", explain='" + explain + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
