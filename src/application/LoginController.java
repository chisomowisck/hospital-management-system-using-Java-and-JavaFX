
package application;
import java.net.URL;

import entity.User;

import java.sql.*;
import java.util.ResourceBundle;
import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	 
	public LoginController()
	{}
	
	@FXML
	private JFXTextField userbox;
	
	@FXML
	private JFXPasswordField passwordbox;
	
	@FXML
	private Button adminid;
	@FXML
	private Label labelbox;
	
	

	@FXML
	public void handleButton(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			
			}
			
		     Connection con = null;
		     try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
		     } catch (SQLException e) {
		 		
		 		e.printStackTrace();
		 	
		 	}
		     Statement st = (Statement) con.createStatement();
		  
		     st.executeQuery("SELECT userName, password FROM t_admin WHERE id=1;");
		     ResultSet rs = st.getResultSet();
		     while(rs.next()){
		    	  String dbUsername = rs.getString("userName");
		          String dbPassword = rs.getString("password");
    if(( userbox.getText()==dbUsername)&& (passwordbox.getText()==dbPassword));
   
   		{Stage stage1 = (Stage) adminid.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainViewFx.fxml"));

		AnchorPane pane = (AnchorPane) loader.load();
		
		AdminHomeController controller = loader.<AdminHomeController> getController();
		if (controller==null)
			System.out.println("controlleur login null");
		Scene scene = new Scene(pane);

		stage1.setScene(scene);
		stage1.show();
   		}
		

	
   
   	}
       }
}    	
   

