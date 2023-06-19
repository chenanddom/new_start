package com.itdom.powermock.unittest.commen;

public class UserService4Static {

    public int queryUserCount() {
        return UserDao4Static.getCount();
    }

    public void saveUser(User user) {
        UserDao4Static.insertUser(user);
    }
}
