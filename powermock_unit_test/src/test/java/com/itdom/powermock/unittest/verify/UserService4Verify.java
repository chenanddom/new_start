package com.itdom.powermock.unittest.verify;

import com.itdom.powermock.unittest.commen.User;
import com.itdom.powermock.unittest.commen.UserDao;

public class UserService4Verify {
    public void saveOrUpdate(User user) {
        UserDao4Verify userDao4Verify = new UserDao4Verify();
        if (userDao4Verify.getCount() > 0) {
            userDao4Verify.update(user);
        } else {
            userDao4Verify.insertUser(user);
        }
    }
}
