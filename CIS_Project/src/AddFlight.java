import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddFlight {
	@FXML
	private TextField txtID;@FXML
	private TextField txtDest;@FXML
	private TextField txtOrigin;@FXML
	private TextField txtDate;@FXML
	private TextField txtDeparture;@FXML
	private TextField txtArrival;
	
	
	public void addFlight(ActionEvent event) throws SQLException, IOException {
		String id = txtID.getText();
		String dest = txtDest.getText();
		String origin = txtOrigin.getText();
		String departure = txtDeparture.getText();
		String arrival = txtArrival.getText();
		String date = txtDate.getText();
		
		PreparedStatement ps = null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			String sql = "INSERT INTO Flight (FlightID,cityOrigin, cityDestination, flightDate, flightDeparture, flightArrival) VALUES  (?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, origin);
			ps.setString(3, dest);
			ps.setString(4, date);
			ps.setString(5, departure);
			ps.setString(6, arrival);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ps.execute();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setContentText("Flight added!");
			alert.showAndWait();
			ps.close();
	}
}
	public void FlightMenu(ActionEvent event) throws SQLException, IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
		
	}
}
