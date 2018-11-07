import java.sql.*;

public class Database {

	public static void main(String[] args) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * FROM sys.Flight");
			
			while (result.next())
			{
				System.out.println(result.getString("FlightID") + " " );
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
