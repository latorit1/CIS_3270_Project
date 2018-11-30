import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Login {

	@FXML
	private Label lblLogin;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	
	public void Login(ActionEvent event) {
		
		if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
			lblLogin.setText("Login Success");
		}
		else {
			lblLogin.setText("Login Failed");
			
		}
	}
		
}
