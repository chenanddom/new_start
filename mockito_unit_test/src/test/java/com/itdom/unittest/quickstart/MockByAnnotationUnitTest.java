package com.itdom.unittest.quickstart;

import com.itdom.unittest.commen.Account;
import com.itdom.unittest.commen.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockByAnnotationUnitTest {
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void test(){
        Account exist = accountDao.exist("x", "y");
        System.out.println(exist);
    }

}
