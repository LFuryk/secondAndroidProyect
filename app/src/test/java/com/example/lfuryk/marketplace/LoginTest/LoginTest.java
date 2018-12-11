package com.example.lfuryk.marketplace.LoginTest;

import com.example.lfuryk.marketplace.model.Login;
import com.example.lfuryk.marketplace.model.User;
import com.example.lfuryk.marketplace.model.UserList;

import org.junit.Test;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Mock
    UserList mUserList;

    @Test
    public void validateLogin(){

        User user = new User("usuario","contrasena");

        when(mUserList.getUsersPool()).then(new Answer<List<User>>() {

            @Override
            public List<User> answer(InvocationOnMock invocation) throws Throwable {
                ArrayList<User> mUsersPool = new ArrayList<User>();
                mUsersPool.add(user);
                return mUsersPool;
            }
        });

        Login login = new Login(mUserList);

        assertEquals(login.validateLogin(user),true);
        verify(mUserList,times(1)).getUsersPool();
    }

    @Test
    public void validateLoginNOK(){

        User user = new User("usuario","contrasena");

        when(mUserList.getUsersPool()).then(new Answer<List<User>>() {

            @Override
            public List<User> answer(InvocationOnMock invocation) throws Throwable {
                ArrayList<User> mUsersPool = new ArrayList<User>();
                return mUsersPool;
            }
        });

        Login login = new Login(mUserList);

        assertEquals(login.validateLogin(user),false);
        verify(mUserList,times(1)).getUsersPool();
    }

    @Test
    public void validateLoginNOKWithNullUser(){

        when(mUserList.getUsersPool()).then(new Answer<List<User>>() {

            @Override
            public List<User> answer(InvocationOnMock invocation) throws Throwable {
                ArrayList<User> mUsersPool = new ArrayList<User>();
                return mUsersPool;
            }
        });

        Login login = new Login(mUserList);

        assertEquals(login.validateLogin(null),false);
        verify(mUserList,times(1)).getUsersPool();
    }

    @Test
    public void verifyUser(){
        User user = new User("usuario","contrasena");

        when(mUserList.getUsersPool()).then(new Answer<List<User>>() {

            @Override
            public List<User> answer(InvocationOnMock invocation) throws Throwable {
                ArrayList<User> mUsersPool = new ArrayList<User>();
                mUsersPool.add(user);
                return mUsersPool;
            }
        });

        Login login = new Login(mUserList);

        assertEquals(login.verifyUser("usua"),true);
        verify(mUserList,times(1)).getUsersPool();
    }

    @Test
    public void verifyUserNOK(){
        User user = new User("usuario","contrasena");

        when(mUserList.getUsersPool()).then(new Answer<List<User>>() {

            @Override
            public List<User> answer(InvocationOnMock invocation) throws Throwable {
                ArrayList<User> mUsersPool = new ArrayList<User>();
                mUsersPool.add(user);
                return mUsersPool;
            }
        });

        Login login = new Login(mUserList);

        assertEquals(login.verifyUser("hola"),false);
        verify(mUserList,times(1)).getUsersPool();
    }

    @Test
    public void verifyUserOKWithManyUsers(){
        User user = new User("usuario","contrasena");

        when(mUserList.getUsersPool()).then(new Answer<List<User>>() {

            @Override
            public List<User> answer(InvocationOnMock invocation) throws Throwable {
                ArrayList<User> mUsersPool = new ArrayList<User>();
                mUsersPool.add(new User("user1","contrasena1"));
                mUsersPool.add(new User("user2","contrasena2"));
                mUsersPool.add(new User("user3","contrasena3"));
                mUsersPool.add(user);
                return mUsersPool;
            }
        });

        Login login = new Login(mUserList);

        assertEquals(login.verifyUser("usuario"),true);
        verify(mUserList,times(1)).getUsersPool();
    }

}
