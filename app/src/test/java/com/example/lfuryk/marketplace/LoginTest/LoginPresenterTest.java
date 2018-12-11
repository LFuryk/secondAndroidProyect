package com.example.lfuryk.marketplace.LoginTest;

import com.example.lfuryk.marketplace.model.Login;
import com.example.lfuryk.marketplace.model.MessageEvent;
import com.example.lfuryk.marketplace.model.User;
import com.example.lfuryk.marketplace.presenter.LoginPresenter;

import org.junit.Test;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock Login mLogin;
    @Mock LoginPresenter.LoginView mLoginView;
    @Mock MessageEvent messageEvent;

    @Test
    public void doLogin(){
        User user = new User("usuario", "contrasena");

        when(mLogin.validateLogin(user)).thenReturn(true);

        LoginPresenter loginPresenter = new LoginPresenter(mLoginView, mLogin);

        loginPresenter.doLogin(user);

        verify(mLoginView,times(1)).login();
    }

    @Test
    public void dontLogin(){
        User user = new User("usuario", "contrasena");

        when(mLogin.validateLogin(user)).thenReturn(false);

        LoginPresenter loginPresenter = new LoginPresenter(mLoginView, mLogin);

        loginPresenter.doLogin(user);

        verify(mLoginView,times(0)).login();
    }

    @Test
    public void onMessageEventOK(){

        when(messageEvent.getMessage()).thenReturn("usua");
        when(mLogin.verifyUser(messageEvent.getMessage())).thenReturn(true);

        LoginPresenter loginPresenter = new LoginPresenter(mLoginView, mLogin);
        loginPresenter.onMessageEvent(messageEvent);

        verify(mLoginView,times(0)).blankUserName();
    }

    @Test
    public void onMessageEventNOK(){
        when(messageEvent.getMessage()).thenReturn("usua");
        when(mLogin.verifyUser(messageEvent.getMessage())).thenReturn(false);

        LoginPresenter loginPresenter = new LoginPresenter(mLoginView, mLogin);
        loginPresenter.onMessageEvent(messageEvent);

        verify(mLoginView,times(1)).blankUserName();
    }

}
