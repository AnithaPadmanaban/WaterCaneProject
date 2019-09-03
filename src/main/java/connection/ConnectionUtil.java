package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection(){
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/water_db";
		String userName="root";
		String password="Anitha@6";
		Connection con=null;
		try {
		Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		   try {
		con = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.out.println(con);
		return con;
		}
}
