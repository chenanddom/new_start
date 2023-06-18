package com.itdom.powermock.unittest.quickstart;

import com.itdom.powermock.unittest.commen.User;
import com.itdom.powermock.unittest.commen.UserDao;
import com.itdom.powermock.unittest.commen.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickStartTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(new UserDao());
    }

    @Test
    public void queryUserCountTest() {
        try {
            int count = userService.queryUserCount();
            assertEquals(0, count);
        } catch (Throwable e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void saveUserTest() {
        try {
            userService.saveUser(new User());
            fail();
        } catch (Throwable e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

}
