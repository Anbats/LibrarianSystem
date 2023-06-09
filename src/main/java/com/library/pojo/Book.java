package com.library.pojo;

public class Book {
    private int bno;
    private String bname;
    private String wri;
    private String ssort;
    private String pub;
    private int ing;
    private String intro;


    public Book(int bno, String bname, String wri, String ssort, String pub, int ing) {
        this.bno = bno;
        this.bname = bname;
        this.wri = wri;
        this.ssort = ssort;
        this.pub = pub;
        this.ing = ing;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getWri() {
        return wri;
    }

    public void setWri(String wri) {
        this.wri = wri;
    }

    public String getSsort() {
        return ssort;
    }

    public void setSsort(String ssort) {
        this.ssort = ssort;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public int getIng() {
        return ing;
    }

    public void setIng(int ing) {
        this.ing = ing;
    }
}
