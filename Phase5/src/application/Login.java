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
import java.util.ArrayList;

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
	private TextField passwordText;
	
	@FXML
	private Button resetPassword;
	

	
	
	public void login(ActionEvent event) throws IOException{
		Main m = new Main();
		
		ArrayList<UserInfo> users = m.getUsers();
		
		String user = username.getText().toString();
		String pass = passwordText.getText().toString();
		for (int x = 0; x < users.size(); x++)
		{
			if (users.get(x).getUserName().equals(user))
			{
				if (users.get(x).getPassword().equals(pass))
				{
					m.setCurrentUser(users.get(x));
					m.changeScene("Menu.fxml");
					break;
				}
			}
		}
		wrongLogIn.setText("Wrong Log In Information");
		
		
	}
	
	public void ResetPassword(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("ResetPassword.fxml");
	}
	
	

}
