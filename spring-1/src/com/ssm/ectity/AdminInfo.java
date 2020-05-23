package com.ssm.ectity;

public class AdminInfo {
    private int id;
    private String name;
    private String pwd;



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public AdminInfo(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }


    public AdminInfo(){

    }

    public void print(){
        System.out.println(id+" -- "+name+" -- "+pwd);
    }
}
