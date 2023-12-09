package com.itdom;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class StatementQueryTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动（此处会注册两次）
//        DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取链接
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc", "root", "root@123");
        //注意8.025以后serverTimezone=Asia/Shanghai可以省略，因为可以自动识别时区
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc?user=root&password=root@123&serverTimezone=Asia/Shanghai&useUnicode=true&characterEcoding=utf8&useSSL=true");
        //3.创建statement
        Statement statement = connection.createStatement();


        //4.发送sql语句，并且获取返回结果
        //5.进行结果集解析
        ResultSet resultSet = statement.executeQuery("select *from t_user");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String account = resultSet.getString("account");
            String nickname = resultSet.getString("nickname");

            System.out.println("id:" + id + " account:" + account + " " + " nickname:" + nickname);
        }


        //6.关闭资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
