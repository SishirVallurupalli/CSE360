package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;


public class DefectLogger extends Application implements Initializable {
private static Stage stg;

@FXML
private ComboBox<String> comboBox;
@FXML
private ComboBox<String> comboBox1;
@FXML
private TextField textInput;
@FXML
private TableView<Defect> tableView;

private ArrayList<Defect> defectList = new ArrayList<>();

@FXML
private TableColumn<Defect, String> username;
@FXML
private TableColumn<Defect, String> details;
@FXML
private TableColumn<Defect, String> type;
 ObservableList<Defect> tableData = FXCollections.observableArrayList();

 @Override
 public void initialize(URL url, ResourceBundle rb) {
     comboBox.setItems(FXCollections.observableArrayList("Project", "Business"));
     tableView.setItems(tableData);
     type.setCellValueFactory(new PropertyValueFactory<Defect , String>("type"));
     type.setCellFactory(TextFieldTableCell.forTableColumn());
     type.setOnEditCommit(event -> {
         event.getTableView().getItems().get(event.getTablePosition().getRow()).setType(event.getNewValue());
     });
     details.setCellValueFactory(new PropertyValueFactory<Defect , String>("details"));
     details.setCellFactory(TextFieldTableCell.forTableColumn());
     details.setOnEditCommit(event -> {
         event.getTableView().getItems().get(event.getTablePosition().getRow()).setDetails(event.getNewValue());
     });
     username.setCellValueFactory(new PropertyValueFactory<Defect , String>("username"));
     username.setCellFactory(TextFieldTableCell.forTableColumn());
     username.setOnEditCommit(event -> {
         event.getTableView().getItems().get(event.getTablePosition().getRow()).setUsername(event.getNewValue());
     });

     tableView.setEditable(true);
     tableView.setItems(tableData);
 }


	@FXML
	void addInput(ActionEvent event) {
	    String projectType = comboBox.getValue();
	    String details = textInput.getText();
	    String username = "John";

	    Defect projectDetails = new Defect(projectType, details, username);
	    defectList.add(projectDetails); 
	    tableView.getItems().add(projectDetails);
	    System.out.println("Project Type: " + projectType + ", Details: " + details + ", Username: " + username); // Add this line

	    textInput.clear();

	    // Select the newly added item
	    tableView.getSelectionModel().select(projectDetails);
	}



	@FXML
	void deleteInput(ActionEvent event) {
	    comboBox1.getItems().remove(comboBox1.getSelectionModel().getSelectedItem());
	}
	@FXML
	void goToEffortLogger(ActionEvent event) throws IOException {
	    Main m = new Main();
	    m.changeScene("EffortLogger.fxml");
	}
	@FXML
	void refresh(ActionEvent event) {
	    tableData.clear();

	   
	    for (Defect defect : defectList) {
	        tableData.add(defect);
	    }
	}

	public void start(Stage primaryStage) throws Exception{
		stg = primaryStage;
		primaryStage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("DeffectLogger.fxml"));
		primaryStage.setTitle("Defect Logger");
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();

	}
	
	
	
	
	public void changeScene(String fxml) throws IOException
	{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}