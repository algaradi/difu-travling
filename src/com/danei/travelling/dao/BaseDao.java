package com.danei.travelling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {


    // 封装增、删、改的方法
    public static boolean update(String sql, Object[] obj) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 循环遍历，设置实体类属性的占位符,i+1为第一个属性
            for (int i = 0; i < obj.length; i++) {
                pstm.setObject(i + 1, obj[i]);
            }
            // 执行sql语句，存储返回的值
            int count = pstm.executeUpdate();
            // 关闭资源
            pstm.close();
            conn.close();
            // 根据执行sql语句的返回值判断是否执行成功
            if (count > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }
    // 封装增、删、改的方法
    public static boolean update(String sql,int id) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 循环遍历，设置实体类属性的占位符,i+1为第一个属性
            pstm.setInt(1, id);
            // 执行sql语句，存储返回的值
            int count = pstm.executeUpdate();
            // 关闭资源
            pstm.close();
            conn.close();
            // 根据执行sql语句的返回值判断是否执行成功
            if (count > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    // 封装增、删、改的方法
    public static boolean update(String sql,String id) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 循环遍历，设置实体类属性的占位符,i+1为第一个属性
            pstm.setString(1, id);
            // 执行sql语句，存储返回的值
            int count = pstm.executeUpdate();
            // 关闭资源
            pstm.close();
            conn.close();
            // 根据执行sql语句的返回值判断是否执行成功
            if (count > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public static boolean update(String sql,String id1,String id2) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 循环遍历，设置实体类属性的占位符,i+1为第一个属性
            pstm.setString(1, id1);
            pstm.setString(2, id2);
            // 执行sql语句，存储返回的值
            int count = pstm.executeUpdate();
            // 关闭资源
            pstm.close();
            conn.close();
            // 根据执行sql语句的返回值判断是否执行成功
            if (count > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }
    public static boolean update(String sql,int id1,int id2) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 循环遍历，设置实体类属性的占位符,i+1为第一个属性
            pstm.setInt(1, id1);
            pstm.setInt(2, id2);
            // 执行sql语句，存储返回的值
            int count = pstm.executeUpdate();
            // 关闭资源
            pstm.close();
            conn.close();
            // 根据执行sql语句的返回值判断是否执行成功
            if (count > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public static boolean update(String sql,String  id1,int id2) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 循环遍历，设置实体类属性的占位符,i+1为第一个属性
            pstm.setInt(1, id2);
            pstm.setString(2, id1);

            // 执行sql语句，存储返回的值
            int count = pstm.executeUpdate();
            // 关闭资源
            pstm.close();
            conn.close();
            // 根据执行sql语句的返回值判断是否执行成功
            if (count > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }


    // 封装查询的方法
    public static ResultSet select(String sql) {
        // 创建连接对象
        Connection conn;
        // 创建预编译对象
        PreparedStatement pstm;
        // 创建结果集
        ResultSet res;
        try {
            // 连接数据库的用户名
            String username = "root";
            // 连接数据库的密码
            String password = "root";
            // 连接数据库的地址
            String url = "jdbc:mysql://localhost:3306/travling?useUnicode=true&characterEncoding=utf-8";
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 创建预编译对象，处理sql语句
            pstm = conn.prepareStatement(sql);
            // 创建结果集，执行查询的sql语句
            res = pstm.executeQuery();
            // 返回结果集
            return res;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
