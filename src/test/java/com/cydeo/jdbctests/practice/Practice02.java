package com.cydeo.jdbctests.practice;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice02 {

    String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";


    @Test
    public  void  test1() throws SQLException {

        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("select * from departments where manager_id is not null");

       while(rs.next()){

           System.out.println(rs.getInt(1)+"-"+ rs.getString(2)+"-"+ rs.getString(3)+"- "+ rs.getString(4));


       }

   rs.close();
       statement.close();
       conn.close();



    }





}
