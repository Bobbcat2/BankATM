
package BankATMGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;

public class GUIUserLogin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button signIn;

    @FXML
    private TextField textUsername;
    
    @FXML
    private PasswordField textPassword;

    @FXML
    void clickBack(MouseEvent event) {
    	try {
    		Parent pane = FXMLLoader.load(GUIHomepage.class.getResource("GUIHomepage.fxml"));
    		Scene homepageScene = new Scene(pane, 600, 400);
    		Stage newStage = new Stage();
    		newStage.setScene(homepageScene);
    		newStage.setTitle("BankATM System Homepage");
    		newStage.show();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	back.getScene().getWindow().hide(); // close previous page
    }

    @FXML
    void clickSignIn(MouseEvent event) {
    	
    	// check the username and password in database 
    	
    	String strUsername = textUsername.getText();
    	String strPassword = textPassword.getText();
    	
    	// if login successfully
    	boolean loginss = false;
    	if (loginss) {
    		
    	}
    	else {
    		resetText();
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error occurs");
    		alert.setContentText("Wrong username or password!");
    		alert.showAndWait();
    	}
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'GUIUserLogin.fxml'.";
        assert signIn != null : "fx:id=\"signIn\" was not injected: check your FXML file 'GUIUserLogin.fxml'.";
        assert textPassword != null : "fx:id=\"textPassword\" was not injected: check your FXML file 'GUIUserLogin.fxml'.";
        assert textUsername != null : "fx:id=\"textUsername\" was not injected: check your FXML file 'GUIUserLogin.fxml'.";


    }

    private void resetText() {
    	textUsername.setText("");
    	textPassword.setText("");
    }
    
}
