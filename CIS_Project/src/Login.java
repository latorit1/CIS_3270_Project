import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	
	public String UserID;
	
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
				Parent RegParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		        Scene RegScene = new Scene(RegParent);
		        
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		        
		        window.setScene(RegScene);
		        window.show();
				}
			
			if (txtUsername.getText().length() != 0 || txtPassword.getText().length() != 0) {
				if(login.isUser(txtUsername.getText(), txtPassword.getText())) {
					lblLogin.setText("User and Password is correct");
					Parent RegParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
			        Scene RegScene = new Scene(RegParent);
			        
			        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			        
			        window.setScene(RegScene);
			        window.show();
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("User");
					alert.setContentText("User and Password does not exist, please register.");
					alert.showAndWait();
					}			
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("User");
				alert.setContentText("Please input a username or password.");
				alert.showAndWait();
				}
			
			}	 
			catch (SQLException e) {
				
				e.printStackTrace();
		}
	}
			
	public void RegistrationButton (ActionEvent event) {
		
		try {
			Parent RegParent = FXMLLoader.load(getClass().getResource("Registration.fxml"));
	        Scene RegScene = new Scene(RegParent);
	        
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(RegScene);
	        window.show();
			
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

