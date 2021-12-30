
package net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Net {

    public static void main(String[] args) {
        try {        
            // TODO code application logic here
            Connection conn = Net1.dbConn();
            PreparedStatement ps=null;
            ResultSet rs=null;
            
            
            ps=conn.prepareStatement("select * from student");
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                System.out.println("id is "+rs.getString(1));
            }
            /*
            try {
            String name;
            char gender;
            int id,h,e,t;
            float avg;
            Scanner s=new Scanner(System.in);
            System.out.print("Enter Id:");
            id=s.nextInt();
            System.out.print("Enter Name:");
            name=s.next();
            System.out.print("Enter Gender:");
            gender=s.next().charAt(0);
            System.out.print("Enter hindi marks:");
            h=s.nextInt();
            System.out.print("Enter eng marks:");
            e=s.nextInt();
            t=h+e;
            avg=t/2;
            //insert data
            ps=conn.prepareStatement("insert into student values('"+id+"','"+name+"','"+gender+"','"+h+"','"+e+"','"+t+"','"+avg+"')");
            ps.executeUpdate();
            System.out.println("data inserted");
            
            
            
            } catch (SQLException ex) {
            Logger.getLogger(Net.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Net.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
}
