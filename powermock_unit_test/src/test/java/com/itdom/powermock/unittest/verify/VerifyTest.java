package com.itdom.powermock.unittest.verify;

import com.itdom.powermock.unittest.commen.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 使用verify验证函数是否正常执行
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService4Verify.class)
public class VerifyTest {
    @Test
    public void saveOrUpdateTest() throws Exception {
        UserDao4Verify dao4Verify = PowerMockito.mock(UserDao4Verify.class);
        User user = PowerMockito.mock(User.class);

        PowerMockito.whenNew(UserDao4Verify.class).withAnyArguments().thenReturn(dao4Verify);
        PowerMockito.when(dao4Verify.getCount()).thenReturn(1);
        UserService4Verify userService4Verify = new UserService4Verify();
        userService4Verify.saveOrUpdate(user);
        Mockito.verify(dao4Verify,Mockito.never()).insertUser(user);
        Mockito.verify(dao4Verify).update(user);
    }
}
