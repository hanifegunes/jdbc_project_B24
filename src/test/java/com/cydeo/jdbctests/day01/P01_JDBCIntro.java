package com.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P01_JDBCIntro {

    String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
public  void task()throws SQLException {

        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        //Create statement from connection to runQueries
        Statement statement = conn.createStatement();

        //using with satement we will execute query

        // statement.execute("select  * from regions");
        ResultSet rs = statement.executeQuery("select  * from departments where manager_id is not null");
        // using with statement we will execute query
      //  ResultSet rs=statement.executeQuery("select first_name,last_name from employees");


        while(rs.next()){


            System.out.println(rs.getInt(1)+"-"+rs.getString("department_name")

            +"-"+ rs.getInt(3)+"-"+ rs.getInt(4));
        }




        rs.close();
        statement.close();
        conn.close();



    }

}
