import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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

import com.mysql.cj.xdevapi.Result;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Registration {
	@FXML
	private Label lblDone;@FXML
	private TextField txtFirstName;@FXML
	private TextField txtLastName;@FXML
	private TextField txtAddress;@FXML
	private TextField txtZipcode;@FXML
	private TextField txtState;@FXML
	private TextField txtUsernameR;@FXML
	private TextField txtPasswordR;@FXML
	private TextField txtEmail;@FXML
	private TextField txtSocial;@FXML
	private TextField txtSecurityQ;@FXML
	private TextField txtSecurityA;
	
	// Clicking the submit will insert data into the database
	public void toRegister(ActionEvent event) throws SQLException, IOException {
		String FirstName = txtFirstName.getText();
		String LastName = txtLastName.getText();
		String Address = txtAddress.getText();
		String Zipcode = txtZipcode.getText();
		String State = txtState.getText();
		String Username = txtUsernameR.getText();
		String Password = txtPasswordR.getText();
		String Email = txtEmail.getText();
		String Social = txtSocial.getText();
		String SecurityQ = txtSecurityQ.getText();
		String SecurityA = txtSecurityA.getText();
		
		PreparedStatement ps = null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			String sql = "INSERT INTO User (firstName,LastName, address, zipCode, state, username, password, email, SSN, secQ, secA) VALUES  (?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, Address);
			ps.setString(4, Zipcode);
			ps.setString(5, State);
			ps.setString(6, Username);
			ps.setString(7, Password);
			ps.setString(8, Email);
			ps.setString(9, Social);
			ps.setString(10, SecurityQ);
			ps.setString(11, SecurityA);
			
		} catch(Exception e) {
			e.printStackTrace();
			lblDone.setText("Please fill out all fields.");
		} finally {
			ps.execute();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setContentText("User added!Press the back button to login.");
			alert.showAndWait();
			ps.close();
		}
		
		
	}
	// Switch scenes; sends the user back to Login screen
	public void switchScene(ActionEvent event) throws IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
	
	}
	
	
	
	
	
}
