package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminHomeController implements Initializable{

	@FXML
	JFXButton dentalid,cardiologyid,earid;
	
	
	@FXML
	private void dentalAccess(javafx.event.ActionEvent event) throws IOException
	{
		Stage stage1 = (Stage) dentalid.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DentalFront.fxml"));

		AnchorPane pane = (AnchorPane) loader.load();
		
		DantalFrontController controller = loader.<DantalFrontController > getController();
		if (controller==null)
			System.out.println("controlleur login null");
		Scene scene = new Scene(pane);

		stage1.setScene(scene);
		stage1.show();
	}
	
	@FXML
	private void cardiologyAccess(javafx.event.ActionEvent event) throws IOException
	{
		Stage stage1 = (Stage)cardiologyid.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CardiologyFront.fxml"));

		AnchorPane pane = (AnchorPane) loader.load();
		
		CardiologyFrontController controller = loader.<CardiologyFrontController> getController();
		if (controller==null)
			System.out.println("controlleur login null");
		Scene scene = new Scene(pane);

		stage1.setScene(scene);
		stage1.show();
	}
	@FXML
	private void earaccess(javafx.event.ActionEvent event) throws IOException
	{
		Stage stage1 = (Stage) earid.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EarFrontController.fxml"));

		AnchorPane pane = (AnchorPane) loader.load();
		
		EarFrontController controller = loader.<EarFrontController > getController();
		if (controller==null)
			System.out.println("controlleur login null");
		Scene scene = new Scene(pane);

		stage1.setScene(scene);
		stage1.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}
}
