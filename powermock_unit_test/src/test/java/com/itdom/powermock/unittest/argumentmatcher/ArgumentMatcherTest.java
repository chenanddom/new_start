package com.itdom.powermock.unittest.argumentmatcher;

import com.itdom.powermock.unittest.commen.UserDao4ArgumentMatcher;
import com.itdom.powermock.unittest.commen.UserService4ArgumentMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.argThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService4ArgumentMatcher.class)
public class ArgumentMatcherTest {
    @Test
    public void findTest() {
        UserDao4ArgumentMatcher userDao4ArgumentMatcher = PowerMockito.mock(UserDao4ArgumentMatcher.class);
        try {
            PowerMockito.whenNew(UserDao4ArgumentMatcher.class).withAnyArguments().thenReturn(userDao4ArgumentMatcher);
            PowerMockito.when(userDao4ArgumentMatcher.find("zhangsan")).thenReturn("张三");
            UserService4ArgumentMatcher userService4ArgumentMatcher = new UserService4ArgumentMatcher();
            String result = userService4ArgumentMatcher.find("zhangsan");
            assertThat("张三", equalTo(result));

            PowerMockito.when(userDao4ArgumentMatcher.find("lisi")).thenReturn("李四");
            userService4ArgumentMatcher = new UserService4ArgumentMatcher();
            result = userService4ArgumentMatcher.find("lisi");
            assertThat("李四", equalTo(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findTest2() {
        UserDao4ArgumentMatcher userDao4ArgumentMatcher = PowerMockito.mock(UserDao4ArgumentMatcher.class);
        try {
            PowerMockito.whenNew(UserDao4ArgumentMatcher.class).withAnyArguments().thenReturn(userDao4ArgumentMatcher);
            PowerMockito.when(userDao4ArgumentMatcher.find(argThat(new MyArgumentMatcher()))).thenReturn("张三");
            UserService4ArgumentMatcher userService4ArgumentMatcher = new UserService4ArgumentMatcher();
            String result = userService4ArgumentMatcher.find("zhangsan");
            assertThat("张三", equalTo(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyArgumentMatcher extends ArgumentMatcher<String> {

        @Override
        public boolean matches(Object o) {
            String mark = String.valueOf(o);
            switch (mark) {
                case "zhangsan":
                case "lisi":
                case "wangwu":
                    return true;
                default:
                    return false;
            }
        }
    }


}
