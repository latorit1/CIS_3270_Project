import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationController {
	public void switchScene(ActionEvent event) throws IOException {
		Parent RegParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene RegScene = new Scene(RegParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegScene);
        window.show();
	
	}
}
