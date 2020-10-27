package cn.guardwhy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo01 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.创建数据库链接对象
            connection = DriverManager.getConnection("jdbc:mysql:///spring", "root", "root");
            // 3.定义sql语句
            String sql = "select * from cst_customer";
            // 4.创建Statement语句对象
            psmt = connection.prepareStatement(sql);
            // 5.执行操作
            rs = psmt.executeQuery();
            // 6.处理结果集
            while (rs.next()){
                System.out.println("客户Id:" + rs.getInt("cust_id") + ", 客户名称:" + rs.getString("cust_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if(rs != null) rs.close();
                if(psmt != null) psmt.close();
                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
