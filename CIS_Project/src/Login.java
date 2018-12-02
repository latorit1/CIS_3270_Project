import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Login {

	//Login variables
	@FXML
	private Label lblLogin;
	@FXML
	private TextField txtUsername;
	@FXML
	private TextField txtPassword;
	
	
	//Connection test
	public Login () throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
		if (connection == null) {
			
			System.out.println("Connection is not successful");
			System.exit(1);
		}
		
	}
	
	//Login button
	public void Login (ActionEvent event) throws SQLException, IOException {
		Login login = new Login();
		try { 
			
			if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("CIS3270")) {
				lblLogin.setText("Admin Login Success");
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
				Scene scene = new Scene(root, 400, 400);
				primaryStage.setScene(scene);
				primaryStage.show();
				}
			
			if (txtUsername.getText().length() != 0 || txtPassword.getText().length() != 0) {
				if(login.isUser(txtUsername.getText(), txtPassword.getText())) {
					lblLogin.setText("User and Password is correct");
					Stage primaryStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
					Scene scene = new Scene(root, 400, 400);
					primaryStage.setScene(scene);
					primaryStage.show();
				} else {
					lblLogin.setText("User and Password does not exist, please register");
					}			
			} else {
				lblLogin.setText("Please input a username and password");
				}
			
			}	 
			catch (SQLException e) {
				lblLogin.setText("User and Password is not correct");
				e.printStackTrace();
		}
	}
			
	public void Registration (ActionEvent event) {
		
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
			Scene scene = new Scene(root, 700, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Check and verify Username and Password in database		
	public boolean isUser(String username, String password) throws SQLException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			String sql = "SELECT username, password FROM User WHERE username = ? AND password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			result = ps.executeQuery();
			
			if (result.next())
			{
				return true;	
			} else {
				return false;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
			return false;
		} finally {
			ps.close();
			result.close();
		}
		
	}
		
}

