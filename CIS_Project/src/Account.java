import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Account implements Initializable{
	@FXML
	private Label lblID; @FXML
	private ListView<String> list1; @FXML
	private ListView<String> list2; @FXML
	private ListView<String> list3; @FXML
	private ListView<String> list4;@FXML
	private ListView<String> list5; @FXML
	private TextField delete;
	//HashMap containing all flights.Key is flightNumber
	static HashMap<Integer,Flights>flightList = new HashMap<Integer,Flights>();
	//HashMap holding all registered users. Key is userName
	 static HashMap<String,Users>userList = new HashMap<String,Users>();
		
		//create flight method increment flight count and set flight key = to that number;
		// ArrayList<Users>userList= new ArrayList<Users>();
		// ArrayList<Flights>flightList= new ArrayList<Flights>();
		//make hash maps for flights and users
		 //search for flights by destination and date
		 //print any matches
		 //have user get method with flight number

	
	// Button to go back to flight main menu
	public void FlightMenu(ActionEvent event) throws SQLException, IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
		
	}
	
	// Button to delete a flight from the database
	public void deleteFlight(ActionEvent event) throws SQLException, IOException {
		
		String deleteFlight = delete.getText();
		PreparedStatement ps = null;
		int result;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
		try {
			
			String sql = "DELETE FROM Booking WHERE FlightID = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, deleteFlight);

			result = ps.executeUpdate();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setContentText("Flight deleted. Please Refresh.");
			alert.showAndWait();
			
		} catch (SQLException exc) {
			exc.printStackTrace();
			
		} 
	}
	
	// Button to view flights that are on the user account
	public void viewFlight(ActionEvent event) throws SQLException, IOException {
		ObservableList<String> data = FXCollections.observableArrayList();
		ObservableList<String> data2 = FXCollections.observableArrayList();
		
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
		try {
			
			String sql = "SELECT * FROM Booking";
			ps = connection.prepareStatement(sql);
			
			list1.setItems(data);
			list2.setItems(data2);

			result = ps.executeQuery();
			
			while(result.next()) {
				data.add(result.getString(1));
			    data2.add(result.getString(2));
			}
			
		} catch (SQLException exc) {
			exc.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setContentText("No available flights, try again.");
				alert.showAndWait();
		} 
		
	}
	
	public void Refresh(ActionEvent event) throws SQLException, IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
	
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
}
