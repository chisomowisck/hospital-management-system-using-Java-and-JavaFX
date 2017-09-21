package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.event.EventHandlerManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class FirstView extends Application{
	
	
	
	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	
	
	
	    @Override
	    
	    public void start(Stage primaryStage) throws Exception{
	    	
	 
	    	Parent root = FXMLLoader.load(getClass().getResource("FirstViewFront.fxml"));
	    	
	        primaryStage.setTitle("hospital system");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	    }

	
		
		





}
