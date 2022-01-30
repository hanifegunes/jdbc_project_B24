package com.cydeo.jdbctests.practice;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class practice03 {


    String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";


    @Test
    public  void  test1() throws SQLException {

        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = statement.executeQuery("select first_name, last_name from employees ");


        rs.next();
        System.out.println(rs.getString(1)+" "+ rs.getString(2));

        // row count?
        System.out.println(rs.getRow()+" row number");// will give your position
        int row = rs.getRow();// current row

        // first we will jump to the end will getrow

        rs.absolute(8);
        rs.absolute(row);
        System.out.println(row);
        rs.last();
        // go back previous
        rs.previous();
        rs.beforeFirst();
        System.out.println(row);
        System.out.println(row);

        while (rs.next()){

            System.out.println(rs.getString(1)+" "+ rs.getString(2));

        }








        rs.close();
        statement.close();
        conn.close();

    }

}
