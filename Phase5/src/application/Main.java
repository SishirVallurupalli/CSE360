//Author: Sishir Vallurupalli


package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		stg = primaryStage;
		primaryStage.setResizable(true);
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		primaryStage.setTitle("Effort Logger");
		primaryStage.setScene(new Scene(root, 300, 300));
		primaryStage.show();

	}
	
	public void changeScene(String fxml) throws IOException
	{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	public static String userName;
	public static String password;
	public static String empCode;
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setPassword(String pass)
	{
		password = pass;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getEmpCode()
	{
		return empCode;
	}
	
	
	public static void main(String[] args) {
		userName = "admin";
		password = "123";
		empCode = "123";
		launch(args);
	}
	
	
	
}
