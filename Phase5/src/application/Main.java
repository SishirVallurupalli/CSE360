package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	private final String USERNAME = "admin";
	private String PASSWORD = "password";
	private final String EMPLOYEEID = "123456";
	
	@Override
	public void start(Stage primaryStage) {
		VBox loginBox = new VBox();
		loginBox.setSpacing(10);
        loginBox.setPadding(new Insets(10));
        loginBox.setAlignment(Pos.CENTER);
		
		//username area
		Label userNameLbl = new Label("UserName: ");
		TextField userNameField = new TextField();
		
		//password area
		Label passwordLbl = new Label("Password: ");
		TextField passwordField = new TextField();
		
		//login button 
		Button LoginButton = new Button("Login");
		Label validationLbl = new Label("");
		
		//reset password areaa
		Label resetTitle = new Label ("Reset Password");
		//username area
		Label userNameResetLbl = new Label("UserName");
		TextField userNameReset = new TextField();
		//password area
		Label passwordResetLbl = new Label("New Password: ");
		TextField passwordResestField = new TextField();
		//employeeid area
		Label employeeCodeLbl = new Label("Employee Code: ");
		TextField employeeID = new TextField();
		
		//reset password button
		Button resetPassword = new Button("Reset Password");
		
		
		
		//when button is clicked
		LoginButton.setOnAction(event -> {
			String userName = userNameField.getText();
			String password = passwordField.getText();
			// compares given username with correct username 
			//compares given password with correct password
			//would be handled in the back end server in the final effort logger
			if (userName.equals(USERNAME) && (password.equals(PASSWORD)))
			{
				validationLbl.setText("Login Successful");
			} else
			{
				validationLbl.setText("Login Unsuccessful");
			}
			
		});
		
		//when reset button is clicked
		resetPassword.setOnAction(event -> {
			String userName = userNameReset.getText();
			String password = passwordResestField.getText();
			String id = employeeID.getText();
			
			//if username and employee id are equal then the employee can reset their password
			//would be handled in the back end server in the actual program
			if ((userName.equals(USERNAME)) && (id.equals(EMPLOYEEID)))
			{
				PASSWORD = password;
				validationLbl.setText("Password Reset Successful");
			}
			else 
			{
				validationLbl.setText("Password Reset unsuccessful");
			}
		});
		
		
		loginBox.getChildren().addAll(
	                userNameLbl, userNameField,
	                passwordLbl, passwordField,
	                LoginButton, validationLbl, 
	                resetTitle, userNameResetLbl,
	                userNameReset,passwordResetLbl,
	                passwordResestField, employeeCodeLbl,
	                employeeID, resetPassword
	                );

		//BorderPane root = new BorderPane();
		Scene scene = new Scene(loginBox,400,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setTitle("Login Screen");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
