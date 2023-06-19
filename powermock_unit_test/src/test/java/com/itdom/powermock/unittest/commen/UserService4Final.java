package com.itdom.powermock.unittest.commen;

public class UserService4Final {
    private UserDao4Final userDao;

    public UserService4Final(UserDao4Final userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount(){
        return userDao.getCount();
    }

    public void saveUser(User user){
        userDao.insertUser(user);
    }
}
