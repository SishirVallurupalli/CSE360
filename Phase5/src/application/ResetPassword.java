package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;


public class ResetPassword {
	
	@FXML
	private Button reset;
	
	@FXML
	private Button goBack;

	
	@FXML 
	private Label wrongLogIn;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField empCode;
	
	public void goBack(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void resetPassowrd(ActionEvent event) throws IOException{
		Main m = new Main();
		ArrayList<UserInfo> users = m.getUsers();
		
		String us = username.getText().toString();
		String pass = password.getText().toString();
		String ec = empCode.getText().toString();
		boolean found = false;
		for (int x = 0; x < users.size(); x++)
		{
			if (us.equals(users.get(x).getUserName()) && ec.equals(users.get(x).getEmpCode()))
			{
				users.get(x).setPassword(pass);
				wrongLogIn.setText("Reset Succesful");
				found = true;
			}
		}
		if (!found)
			wrongLogIn.setText("Reset Unsuccesful");
	}
}
