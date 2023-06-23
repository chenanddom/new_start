package com.itdom.powermock.unittest.commen;

public class UserService4Construct {

    public void saveUser(String username,String password){
        UserDao4Construct userDao4Construct = new UserDao4Construct(username,password);
        userDao4Construct.insert();
    }
}
