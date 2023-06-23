package com.itdom.powermock.unittest.commen;

import com.itdom.powermock.unittest.commen.User;

public class UserDao4Construct {


    private String username;
    private String password;

    public UserDao4Construct(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void insert(){
        throw new UnsupportedOperationException();
    }
}
