package com.sist.temp;
import java.sql.*;

public class MainClass {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn=DriverManager.getConnection(url,"hr","happy");
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM emp");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "
									+rs.getString(2)+" "
									+rs.getString(3));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
