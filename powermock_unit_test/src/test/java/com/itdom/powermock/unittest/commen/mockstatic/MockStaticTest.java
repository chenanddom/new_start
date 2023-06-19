package com.itdom.powermock.unittest.commen.mockstatic;

import com.itdom.powermock.unittest.commen.User;
import com.itdom.powermock.unittest.commen.UserDao4Static;
import com.itdom.powermock.unittest.commen.UserService4Static;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * 模拟静态方法
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserService4Static.class, UserDao4Static.class})
public class MockStaticTest {

    @Test
    public void queryCountTest() {
        PowerMockito.mockStatic(UserDao4Static.class);
        PowerMockito.when(UserDao4Static.getCount()).thenReturn(10);
        UserService4Static userService4Static = new UserService4Static();
        int count = userService4Static.queryUserCount();

        assertThat(10, equalTo(count));

    }

    @Test
    public void saveUserTest(){
        PowerMockito.mockStatic(UserDao4Static.class);
        PowerMockito.doNothing().when(UserDao4Static.class);//模拟没有返回值
        UserService4Static userService4Static = new UserService4Static();
        userService4Static.saveUser(new User());
        PowerMockito.verifyStatic();
    }
}
