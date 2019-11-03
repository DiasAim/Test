package TS;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DatabaseConnection {
	protected static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException 
	    {
	        String dbDriver = "com.mysql.jdbc.Driver";
	        Class.forName(dbDriver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "qazxsw");
	        return con; 
	    } 
}
