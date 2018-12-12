package com.example.lfuryk.marketplace.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.MessageEvent;
import com.example.lfuryk.marketplace.model.User;
import com.example.lfuryk.marketplace.presenter.LoginPresenter;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginView {

    private TextInputEditText mTextInputEditUsername;
    private TextInputEditText mTextInputEditPassword;

    private Button mLoginButton;
    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTextInputEditUsername = findViewById(R.id.username_text_input);
        mTextInputEditUsername.setOnKeyListener(mKeyListener);

        mTextInputEditPassword = findViewById(R.id.password_text_input);

        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(loginListener);

        mLoginPresenter = new LoginPresenter(this);
    }

    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            User user = new User(mTextInputEditUsername.getText().toString(), mTextInputEditPassword.getText().toString());
            mLoginPresenter.doLogin(user);
        }
    };

    private View.OnKeyListener mKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            EventBus.getDefault().post(new MessageEvent(mTextInputEditUsername.getText().toString()));
            return false;
        }
    };

    @Override
    public void login() {
        Intent intent = new Intent(this, MarketPlaceActivity.class);
        startActivity(intent);
        mLoginPresenter.onStop();
    }

    @Override
    public void blankUserName(){
        mTextInputEditUsername.setText("");
    }

    public void showErrorDialog() {
        FragmentManager fm = getSupportFragmentManager();
        WrongIdentification editNameDialogFragment = WrongIdentification.newInstance();
        editNameDialogFragment.show(fm, "modal_fragment");
        mTextInputEditUsername.setText("");
        mTextInputEditPassword.setText("");
    }

}
