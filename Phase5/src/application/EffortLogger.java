package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
	
	public void LogOut(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
}
