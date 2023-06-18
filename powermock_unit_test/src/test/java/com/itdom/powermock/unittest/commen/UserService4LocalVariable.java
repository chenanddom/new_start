package com.itdom.powermock.unittest.commen;

public class UserService4LocalVariable {

    public int queryUserCount(){
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
