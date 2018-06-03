package projekt;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:8889/FH";
	private static final String serverName = "localhost";
	private static final String portNumber = "8889";
	private static final String databaseName = "FH";
	private static final String userName = "root";
	private static final String password = "root";

	private static String getConnectionUrl() {
		return url + serverName + ":" + portNumber + ";databaseName=" + databaseName;
	}

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con != null) {
				System.out.println("Connection Successful!");
			}
		} 
		catch (Exception e) {
			System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getLocalizedMessage());
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
			con = null;
		} 
		catch (Exception e) {
			System.out.println("Fehler beim Beenden der Verbindung zur DB: " + e.getLocalizedMessage());
		}
	}
	
	public static boolean checkConnection() {
		Connection con = Connect.getConnection();
		if (con != null) {
			Connect.closeConnection(con);
			return true;
		}
		return false;
	}
}

