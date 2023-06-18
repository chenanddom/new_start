package com.itdom.powermock.unittest.localvariable;

import com.itdom.powermock.unittest.commen.User;
import com.itdom.powermock.unittest.commen.UserDao;
import com.itdom.powermock.unittest.commen.UserService;
import com.itdom.powermock.unittest.commen.UserService4LocalVariable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * 使用powermock来模拟局部变量创建
 */
@RunWith(PowerMockRunner.class)
//告诉powermock准备改变UserService4LocalVariable的字节码。
@PrepareForTest(UserService4LocalVariable.class)
public class LocalVariavbleTest {

    @Test
    public void queryCountTest() {
        try {
            UserService4LocalVariable userService = new UserService4LocalVariable();
            UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();
            int count = userService.queryUserCount();
            assertEquals(10, count);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void saveUserTest() {
        try {
            User user = new User();
            UserService4LocalVariable userService = new UserService4LocalVariable();
            UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doNothing().when(userDao).insertUser(user);
            userService.saveUser(user);
            Mockito.verify(userDao, Mockito.times(1)).insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
