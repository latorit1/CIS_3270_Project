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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Registration {
	@FXML
	private TextField txtFirstName;@FXML
	private TextField txtLastName;@FXML
	private TextField txtAddress;@FXML
	private TextField txtZipcode;@FXML
	private TextField txtState;@FXML
	private TextField txtUsername;@FXML
	private TextField txtPassword;@FXML
	private TextField txtEmail;@FXML
	private TextField txtSocial;@FXML
	private TextField txtSecurityQ;@FXML
	private TextField txtSecurityA;
	
	public Registration () throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
		if (connection == null) {
			
			System.out.println("Connection is not successful");
			System.exit(1);
		}
		
	}
	
	public boolean toRegister(String FirstName,String LastName,String Address,String Zipcode,String State,String Username,String Password,String Email,String Social,String SecurityQ,String SecurityA) throws SQLException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			String sql = "INSERT INTO USER FROM VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(111, SecurityA);
			result = ps.executeQuery();
			
			if (result.next())
			{
				return true;	
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Delete ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
				alert.showAndWait();
				return false;
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			ps.close();
			result.close();
		}
		
		
	}
	
	public void Submit(ActionEvent event) throws SQLException {
		
	}
	
	public void switchScene(ActionEvent event) throws IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
	
	}
}
