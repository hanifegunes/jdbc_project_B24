package com.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P03_MetadataTest {
    String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {
        // DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        // Create statement from Connection to runQueries
        //  Statement statement = conn.createStatement();
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // using with statement we will execute query
        ResultSet rs = statement.executeQuery("select * from regions");
        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());
        System.out.println(dbMetaData.getDriverName());


        ResultSetMetaData rsmd = rs.getMetaData();// ResultSetMetaData  yaz alt enter

          int columnCount = rsmd.getColumnCount();
        System.out.println(columnCount);

        // how can i find 2.column name
        System.out.println(  rsmd.getColumnName(2));
        // print all column name dynamicly
        System.out.println( "dynamic print");
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(  rsmd.getColumnName(i));

        }
//region id 1
        //region name europa
        while (rs.next()){
            for (int i = 1; i <= columnCount ; i++) {
                System.out.println(rsmd.getColumnName(i)+"-"+rs.getString(i));
            }
        }


        // close conn
        rs.close();
        statement.close();
        conn.close();


    }

}
