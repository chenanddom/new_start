package com.itdom.powermock.unittest.quickstart;

import com.itdom.powermock.unittest.commen.User;
import com.itdom.powermock.unittest.commen.UserDao;
import com.itdom.powermock.unittest.commen.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * 使用PowerMock进行修改
 */
public class QuickStartTestWithPowerMock {

    @Test
    public void queryUserCountTest() {
        UserDao mockUserDao = PowerMockito.mock(UserDao.class);
//        PowerMockito.when(mockUserDao.getCount()).thenReturn(10);
        PowerMockito.doReturn(10).when(mockUserDao).getCount();
        UserService userService = new UserService(mockUserDao);
        int count = userService.queryUserCount();
        assertEquals(10,count);
    }

    @Test
    public void saveUserTest(){
        UserDao mockUserDao = PowerMockito.mock(UserDao.class);
        UserService userService = new UserService(mockUserDao);

        User user = new User();
        PowerMockito.doNothing().when(mockUserDao).insertUser(user);
        userService.saveUser(user);
        verify(mockUserDao).insertUser(user);
    }




}
