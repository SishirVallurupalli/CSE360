package application;

import java.io.IOException;

import javax.security.auth.callback.TextInputCallback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Dictionary;
import java.util.Hashtable;

public class EffortLogger {
	public EffortLogger()
	{
		
	}
	
	@FXML
	private Button logout;
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private TextField newTask;
	
	@FXML
	private Label time;
	
	Dictionary<String, Double> tasks = new Hashtable<>(); 
	long startTime;
	
	
	public void LogOut(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void bleh(ActionEvent event) {
		System.out.print("bleh");
	}
	
	public void addInputToComboBox(ActionEvent event) throws IOException 
	{
		comboBox.getItems().add(newTask.getText());
		tasks.put(newTask.getText(), 0.0);
		newTask.clear();
	}
	
	public void startTask(ActionEvent event) throws IOException 
	{
		startTime = System.currentTimeMillis();
		time.setText("" + 0);
	}
	
	public void endTask(ActionEvent event) throws IOException {
		double timeElapsed = System.currentTimeMillis() - startTime;
		startTime = 0;
		double getTime = tasks.get(comboBox.getValue());
		tasks.put(comboBox.getValue(), getTime + timeElapsed);
		double elapsedSeconds = tasks.get(comboBox.getValue()) / 1000;
		double secondsDisplay = elapsedSeconds % 60;
		double elapsedMinutes = elapsedSeconds / 60;
		time.setText((int) elapsedMinutes + " minutes and " + secondsDisplay + " seconds");
	}
}
