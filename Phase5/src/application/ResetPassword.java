package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
		if (m.getUserName().equals(username.getText().toString()) && (m.getEmpCode().equals(empCode.getText().toString())))
		{
			m.setPassword(password.getText().toString());
		}
	}
}
