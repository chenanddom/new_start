package com.itdom.unittest.commen;


import javax.servlet.http.HttpServletRequest;


public class AccountLoginController {

    AccountDao accountDao;


    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if (accountDao.exist(username, password) == null) {
                return "/login";
            } else {
                return "/index.jsp";
            }
        } catch (Exception e) {
            return "/505";
        }
    }
}
