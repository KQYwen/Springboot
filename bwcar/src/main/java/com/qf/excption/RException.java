package com.qf.excption;

public class RException extends RuntimeException {
    private int code;
    private String msg;

    public RException() {
        super();
    }

    public RException(String message) {
        super(message);
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

    public void setMsg(String msf) {
        this.msg = msf;
    }
}
