package com.cydeo.jdbctests.practice;

import com.cydeo.jdbctests.utility.DB_Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PracticeLibrary {
    String url = "jdbc:mysql://54.157.236.232:3306/library2";
            String username="library2_client";
    String password="6s2LQQTjBcGFfDhY";

@Test
    public void testUserCount(){

    DB_Util.createConnection(url,username,password);

    DB_Util.runQuery("select count(*) from books");

   String expectedCount = DB_Util.getFirstRowFirstColumn();
    System.out.println(expectedCount);

    String actualCount = "7358";
   // Assertions.assertEquals(expectedCount,actualCount);

    //DB_Util.destroy();


}

@Test
    public  void testDashboard(){
    DB_Util.createConnection(url,username,password);

    DB_Util.runQuery("select * from DashBoard");





}


}
