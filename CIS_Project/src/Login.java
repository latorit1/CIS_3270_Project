import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Login {

	@FXML
	private Label lblLogin;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	
	public void Login(ActionEvent event) throws Exception{
		
		if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("CIS3270")) {
			lblLogin.setText("Admin Login Success");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else if (txtUsername.getText().length() == 0 || txtPassword.getText().length() == 0) {
			
			
		}
		else {
			lblLogin.setText("Login Failed");
			
		}
	}
	
	public void User() {
		

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * FROM sys.User");
			
			while (result.next())
			{
				String x = result.getString("username"); 
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
		
}
