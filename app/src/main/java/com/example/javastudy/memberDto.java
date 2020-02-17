package com.example.javastudy;

import java.util.HashMap;
import java.util.Map;

public class memberDto {

    private String name;

    private String nickname;

    private String phoneNumber;

    private HashMap<String,String> friendList;

    public HashMap<String, String> getFriendList() {
        return friendList;
    }

    public void setFriendList(HashMap<String, String> friendList) {
        this.friendList = friendList;
    }

    public memberDto(){

    }

    public memberDto(String name, String nickname, String phoneNumber) {
        this.name = name;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
    }

    public memberDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
