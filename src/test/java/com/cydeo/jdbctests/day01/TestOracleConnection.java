package com.cydeo.jdbctests.day01;

import java.sql.*;

public class TestOracleConnection {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";


        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        //Create statement from connection to runQueries
        Statement statement= conn.createStatement();

        //using with satement we will execute query

      // statement.execute("select  * from regions");
        ResultSet rs =  statement.executeQuery("select  * from regions");


        rs.next(); // move to cursor first row
        //now we are at 1. row we will get data

        //1-europa
        //2 -americas

        //second row
        System.out.println(rs.getInt(1)+"-"+ rs.getString(2));

      //  rs.next();
       // System.out.println(rs.getInt("region_id")+ "-"+ rs.getString("region_name"));



        System.out.println(rs.getString("region_name"));
        System.out.println(rs.getString(2));

       // while (resultSet.next()){
        //    System.out.println(resultSet.getString(1)+"\t"+resultSet.getString("region_name"));
       // }

   // ResultSet rs = statement.executeQuery("select * from regions");





        //close connection for new connection, from end to beginning
        rs.close();
        statement.close();
       conn.close();










    }
}
