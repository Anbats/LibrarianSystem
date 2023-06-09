package com.library.pojo;

public class borrowRecord {

    private Integer bno;
    private String bname;

    private String bdate;
    private String ldate;

    private String state;

    public borrowRecord(Integer bno,String bname, String bdate, String ldate) {
        this.bno = bno;

        this.bname = bname;
        this.bdate = bdate;
        this.ldate = ldate;
            if(ldate==null){
                this.state="否";
            }
           else {
               this.state="是";
           }

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }
}
