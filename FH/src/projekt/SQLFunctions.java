package projekt;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

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

}
