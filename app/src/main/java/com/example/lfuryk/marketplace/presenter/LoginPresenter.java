package com.example.lfuryk.marketplace.presenter;

import com.example.lfuryk.marketplace.model.Login;
import com.example.lfuryk.marketplace.model.MessageEvent;
import com.example.lfuryk.marketplace.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class LoginPresenter {

    private Login mLogin;
    private LoginView mView;


    public LoginPresenter(LoginView view){

        this.mLogin= new Login();
        this.mView = view;
        EventBus.getDefault().register(this);
    }

    public LoginPresenter(LoginView view, Login login){

        this.mLogin= login;
        this.mView = view;
        EventBus.getDefault().register(this);
    }

    public void doLogin(User user){
        if(mLogin.validateLogin(user)){
            mView.login();
        }else{
            mView.showErrorDialog();
        }
    }

    public interface LoginView {

        void login();
        void blankUserName();
        void showErrorDialog();
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
    }

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if(!mLogin.verifyUser(event.getMessage())){
            mView.blankUserName();
        }
    }
}
