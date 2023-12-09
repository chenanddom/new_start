package com.itdom;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest {
    public static void main(String[] args) {

    }

    public static void method1() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/learn-jdbc");
        dataSource.setUsername("root");

        dataSource.setPassword("root@123");

        DruidPooledConnection connection = dataSource.getConnection();


        connection.close();
    }

    public static void soft() throws Exception {
        //1.读取外部配置文件 Properties
        Properties properties = new Properties();

        //src下的文件，可以使用类加载器提供的方法
        InputStream resourceAsStream = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);

        //2.使用连接池的工具类的工厂模式，创建连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //3.获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //4.数据库crud

        //5.回收连接
        connection.close();

    }

}
