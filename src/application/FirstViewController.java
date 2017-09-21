package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class FirstViewController implements Initializable{

	@FXML
	JFXButton logid,listid;
	
 public FirstViewController(){}

 @FXML
  private AnchorPane rootpane;
 
 @FXML
	private void loginButton(javafx.event.ActionEvent event) throws IOException
	{
		Stage stage1 = (Stage)logid.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Logf.fxml"));

		AnchorPane pane = (AnchorPane) loader.load();
		
		LoginController controller = loader.<LoginController> getController();
		if (controller==null)
			System.out.println("controlleur login null");
		Scene scene = new Scene(pane);

		stage1.setScene(scene);
		stage1.show();
	}
 
 @FXML
	private void registration(ActionEvent event) throws IOException
	{
	 
	 AnchorPane pane = FXMLLoader.load(getClass().getResource("PatientRegistrationFront.fxml"));
    rootpane.getChildren().setAll(pane);
	}
		
 @FXML
	private void listhundle(ActionEvent event) throws IOException
	{
	 
	 
		Stage stage1 = (Stage)listid.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ListFront.fxml"));

		AnchorPane pane = (AnchorPane) loader.load();
		
		ListController controller = loader.<ListController> getController();
		if (controller==null)
			System.out.println("controlleur list null");
		Scene scene = new Scene(pane);

		stage1.setScene(scene);
		stage1.show();
	}
 
		@Override
		public void initialize(URL location, ResourceBundle resources) {
		
			
		}
}
