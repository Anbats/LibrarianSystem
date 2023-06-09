package com.library.pojo;

public class returnRecord {
    private Integer rbno;
    private String rbname;
    private String rbdate;
    private Integer day;

    public returnRecord(Integer rbno, String rbname, String rbdate, Integer day) {
        this.rbno = rbno;
        this.rbname = rbname;
        this.rbdate = rbdate;
        this.day = day;
    }

    public Integer getRbno() {
        return rbno;
    }

    public void setRbno(Integer rbno) {
        this.rbno = rbno;
    }

    public String getRbname() {
        return rbname;
    }

    public void setRbname(String rbname) {
        this.rbname = rbname;
    }

    public String getRbdate() {
        return rbdate;
    }

    public void setRbdate(String rbdate) {
        this.rbdate = rbdate;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
