package com.example.lfuryk.marketplace.model;

public class Login {

    private UserList mUserList;

    public Login(){
        mUserList = new UserList();
    }

    public Login(UserList userList){
        this.mUserList = userList;
    }

    public boolean validateLogin(User user){

       for (User u : mUserList.getUsersPool()) {

            if(user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }

        return false;
        //return true;
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
