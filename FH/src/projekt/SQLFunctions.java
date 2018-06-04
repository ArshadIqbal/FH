package projekt;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SQLFunctions {
	
	
	public static void insertAdmin() throws Exception {
		String SQLStatement = "INSERT INTO Kurs VALUES (10, 'PHP', 45)";
		try {
			Connection con = Connect.getConnection();
			PreparedStatement insert = (PreparedStatement) con.prepareStatement(SQLStatement);
			insert.executeUpdate();
		} catch (Exception e) {
			
			System.out.println(e.getLocalizedMessage());
		}finally {
			System.out.println("Function complete");
		}
		
		
	}
	
	public static boolean checkAdmin(String user, String password) {
		ResultSet rs;
		Statement st;
		String SQLStatement = "SELECT Username, Password from Admin "
				+ "where Username ='" + user + "' and Password = '" + password + "'";
	
		try {
			Connection con = Connect.getConnection();
			st = (Statement) con.createStatement();
			rs = st.executeQuery(SQLStatement);
			int count = 0;
			
			while (rs.next()) {
				count = count +1;
			}
			if (count == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return false;
	}
	

}
