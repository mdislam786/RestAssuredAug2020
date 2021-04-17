package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage  {
	

	public static String getData(String columnName) throws ClassNotFoundException, SQLException {
		// Setting properties for mysql
		Class.forName("com.mysql.cj.jdbc.Driver");		
		String sqlUrl = "jdbc:mysql://localhost:3306/august2020";
		String sqlUsername = "root";
		String sqlPass = "admin";
		String query = "select * from users";		
		// creating a connection to your local database
		Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPass);		
		// empowering the con reference valiable to execute queries
		Statement smt = con.createStatement();		
		// delivering the sql query
		ResultSet rs = smt.executeQuery(query);		
		while (rs.next()) {
		return	rs.getString(columnName);
		}
		
		return columnName;
		}

}
