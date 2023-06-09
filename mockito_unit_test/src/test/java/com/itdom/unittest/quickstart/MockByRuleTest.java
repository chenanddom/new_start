package com.itdom.unittest.quickstart;


import com.itdom.unittest.commen.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

/**
 * 这种方式是为了规避使用@RunWith(MockitoJUnitRunner.class)情况下，如果想使用powermock就无法使用
 */
public class MockByRuleTest {
     @Rule()
    public MockitoRule mockitoRule =  MockitoJUnit.rule();
    @Mock(answer= Answers.RETURNS_SMART_NULLS)
    AccountDao accountDao;
     @Test
     public void testRule(){
//          AccountDao mock = mock(AccountDao.class);
//          System.out.println(mock.exist("x","y"));
          System.out.println(accountDao.exist("x","y"));
     }

}
