package online_food;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnecter {
	private static final String url = "jdbc:mysql://localhost:3306/FoodOrderDB";
	private static final String userName = "root";
	private static final String password = "N6520nnk#";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			System.out.println("database  connection is not succes");
		}
		return con;
	}
}
