package com.br.lobato.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DB_Vaccine {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				DriverManager.getConnection(url, props);
	}
		catch (SQLException e) {
			throw new DbException_Vaccine(e.getMessage());
		}
	}	
	return conn;
}	

	public static void closeConnection() {
		if (conn != null) {
			try { 
				conn.close();
			}
			catch (SQLException e ) {
				throw new DbException_Vaccine(e.getMessage());
			}
		}
	}
	
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.propertiesVaccine")) {
			Properties props = new Properties();
			props.load(fs);
			return props;		
	}
	catch (IOException e ) {
		throw new DbException_Vaccine (e.getMessage());
	}
  }
	
	public 
	
}
