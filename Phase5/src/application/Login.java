///Author: Sishir Vallurupalli
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
	public Login()
	{
		
	}
	
	@FXML
	private Button button;
	
	@FXML 
	private Label wrongLogIn;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	
	public void login(ActionEvent event) throws IOException{
		Main m = new Main();
		
		if (username.getText().toString().equals("admin") && password.getText().toString().equals("123"))
		{
			wrongLogIn.setText("Success!");
			
			m.changeScene("Menu.fxml");
		}
		else
		{
			wrongLogIn.setText("Wrong Log In!");
		}
		
		
	}
	
}
