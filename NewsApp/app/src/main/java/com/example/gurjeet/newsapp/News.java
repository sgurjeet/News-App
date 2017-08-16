package com.example.gurjeet.newsapp;

/**
 * Created by Gurjeet on 07-Feb-17.
 */

public class News {
    private String msec;
    private String mtime;
    private String murl;
    private String mtitle;
    private int mnum;
    public News(String msec, String mtime, String murl, String mtitle,int num) {
        this.msec = msec;
        this.mtime = mtime;
        this.murl = murl;
        this.mtitle = mtitle;
        mnum=num;
    }

    public int getMnum() {
        return mnum;
    }

    public String getMsec() {
        return msec;
    }

    public String getMtime() {
        return mtime;
    }

    public String getMurl() {
        return murl;
    }

    public String getMtitle() {
        return mtitle;
    }
}
