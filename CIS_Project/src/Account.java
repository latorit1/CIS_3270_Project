import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
public class Account {
	
	private ObservableList<String> data; @FXML
	private ListView<String> list1; @FXML
	private ListView<String> list2; @FXML
	private ListView<String> list3; @FXML
	private ListView<String> list4;@FXML
	private ListView<String> list5; @FXML
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

	
	
	public void FlightMenu(ActionEvent event) throws SQLException, IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
		
	}
	
	public Account () {

		ObservableList<String> data = FXCollections.observableArrayList();
		ObservableList<String> data2 = FXCollections.observableArrayList();
		ObservableList<String> data3 = FXCollections.observableArrayList();
		ObservableList<String> data4 = FXCollections.observableArrayList();
		ObservableList<String> data5 = FXCollections.observableArrayList();
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
		try {
			
			String sql = "SELECT * FROM Flight WHERE cityOrigin = ? OR cityDestination = ? OR flightDate = ? OR flightDeparture = ? OR flightArrival = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, "");
			ps.setString(2, toCity);
			ps.setString(3, date);
			ps.setString(4, departureTime);
			ps.setString(5, arrivalTime);
			result = ps.executeQuery();
		
			
			list1.setItems(data);
			list2.setItems(data2);
			list3.setItems(data3);
			list4.setItems(data4);
			list5.setItems(data5);

			while(result.next()) {
			    data.add(result.getString(1));
			    data2.add(result.getString(2));
			    data3.add(result.getString(3));
			    data4.add(result.getString(4));
			    data5.add(result.getString(5));
			}
		}
		catch (SQLException exc) {
			exc.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setContentText("No available flights, try again.");
				alert.showAndWait();
		} 
		
	}
	
	
}
