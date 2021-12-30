
package net;

import java.sql.Connection;

import java.sql.DriverManager;

public class Net1 {

    
   public static Connection dbConn(){
   
       try {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Netbeansnew","root","1234");
           System.out.println("Database connected!.");
           System.out.println("Hi");
       return conn;
       }
       catch(Exception e){
       //e.printStackTrace();
           System.err.println("ERROR: "+e.getMessage());
       
       return null;
       }
       
   }
    
}
