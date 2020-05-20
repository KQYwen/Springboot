package com.ssm;

public class HelloSpring {
    private String username;

    public void setUserName(String username) {
        this.username=username;
    }

    public void show() {
        System.out.println(username+":欢迎来学习Java spring框架");
    }

}
