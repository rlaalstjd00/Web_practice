package com.example.FrontControllerEx.domain.user;

public class User {
    private Long systemid;
    private String userid;
    private String userpw;
    private String username;
    private int userage;

    public User() {
    }

    public User(String userid, String userpw, String username, int userage) {
        this.userid = userid;
        this.userpw = userpw;
        this.username = username;
        this.userage = userage;
    }

    public Long getSystemid() {
        return systemid;
    }

    public void setSystemid(Long systemid) {
        this.systemid = systemid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }
}
