package com.neuedu.main;

import com.mysql.jdbc.Driver;
import com.neuedu.pojo.Test;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Way{

    public static final String url = "jdbc:mysql://127.0.0.1:3306/test_jdbc";//数据库的位置
    public static final String name = "root";//用户名
    public static final String psw = "1234";//密码
    String sql = null;//sql语句

    Connection conn = null ;//获取连接
    Statement stat = null ;//创建声明
    ResultSet rs = null ;//执行sql语句

    List<Test> list = new ArrayList<>();//集中整装

    static {
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*增删改*/
    public void executeWay(String sql , Object... obs){

        try {
            conn = DriverManager.getConnection(url,name,psw);
            PreparedStatement pstm = conn.prepareStatement(sql);
            this.sql = sql;

            if (obs != null){
                for (int i = 0 ; i < obs.length ;i++){
                    pstm.setObject(i+1,obs[i]);
                }
            }
            int rs = pstm.executeUpdate();
            System.out.println( rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.cloF(conn,stat,null);
        }
    }
    /*查询*/
    public void sel(String sql , Object... obs){

        try {
            conn = DriverManager.getConnection(url,name,psw);//路径 + 用户名 + 密码
            PreparedStatement pstm = conn.prepareStatement(sql);
            this.sql = sql;
            rs = pstm.executeQuery(sql);//执行sql命令
            while( rs.next()){
                int id = rs.getInt("id");
                String tname = rs.getString("tname");
                Test test = new Test(id,tname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.cloF(conn,stat,rs);
        }
    }
    /*关闭方法*/
    public void cloF( Connection conn,Statement stat,ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
