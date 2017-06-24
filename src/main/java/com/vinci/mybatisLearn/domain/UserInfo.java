package com.vinci.mybatisLearn.domain;

/**
 * Created by Jao on 2017/6/22.
 */
public class UserInfo {
    private long id;
    private long lobNumber;
    private String emailAddress;
    private String telNumber;
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLobNumber() {
        return lobNumber;
    }

    public void setLobNumber(long lobNumber) {
        this.lobNumber = lobNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", lobNumber=" + lobNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
