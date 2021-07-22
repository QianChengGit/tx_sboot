package cn.tx.model;

import java.util.Date;

public class Emp {

    private int pid;
    private String username;
    private String password;
    private String pAddr;
    private int gender;
    private Date birth;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpAddr() {
        return pAddr;
    }

    public void setpAddr(String pAddr) {
        this.pAddr = pAddr;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pAddr='" + pAddr + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
