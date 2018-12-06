package com.example.lfuryk.marketplace.model;

public class User {

    private String mUsername;
    private String mPassword;

    public User(String username, String password){
        this.mUsername = username;
        this.mPassword = password;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getUsername() {
        return this.mUsername;
    }
}
