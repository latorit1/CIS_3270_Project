import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Main {

	@FXML
	private TextField txtFromCity;@FXML
	private TextField txtToCity;@FXML
	private TextField txtDate;@FXML
	private TextField txtDepartureTime;@FXML
	private TextField txtArrivalTime;@FXML
	private Label Flight1; @FXML
	private Label Flight2; @FXML
	private Label Flight3;@FXML
	private ObservableList<String> data; @FXML
	private ListView<String> list1; @FXML
	private ListView<String> list2; @FXML
	private ListView<String> list3; @FXML
	private ListView<String> list4;@FXML
	private ListView<String> list5;
	
	public Main () throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
		if (connection == null) {
			
			System.out.println("Connection is not successful");
			System.exit(1);
		}
		
	}
	
	public void Search(ActionEvent event) throws SQLException, IOException {
		String fromCity = txtFromCity.getText();
		String toCity = txtToCity.getText();
		String date = txtDate.getText();
		String departureTime = txtDepartureTime.getText();
		String arrivalTime = txtArrivalTime.getText();
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
			ps.setString(1, fromCity);
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

			while (result.next()) {
			    data.add(result.getString(1));
			    data2.add(result.getString(2));
			    data3.add(result.getString(3));
			    data4.add(result.getString(4));
			    data5.add(result.getString(5));
			}
			
		
			
			while (result.next()) {
			    
			}
		
			
	/*		if (result.next())
			{
				Flight1.setText(result.getString(1) + " " + result.getString("cityOrigin") + " -> " + result.getString("cityDestination") + " " + result.getString("flightDate") + " " + result.getString("flightDeparture")+ " " + result.getString("flightArrival"));
				Flight2.setText(result.getString(2) + " " + result.getString("cityOrigin") + " -> " + result.getString("cityDestination") + " " + result.getString("flightDate") + " " + result.getString("flightDeparture")+ " " + result.getString("flightArrival"));
		
				
			 Parent RegParent = FXMLLoader.load(getClass().getResource("FlightBook.fxml"));
		        Scene RegScene = new Scene(RegParent);
		        
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		        
		        window.setScene(RegScene);
		        window.show(); 
			} */
			
				
		}
		catch (SQLException exc) {
			exc.printStackTrace();
		} 
	}
		
/*		try {
			if (txtToCity.getText().length() != 0) {
				if(main.toSearch(txtFromCity.getText(), txtToCity.getText(), txtDate.getText(), txtDepartureTime.getText(), txtArrivalTime.getText())) {
					Flight1.setText(txtFromCity.getText() + " " + txtToCity.getText() + " " + txtDate.getText() + " " + txtDepartureTime.getText()+ " " + txtArrivalTime.getText());
				} else {
					Flight1.setText("No available flights");
					}
			} else {
					Flight1.setText("Enter a Destination");
				}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
*/	
	
	
}
