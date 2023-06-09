package com.library.pojo;

/*图书管理员实体类*/

public class Librarian {
    public String bmno;
    public String mname;
    public String msex;
    public String mpassword;

    public Librarian() {
    }

    public Librarian(String lno, String lname) {
        this.bmno = bmno;
        this.mname = mname;
    }

    public Librarian(String lno, String lname, String lsex, String lpassword) {
        this.bmno = bmno;
        this.mname = mname;
        this.msex = msex;
        this.mpassword = mpassword;

    }

    public String getLno() {
        return bmno;
    }

    public void setLno(String lno) {
        this.bmno = bmno;
    }

    public String getLname() {
        return mname;
    }

    public void setLname(String lname) {
        this.mname = mname;
    }

    public String getLsex() {
        return msex;
    }

    public void setLsex(String lsex) {
        this.msex = msex;
    }

    public String getLpassword() {
        return mpassword;
    }

    public void setLpassword(String lpassword) {
        this.mpassword = mpassword;
    }

}
