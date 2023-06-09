package com.library.pojo;

public class User {
    private int uno;
    private String uname;

    private String sex;
    private String email;
    private String password;

    private String state;

    public User(int uno, String uname, String sex, String email, String password, String state) {
        this.uno = uno;
        this.uname = uname;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.state = state;
    }
    public User(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUsername() {
        return uname;
    }

    public void setUsername(String username) {
        this.uname = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
