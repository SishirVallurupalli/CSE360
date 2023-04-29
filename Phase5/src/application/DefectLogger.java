//Name : Mohammad Aljohany
// This is the main class for the Defect Logger application allows users to log and manage defects.

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
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

 @FXML
 private Button refresh;
 
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
     tableView.setOnKeyPressed(event -> {
         if (event.getCode().equals(KeyCode.ENTER)) {
             tableView.edit(tableView.getSelectionModel().getSelectedIndex(), null);
         } else if (event.getCode().equals(KeyCode.ESCAPE)) {
             tableView.getSelectionModel().getSelectedItem();
         }
     });
 }


 @FXML
 void addInput(ActionEvent event) {
	    String selectedDetails = comboBox1.getSelectionModel().getSelectedItem();
	    if(selectedDetails == null) {
	    	 String projectType = comboBox.getValue();
	         String details = textInput.getText();
	         Main m = new Main();
	         String username = m.getUserName();
	         
	         Defect projectDetails = new Defect(projectType, details, username);
	         defectList.add(projectDetails); 
	         tableView.getItems().add(projectDetails);
	         comboBox1.getItems().add(details); // add the details to comboBox1 items list
	         System.out.println("Project Type: " + projectType + ", Details: " + details + ", Username: " + username);
	         textInput.clear();
	         tableView.getSelectionModel().select(projectDetails);
	       
	    }
	    else {
	    	
	    	 String projectType = comboBox.getValue();
		        Main m = new Main();
		        String username = m.getUserName();
		        String defectDetails = textInput.getText().isEmpty() ? selectedDetails : textInput.getText();
		        Defect selectedDefect = new Defect(projectType, defectDetails, username);
		        tableData.add(selectedDefect);
	    	
    
	    }
 }




	@FXML
	void deleteInput(ActionEvent event) {
	    Defect selectedDefect = tableView.getSelectionModel().getSelectedItem();
	    if (selectedDefect != null) {
	        tableView.getItems().remove(selectedDefect);
	        defectList.remove(selectedDefect);
	    }
	}

	@FXML
	void goToEffortLogger(ActionEvent event) throws IOException {
	    Main m = new Main();
	    m.changeScene("EffortLogger.fxml");
	}
	
	@FXML
	void refresh(ActionEvent event) {
		for (Defect defect : tableData) {
            // Display updated values
            System.out.println("Username: " + defect.getUsername() + ", Details: " + defect.getDetails() + ", Type: " + defect.getType());
        }
	}

	@FXML
	void select(ActionEvent event) {
	    String selectedDetails = comboBox1.getSelectionModel().getSelectedItem();
	    String projectType = comboBox.getValue();
	    Main m = new Main();
	    String username = m.getUserName();
	    Defect selectedDefect = new Defect(projectType, selectedDetails, username);
	    tableData.add(selectedDefect);
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