import javafx.scene.Node;
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

public class Main {

	@FXML
	private TextField txtFromCity;@FXML
	private TextField txtToCity;@FXML
	private TextField txtDate;@FXML
	private TextField txtDepartureTime;@FXML
	private TextField txtArrivalTime;@FXML
	private Label Flight1;
	
	
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

		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			String sql = "SELECT cityOrigin, cityDestination, flightDate, flightDeparture, flightArrival FROM Flight WHERE cityOrigin = ? OR cityDestination = ? OR flightDate = ? OR flightDeparture = ? OR flightArrival = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, fromCity);
			ps.setString(2, toCity);
			ps.setString(3, date);
			ps.setString(4, departureTime);
			ps.setString(5, arrivalTime);
			result = ps.executeQuery();
			
			if (result.next())
			{
				
			}
				
		}
		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (toCity.length() != 0) {
			Flight1.setText(fromCity + " " + toCity + " " + date + " " + departureTime + " " + arrivalTime);
			} else {
				Flight1.setText("No available flights");
			}
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
	public boolean toSearch(String fromCity, String toCity, String date, String departureTime, String arrivalTime) throws SQLException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "AppDevCIS2018");
			String sql = "SELECT cityOrigin, cityDestination, flightDate, flightDeparture, flightArrival FROM Flight WHERE cityOrigin = ? OR cityDestination = ? OR flightDate = ? OR flightDeparture = ? OR flightArrival = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, fromCity);
			ps.setString(2, toCity);
			ps.setString(3, date);
			ps.setString(4, departureTime);
			ps.setString(5, arrivalTime);
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
