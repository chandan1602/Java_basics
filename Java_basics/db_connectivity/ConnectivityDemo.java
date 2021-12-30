
package connectivitydemo;

import java.sql.Connection;


public class ConnectivityDemo {
  
    public static void main(String[] args) 
    {
        Connection c=Connectivity.dbConnection();
        
        System.out.println("Welcome");
        System.out.println("hiii");
        
        
    }
    
}
