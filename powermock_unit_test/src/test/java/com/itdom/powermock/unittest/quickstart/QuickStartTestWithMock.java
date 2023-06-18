package com.itdom.powermock.unittest.quickstart;

import com.itdom.powermock.unittest.commen.User;
import com.itdom.powermock.unittest.commen.UserDao;
import com.itdom.powermock.unittest.commen.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class QuickStartTestWithMock {

    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    UserDao userDao;

    @Test
    public void queryUserCountTest() {
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int count = userService.queryUserCount();
        assertEquals(10,count);
    }
}
