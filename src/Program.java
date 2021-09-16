import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "123456789";
		
		//executeClassic(input);
		//executePrepared(input);
		
		//updateEmployeeLNameClassic("123456789", "O'Neill");
		updateEmployeeLNamePrepared("123456789", "O'Neill");
	}

	public static void executeClassic(String ssn) {
		
		
		try {
		
			String query = "SELECT * FROM Employee WHERE ssn = '"+ ssn +"'";
			Statement statement = Database.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				String fname = rs.getString("fname");
				String minit = rs.getString("minit");
				String lname = rs.getString("lname");
				
				System.out.println(fname +" "+ minit +" "+ lname);
			}
		
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void executePrepared(String ssn) {

		try {
			
			String query = "SELECT * FROM Employee WHERE ssn = ?";
			PreparedStatement statement = Database.getConnection().prepareStatement(query);
			statement.setString(1, ssn);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String fname = rs.getString("fname");
				String minit = rs.getString("minit");
				String lname = rs.getString("lname");
				
				System.out.println(fname +" "+ minit +" "+ lname);
			}
			
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateEmployeeLNameClassic(String ssn, String lname) {
		try {
			
			String query = "UPDATE Employee SET lname = '"+ lname +"' WHERE ssn = '"+ ssn +"'";
			Statement statement = Database.getConnection().createStatement();
			
			int result = statement.executeUpdate(query);
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateEmployeeLNamePrepared(String ssn, String lname) {
		
		try {
			
			String query = "UPDATE Employee SET lname = ? WHERE ssn = ?";
			
			PreparedStatement statement = Database.getConnection().prepareStatement(query);
			statement.setString(1, lname);
			statement.setString(2, ssn);
			
			int result = statement.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
