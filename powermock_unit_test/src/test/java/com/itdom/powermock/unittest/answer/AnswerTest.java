package com.itdom.powermock.unittest.answer;

import com.itdom.powermock.unittest.argumentmatcher.ArgumentMatcherTest;
import com.itdom.powermock.unittest.commen.UserDao4ArgumentMatcher;
import com.itdom.powermock.unittest.commen.UserService4ArgumentMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.argThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService4ArgumentMatcher.class)
public class AnswerTest {

    @Test
    public void answerTest() {
        UserDao4ArgumentMatcher userDao4ArgumentMatcher = PowerMockito.mock(UserDao4ArgumentMatcher.class);
        try {
            PowerMockito.whenNew(UserDao4ArgumentMatcher.class).withAnyArguments().thenReturn(userDao4ArgumentMatcher);
            PowerMockito.when(userDao4ArgumentMatcher.find(Mockito.anyString())).thenAnswer(invocationOnMock -> {
                String content = (String) invocationOnMock.getArguments()[0];
                switch (content){
                    case "zhangsan":
                        return content = "I'm zhangsan";
                    case "lisi":
                        return content = "I'm lisi";
                    default:
                        throw new UnsupportedOperationException();
                }
            });

            UserService4ArgumentMatcher userService4ArgumentMatcher = new UserService4ArgumentMatcher();
            String result = userService4ArgumentMatcher.find("zhangsan");
            assertThat("I'm zhangsan",equalTo(result));
            result = userService4ArgumentMatcher.find("zhangsan2");
            fail();
        } catch (Exception e) {
            assertTrue( e instanceof UnsupportedOperationException);
        }
    }
}
