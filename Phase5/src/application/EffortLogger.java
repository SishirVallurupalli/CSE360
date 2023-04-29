package application;

import java.io.IOException;
import java.net.URL;

import javax.security.auth.callback.TextInputCallback;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class EffortLogger{
	public EffortLogger()
	{
		
	}
	
	private static Stage stg;
	
	@FXML
	private Button logout;
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private TextField newTask;
	
	@FXML
	private Label time;
	
	@FXML
	private ComboBox<String> categories;
	
	Dictionary<String, EffortLog> tasks = new Hashtable<>(); 
	long startTime;
	
	
	public void LogOut(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void addInputToComboBox(ActionEvent event) throws IOException 
	{
		comboBox.getItems().add(newTask.getText());
		EffortLog temp = new EffortLog(categories.getValue(), newTask.getText(), null, 0.0);
		tasks.put(newTask.getText(), temp);
		newTask.clear();
	}
	
	
	public void editInput(ActionEvent event) throws IOException
	{
		
	}
	
	public void startTask(ActionEvent event) throws IOException 
	{
		startTime = System.currentTimeMillis();
		time.setText("" + 0);
	}
	
	public void endTask(ActionEvent event) throws IOException {
		double timeElapsed = System.currentTimeMillis() - startTime;
		startTime = 0;
		double getTime = tasks.get(comboBox.getValue()).getTime();
		EffortLog temp = new EffortLog(tasks.get(comboBox.getValue()).getProjectType(), comboBox.getValue(), null, getTime + timeElapsed);
		tasks.put(comboBox.getValue(), temp);
		double elapsedSeconds = tasks.get(comboBox.getValue()).getTime() / 1000;
		double secondsDisplay = elapsedSeconds % 60;
		double elapsedMinutes = elapsedSeconds / 60;
		time.setText((int) elapsedMinutes + " minutes and " + secondsDisplay + " seconds");
	}
}
