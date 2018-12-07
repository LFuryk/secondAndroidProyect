package com.example.lfuryk.marketplace.model;

public class Login {

    private UserList mUserList;

    public Login(){
        mUserList = new UserList();
    }

    public boolean validateLogin(User user){
        //return mUserList.getUsersPool().contains(user);
        return true;
    }

    public boolean verifyUser(String name){

        for (User user : mUserList.getUsersPool()) {

            if(user.getUsername().startsWith(name)) {
                return true;
            }
        }

        return false;
    }
}
