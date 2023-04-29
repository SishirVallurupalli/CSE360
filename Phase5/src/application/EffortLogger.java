package application;

import java.io.IOException;
import java.net.URL;

import javax.security.auth.callback.TextInputCallback;

import javafx.application.Application;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class EffortLogger implements Initializable{
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
	private Label taskStarted;
	@FXML
	private ComboBox<String> categories;
	@FXML
	private TableView<EffortLog> tableView;
	@FXML
	private TableColumn<EffortLog, String> projectTypeColumn;
	@FXML
	private TableColumn<EffortLog, String> projectNameColumn;
	@FXML
	private TableColumn<EffortLog, String> userNameColumn;
	@FXML
	private TableColumn<EffortLog, Double> timeColumn;
	
	
	private ArrayList<EffortLog> effortList = new ArrayList<>();
	//Dictionary<String, EffortLog> tasks = new Hashtable<>(); 
	ObservableList<EffortLog> tableData = FXCollections.observableArrayList();
	long startTime;
	
	Main m = new Main();
	String username = m.getUserName();
	
	
	public void LogOut(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void addInputToComboBox(ActionEvent event) throws IOException 
	{
		comboBox.getItems().add(newTask.getText());
		EffortLog temp = new EffortLog(categories.getValue(), newTask.getText(), username, 0.0);
		effortList.add(temp);
		tableData.add(temp);
		tableView.setItems(tableData);
		newTask.clear();
	}
	
	public void startTask(ActionEvent event) throws IOException 
	{
		startTime = System.currentTimeMillis();
		time.setText("" + 0);
		taskStarted.setText(comboBox.getValue());
	}
	
	public void endTask(ActionEvent event) throws IOException {
		double timeElapsed = System.currentTimeMillis() - startTime;
		startTime = 0;
		int index = 0;
		for(int i = 0; i < effortList.size(); i++) {
			if(effortList.get(i).getProjectName().equals(comboBox.getValue())) {
				index = i;
			}
		}
		double getTime = effortList.get(index).getTime();
		EffortLog temp = new EffortLog(effortList.get(index).getProjectType(), comboBox.getValue(), username, getTime + timeElapsed);
		effortList.set(index, temp);
		double elapsedSeconds = getTime / 1000;
		double secondsDisplay = elapsedSeconds % 60;
		double elapsedMinutes = elapsedSeconds / 60;
		time.setText((int) elapsedMinutes + " minutes and " + secondsDisplay + " seconds");
	}

	public void refresh(ActionEvent event)
	{
		tableData.clear();

		for(EffortLog effort : effortList)
		{
			tableData.add(effort);
		}
		
		tableView.refresh();
	}

	public void deleteInput(ActionEvent event)
	{
		int selectID = tableView.getSelectionModel().getSelectedIndex();
		tableView.getItems().remove(selectID);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		categories.setItems(FXCollections.observableArrayList("Hardware", "Project Management", "Interface"));
		comboBox.setItems(FXCollections.observableArrayList("Project"));
		tableView.setItems(tableData);
		
		projectTypeColumn.setCellValueFactory(new PropertyValueFactory<EffortLog, String>("ProjectType"));
		projectTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		projectNameColumn.setCellValueFactory(new PropertyValueFactory<EffortLog, String>("ProjectName"));
		projectNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		userNameColumn.setCellValueFactory(new PropertyValueFactory<EffortLog, String>("userName"));
		userNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		timeColumn.setCellValueFactory(new PropertyValueFactory<EffortLog, Double>("Time"));
		timeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

		projectTypeColumn.setOnEditCommit(event -> {
         event.getTableView().getItems().get(event.getTablePosition().getRow()).setProjectType(event.getNewValue());
     	});

		projectNameColumn.setOnEditCommit(event -> {
         event.getTableView().getItems().get(event.getTablePosition().getRow()).setProjectName(event.getNewValue());
     	});
		
		tableView.setEditable(true);
		tableView.setItems(tableData);
	}
}
