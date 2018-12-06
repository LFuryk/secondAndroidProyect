package com.example.lfuryk.marketplace.presenter;

import com.example.lfuryk.marketplace.model.Login;
import com.example.lfuryk.marketplace.model.User;


public class LoginPresenter {

    private Login mLogin;
    private LoginView mView;


    public LoginPresenter(LoginView view){

        this.mLogin= new Login();
        this.mView = view;

    }

    public void doLogin(User user){
        if(mLogin.validateLogin(user)){
            mView.login();
        }
    }

    public interface LoginView {

        void login();

    }
}
