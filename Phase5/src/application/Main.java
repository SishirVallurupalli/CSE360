//Author: Sishir Vallurupalli
package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;


public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		stg = primaryStage;
		primaryStage.setResizable(true);
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		primaryStage.setTitle("Effort Logger");
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();

	}
	
	public void changeScene(String fxml) throws IOException
	{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	public String getUserName()
	{
		return currentUser.getUserName();
	}
	
	public static ArrayList<UserInfo> users;
	
	public static UserInfo currentUser;
	
	public void setPassword(String pass)
	{
		currentUser.setPassword(pass);;
	}
	
	public String getPassword()
	{
		return currentUser.getPassword();
	}
	
	public String getEmpCode()
	{
		return currentUser.getEmpCode();
	}
	
	public ArrayList<UserInfo> getUsers()
	{
		return users;
	}
	
	public void setCurrentUser(UserInfo u)
	{
		currentUser = u;
	}
	
	public void addUser(UserInfo u)
	{
		users.add(u);
	}
	
	public static void main(String[] args) {
		users = new ArrayList<UserInfo>();
		UserInfo user = new UserInfo("admin", "123", "123");
		UserInfo user2 = new UserInfo("J", "1234", "1234");
		users.add(user2);
		users.add(user);
		currentUser = null;
		launch(args);
	}
	
	
	
}
