package com.itdom;

import java.sql.*;

/**
 * 使用ParepareStatement实现t_user表的增删改查
 */
public class PrepareStatementTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        insertUser();
//        updateUser();
//        findUser();
//        deleteUser();
        batchInsertUser();
    }

    private static void insertUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc", "root", "root@123");
        String sqlStr = "insert into t_user(account,password,nickname) values (?,?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        //返回主键集
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,"zhangsan");
        preparedStatement.setString(2,"root@321");
        preparedStatement.setString(3,"nick_zhangsan");
        int i = preparedStatement.executeUpdate();
        if (i>0){
            System.out.println("插入成功！");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()){
                System.out.println("主键id:"+generatedKeys.getObject(1));
            }
        }else{
            System.out.println("插入失败！");
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }

    /**
     * 注意的几点：
     * 1、rewriteBatchedStatements=true 必须要配置允许批量插入
     * 2、insert into 后面必须时 values
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void batchInsertUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc?rewriteBatchedStatements=true", "root", "root@123");
        String sqlStr = "insert into t_user(account,password,nickname) values (?,?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        //返回主键集
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr,Statement.RETURN_GENERATED_KEYS);

        for (int i = 0; i < 1000; i++) {
            preparedStatement.setString(1,"zhangsan"+i);
            preparedStatement.setString(2,"root@321"+i);
            preparedStatement.setString(3,"nick_zhangsan"+i);
            preparedStatement.addBatch();
        }

        int[] executeBatch = preparedStatement.executeBatch();

        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }

    public static void updateUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc", "root", "root@123");
        String sqlStr = "update t_user set nickname=?,password=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setObject(1,"lisi");
        preparedStatement.setObject(2,"12345678910233454");
        preparedStatement.setObject(3,3);
        int i = preparedStatement.executeUpdate();
        if (i>0){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }

    public static void findUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc", "root", "root@123");
        String sqlStr = "select account,password,nickname from t_user";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
//        preparedStatement.setObject(1,3);
        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()){
//            String account = resultSet.getString(1);
//            String password = resultSet.getString(2);
//            String nickname = resultSet.getString(3);
//            System.out.println("account="+account+" password="+password+" nickname="+nickname);
//        }
//
//        if (preparedStatement!=null){
//            preparedStatement.close();
//        }
//        if (connection!=null){
//            connection.close();
//        }
        //使用元数据的方式自动获取列
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()){
            StringBuilder sb=new StringBuilder();
            for (int i = 1; i <=columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i);
                sb.append(columnLabel).append("=").append(resultSet.getObject(columnLabel)).append("\t");
            }
            System.out.println(sb.toString());

        }


    }


    public static void deleteUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn-jdbc", "root", "root@123");
        String sqlStr = "delete from t_user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setObject(1,3);
        int i = preparedStatement.executeUpdate();
        if (i>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }


}
