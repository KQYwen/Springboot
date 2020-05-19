package com.qf.excption;

public class RException extends RuntimeException {
    private int code;
    private String msg;

    public RException() {

    }

    public RException(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String ms) {
        this.msg = msg;
    }
}
