package com.itdom.powermock.unittest.commen;

public class UserService4ArgumentMatcher {

    public String find(String username){
        UserDao4ArgumentMatcher userDao4ArgumentMatcher = new UserDao4ArgumentMatcher();
        return userDao4ArgumentMatcher.find(username);
    }
}
