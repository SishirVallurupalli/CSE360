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

public class Menu {
	public Menu()
	{
		
	}
	@FXML
	private Button logout;
	
	@FXML 
	private Button effortLogger;
	@FXML 
	private Button defectLogger;
	
	public void LogOut(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void EffortLoggerAction(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("EffortLogger.fxml");
	}
//	
//	public void DeffectLogger(ActionEvent event) throws IOException
//	{
//		Main m = new Main();
////		m.changeScene("DeffectLogger.fxml");
//	}
}
