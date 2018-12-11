package com.example.lfuryk.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    List<User> mUsersPool;

    public UserList(){
        mUsersPool = new ArrayList<User>();
        this.initList();
    }

    public void initList(){
        mUsersPool.add(new User("Leandro","Leandro"));
        mUsersPool.add(new User("usuario","contrasena"));
    }

    public List<User> getUsersPool() {
        return this.mUsersPool;
    }
}
