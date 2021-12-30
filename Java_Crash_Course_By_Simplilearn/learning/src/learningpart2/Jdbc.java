package learningpart2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) throws SQLException {
		//Creating connection
		String url = "jdbc:postgresql://localhost:5432/demo";
		Connection conn = null;
		
		int rollno = 13;
		String name = "Chandan";
		int age = 21;
//		String sql = "insert into student(rollno, name, age) " + "values(" + rollno
//				+ ",'" + name + "'," + age + ")";
		String sql = "insert into student values(?,?,?)";
		try {
			conn = DriverManager.getConnection(url, "postgres", "md5hashing");
			
//			Statement st = conn.createStatement();
			PreparedStatement st1 = conn.prepareStatement(sql);
			st1.setInt(1, age);
			st1.setInt(2, rollno);
			st1.setString(3, name);
			int m = st1.executeUpdate(); //DML; executeQuery for DQL;
//			int m = st.executeUpdate(sql);
			if (m==1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed!");
			}
			st1.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			conn.close();
		}
	}
}