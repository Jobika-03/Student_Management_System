package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	
	public static Connection DECon() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/match2","root","Jobika@2004");
	}

}
