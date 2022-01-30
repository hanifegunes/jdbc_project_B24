package com.cydeo.jdbctests.practice;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice01 {
    public static  void  main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("select * from regions");

        /*

        rs.next();

        System.out.println(rs.getString(2)+" "+ rs.getString("region_name"));

        rs.next();
        System.out.println(rs.getString(2)+" "+ rs.getString("region_name"));


         */
        while(rs.next()){

            System.out.println(rs.getString(1)+" "+ rs.getString("region_name"));

        }



   rs.close();
        statement.close();
conn.close();
    }

}
