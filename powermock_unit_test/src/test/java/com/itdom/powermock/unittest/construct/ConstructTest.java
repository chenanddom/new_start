package com.itdom.powermock.unittest.construct;

import com.itdom.powermock.unittest.commen.UserDao4Construct;
import com.itdom.powermock.unittest.commen.UserService4Construct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService4Construct.class)
public class ConstructTest {

    @Test
    public void saveUserTest() {
        try {
            UserDao4Construct userDao4Construct = PowerMockito.mock(UserDao4Construct.class);
            String username = "zhangsan";
            String password = "123456";
            PowerMockito.whenNew(UserDao4Construct.class).withArguments(username, password).thenReturn(userDao4Construct);
            PowerMockito.doNothing().when(userDao4Construct).insert();
            UserService4Construct userService4Construct = new UserService4Construct();
            userService4Construct.saveUser(username,password);
            Mockito.verify(userDao4Construct).insert();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
