package projekt;

/*
 * TODO
 * Setter f�r
 *  databaseName
 *  user
 *  password
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectAdmin {
	private final static String DEFAULT_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String DEFAULT_URL = "jdbc:sqlserver://";
	private final static String DEFAULT_COMPUTER_NAME = "localhost";
	private final static String DEFAULT_DB_SERVER_NAME = "MSSQLSERVER";
	private final static String DEFAULT_PORT_NUMBER = "1433";
	private final static String DEFAULT_DATABASE_NAME = "TestVSE2018BB";
	private final static String DEFAULT_USER_NAME = "adminuser";
	private final static String DEFAULT_PASSWORD = "admin123";

	private final String driver;
	private final String url;
	private final String computerName;
	private final String dbServerName;
	private final String portNumber;
	private final String databaseName;
	private final String userName;
	private final String password;
	
	/*
	 * Verbindungsdaten zu einer Default-DB.
	 * F�r andere DBs 
	 *    * die Setter implementieren und verwenden, oder
	 *    * einen Konstruktor mit entsprechenden Parametern implementieren.
	 */
	public ConnectAdmin() {
		driver = DEFAULT_DRIVER;
		url = DEFAULT_URL;
		computerName = DEFAULT_COMPUTER_NAME;
		dbServerName = DEFAULT_DB_SERVER_NAME;
		portNumber = DEFAULT_PORT_NUMBER;
		databaseName = DEFAULT_DATABASE_NAME;
		userName = DEFAULT_USER_NAME;
		password = DEFAULT_PASSWORD;
	}

	private String getConnectionUrl() {
		return url + computerName + "\\" + dbServerName + ":" + portNumber + ";databaseName=" + databaseName;
	}

	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(getConnectionUrl(), userName, password);
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
	
	public boolean checkConnection() {
		System.out.println(" +++ Trying Connection:");
		System.out.println(getInfoString());
		Connection con = getConnection();
		if (con != null) {
			ConnectAdmin.closeConnection(con);
			return true;
		}
		return false;
	}
	
	public String getInfoString() {
		return    "  * ComputerName: " + this.computerName + "\n"
				+ "  * DBServerName: " + this.dbServerName + "\n"
				+ "  * PortNumber:   " + this.portNumber + "\n"
				+ "  * DatabaseName: " + this.databaseName + "\n"
				+ "  * UserName:     " + this.userName + "\n"
				+ "  * Password:     " + this.password + "\n";
	}
}

