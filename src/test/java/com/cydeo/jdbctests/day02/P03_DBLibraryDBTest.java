package com.cydeo.jdbctests.day02;

import com.cydeo.jdbctests.utility.DB_Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P03_DBLibraryDBTest {

    String  url="jdbc:mysql://54.157.236.232:3306/library2";
            String username="library2_client";
    String password ="6s2LQQTjBcGFfDhY";


    @Test
    public  void  testUserCount(){



        // Connnection
        DB_Util.createConnection(url, username, password);

        // run query
        DB_Util.runQuery("select count(*) from users");

        // get result from DB
        String expectedCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(expectedCount);
        /*
        implement getting data from UI for user Count as dynamiccly
        Normally you need to type code here to get info about userCount
         */
        // get result from UI
        String actualCount="7358";

        // compare them
        Assertions.assertEquals(expectedCount, actualCount);

        // destroy
        DB_Util.destroy();



    }

    @Test
    public  void  bookCount(){



        // Connnection
        DB_Util.createConnection(url, username, password);

        // run query
        DB_Util.runQuery("select count(*) from books");

        // get result from DB
        String expectedCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(expectedCount);
        /*
        implement getting data from UI for user Count as dynamiccly
        Normally you need to type code here to get info about userCount
         */
        // get result from UI
        String actualCount="23336";

        // compare them
        Assertions.assertEquals(expectedCount, actualCount);

        // destroy
        DB_Util.destroy();




    }





}
