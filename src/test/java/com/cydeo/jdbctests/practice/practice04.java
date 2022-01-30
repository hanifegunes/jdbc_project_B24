package com.cydeo.jdbctests.practice;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class practice04 {


    String dbUrl = "jdbc:oracle:thin:@34.227.22.155:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";


    @Test
    public  void  test1() throws SQLException {

        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = statement.executeQuery("select * from employees ");

        DatabaseMetaData dbMetadata = conn.getMetaData();

        dbMetadata.getUserName();
        System.out.println( dbMetadata.getUserName());
        System.out.println(dbMetadata.getDatabaseProductName());
        System.out.println(dbMetadata.getDatabaseProductVersion());
        System.out.println(dbMetadata.getDriverName());
        System.out.println(dbMetadata.getDriverVersion());


        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        System.out.println( columnCount);

        rsmd.getColumnName(2);
        System.out.println(rsmd.getColumnName(2));

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsmd.getColumnName(i));
        }


        while (rs.next()){

            for (int i = 1; i < columnCount; i++) {
                System.out.println(rsmd.getColumnName(i)+"_"+rs.getString(i));

            }
        }





        rs.close();

        statement.close();
        conn.close();


    }


    }
