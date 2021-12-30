/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectivitydemo;
//step 1 import sql package 
//import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connectivity {
 
    public static Connection dbConnection()
    {
        try
        {
        //load sql drivers
          
          //get database connection
          //getConnection("db url","username","password")
          Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/nic34t4", "root", "nict");
            System.out.println("Database connected");
          return c;
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
            
        }
        
    }
}
