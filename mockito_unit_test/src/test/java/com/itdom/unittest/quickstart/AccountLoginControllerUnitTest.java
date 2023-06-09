package com.itdom.unittest.quickstart;

import com.itdom.unittest.commen.Account;
import com.itdom.unittest.commen.AccountDao;
import com.itdom.unittest.commen.AccountLoginController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerUnitTest {
    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController accountLoginController;

    @Before
    public void setUp() throws Exception {
        accountDao = Mockito.mock(AccountDao.class);
        request = Mockito.mock(HttpServletRequest.class);
        accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess(){
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("zhangsan");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.exist(anyString(),anyString())).thenReturn(account);
        String login = accountLoginController.login(request);
        assertThat(login,equalTo("/index.jsp"));
    }
    @Test
    public void testLoginFail(){
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("zhangsan");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.exist(anyString(),anyString())).thenReturn(null);
        String login = accountLoginController.login(request);
        assertThat(login,equalTo("/login"));
    }

    @Test
    public void testLogin505(){
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("zhangsan");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.exist(anyString(),anyString())).thenThrow(UnsupportedOperationException.class);
        String login = accountLoginController.login(request);
        assertThat(login,equalTo("/505"));
    }
    @After
    public void close(){
    Mockito.reset(accountDao,request);
    }
}
