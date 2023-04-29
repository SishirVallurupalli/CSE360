package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateAccount {
	@FXML
	private Button goBack;
	
	@FXML
	private Button signUp;
	
	@FXML
	private TextField usernameText;
	
	@FXML 
	private TextField passwordText;
	
	@FXML 
	private TextField empCodeText;
	
	@FXML
	private Label wrongLogIn;
	
	public void GoBack(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void SignUp(ActionEvent event) throws IOException
	{
		String username = usernameText.getText().toString();
		String password = passwordText.getText().toString();
		String empcode = empCodeText.getText().toString();
		
		UserInfo user = new UserInfo(username, password, empcode);
		Main m = new Main();
		m.addUser(user);
		wrongLogIn.setText(username + " account created");
	}
}
