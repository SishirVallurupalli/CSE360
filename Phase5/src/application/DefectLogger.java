package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class DefectLogger extends Application implements Initializable {
private static Stage stg;

@FXML
private ComboBox<String> comboBox;
@FXML
private ComboBox<String> comboBox1;
@FXML
private TextField textInput;

	@Override
    public void initialize(URL url, ResourceBundle rb) {
	
    comboBox.setItems(FXCollections.observableArrayList("Project", "Business"));
    comboBox1.setItems(FXCollections.observableArrayList("input errors"));

}
	@FXML
	void addInput(ActionEvent event) {
		comboBox1.getItems().add(textInput.getText());
		textInput.clear();
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
