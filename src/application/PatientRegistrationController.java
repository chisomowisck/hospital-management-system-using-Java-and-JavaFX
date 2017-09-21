package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

public class PatientRegistrationController {

	
  public PatientRegistrationController() {}

	@FXML
	JFXButton backid,registerid;
	
	@FXML
	  private AnchorPane childpane;
	

@FXML
private JFXTextField nameBox;

@FXML
private JFXTextField lastNameBox;

@FXML
private JFXTextField phoneBox;

@FXML
private JFXTextField ageBox;
@FXML
private JFXDatePicker DateBox;

@FXML
private Label registerBox;
	  
@FXML
private JFXRadioButton dental,ent,cardiology;
///////////////////////////////////////////register//////////////////////////////////

	  @FXML
	  private void registerButton(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException

	  {
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
		     
		     String name = nameBox.getText();
		     String lastName = lastNameBox.getText();
		   String age = ageBox.getText();
	           String phone = phoneBox.getText();
		 
		    
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		     String date = (DateBox.getValue()).format(formatter);
		     
		     if (dental.isSelected())
		     
		     {
		    	 String sql = "INSERT INTO t_dental_register(firstName,lastName,phoneNum,age,date) values (?,?,?,?,?)";
		     
try{
		     java.sql.PreparedStatement pdt = con.prepareStatement(sql);
	         pdt.setString(1, name);
	         pdt.setString(2, lastName);
	        pdt.setString(3, phone);
	         pdt.setString(4, age);
	         pdt.setString(5,date);
	         int n1=pdt.executeUpdate();
		       if(n1>0)
		       {
		    	   registerBox.setText("registration succeed");
			    	  nameBox.clear();
			  	     lastNameBox.clear();
			  	     ageBox.clear();
			  	     phoneBox.clear();
			  	     
			  	  DateBox.getEditor().clear();
			  	 dental.setSelected(false);
			    
		       }
		  
		     }catch (SQLException ex) {
		    	   System.out.println("erreurrr");
		     }
		     }
		    

		       
		     else  if (cardiology.isSelected())
			     
		     {
		    	 String sql = "INSERT INTO t__cardiology_register(firstName,lastName,phoneNum,age,date) values (?,?,?,?,?)";
		     
try{
		     java.sql.PreparedStatement pdt = con.prepareStatement(sql);
	         pdt.setString(1, name);
	         pdt.setString(2, lastName);
	        pdt.setString(3, phone);
	         pdt.setString(4, age);
	         pdt.setString(5,date);
	         int n1=pdt.executeUpdate();
		       if(n1>0)
		       {
		    	   registerBox.setText("registration succeed");
			    	  nameBox.clear();
			  	     lastNameBox.clear();
			  	     ageBox.clear();
			  	     phoneBox.clear();
			  	   DateBox.setValue(null);
			  	    cardiology.setSelected(false);
		       }
		  
		     }catch (SQLException ex) {
		    	   System.out.println("erreurrr");
		     }
		     }
		
		     if (ent.isSelected())
			     
		     {
		    	 String sql = "INSERT INTO t_ear_register(firstName,lastName,phoneNum,age,date) values (?,?,?,?,?)";
		     
try{
		     java.sql.PreparedStatement pdt = con.prepareStatement(sql);
	         pdt.setString(1, name);
	         pdt.setString(2, lastName);
	        pdt.setString(3, phone);
	         pdt.setString(4, age);
	         pdt.setString(5,date);
	         int n1=pdt.executeUpdate();
		       if(n1>0)
		       {
		    	   registerBox.setText("registration succeed");
			    	  nameBox.clear();
			  	     lastNameBox.clear();
			  	     ageBox.clear();
			  	     phoneBox.clear();
			  	     
			  	  DateBox.getEditor().clear();
			  	 DateBox.setValue(null);
			  	 ent.setSelected(false);
		       }
		  
		     }catch (SQLException ex) {
		    	   System.out.println("erreurrr");
		     }
		     }
		     
		     con.close();
	  }
	  ///////////////////////retourrrr///////////////////////
	 
	@FXML
	private void backhundle(ActionEvent event) throws IOException
	{
		 
		 AnchorPane pane = FXMLLoader.load(getClass().getResource("FirstViewFront.fxml"));
	    childpane.getChildren().setAll(pane);
		}
}
