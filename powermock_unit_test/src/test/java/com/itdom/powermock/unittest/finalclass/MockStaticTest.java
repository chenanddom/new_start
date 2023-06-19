package com.itdom.powermock.unittest.finalclass;

import com.itdom.powermock.unittest.commen.*;
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
@PrepareForTest(value = {UserService4Final.class, UserDao4Final.class})
public class MockStaticTest {

    @Test
    public void queryCountTest() {
        UserDao4Final userDao4Final = PowerMockito.mock(UserDao4Final.class);
        System.out.println(userDao4Final.getClass());
        PowerMockito.when(userDao4Final.getCount()).thenReturn(10);
        UserService4Final userService4Final = new UserService4Final(userDao4Final);
        int count = userService4Final.queryUserCount();
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
