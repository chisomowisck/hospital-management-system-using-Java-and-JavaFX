package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import entity.PatientRegister;

public class ListController  implements Initializable{

	@FXML
	private ObservableList<PatientRegister> data;
	@FXML
	   private TableView<PatientRegister> tableview1;

	public ListController (){}
	

	
	
	// /////////////////////////////////////////ADDDDDDDDDDDDDDDDDDD DATA TO TABLE  /////////////////////////////  	   
	  

	@FXML
	public void buildData() throws ClassNotFoundException, SQLException{        
	    data = FXCollections.observableArrayList();
	   
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
	    
	    
	    try{      
	        String SQL = "Select * from t_patient_register";            
	        ResultSet rs = con.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            PatientRegister dp = new  PatientRegister();
	           dp.firstName.set(rs.getString("firstName")); 
	           dp.lastName.set(rs.getString("lastName")); 
	           dp.doctorName.set(rs.getString("doctorName"));
	            dp.date.set(rs.getDate("date").toString());
	         
	               
	         data.add(dp);                  
	        }
	        tableview1.setItems(data);
	    }
	    catch(Exception e){
	          e.printStackTrace();
	          System.out.println("Error on Building Data");            
	    }
	    con.close();
	}
		     
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		  assert tableview1 != null : "fx:id=\"tableview\" was not injected: check your FXML file 'ListFront.fxml'.";
		  TableView<PatientRegister> tableview1 = new TableView<PatientRegister>(data);
		  TableColumn<PatientRegister,String> firstName = new TableColumn<PatientRegister,String>("firstName");
		  firstName.setCellValueFactory(
		        new PropertyValueFactory<PatientRegister,String>("firstName"));
		  
		  TableColumn<PatientRegister,String> lastName = new TableColumn<PatientRegister,String>("lastName ");
		  lastName .setCellValueFactory(
		        new PropertyValueFactory<PatientRegister,String>("lastName "));
		  
		  TableColumn<PatientRegister,String> doctorName = new TableColumn<PatientRegister,String>("doctorName");
		  doctorName.setCellValueFactory(                
		        new PropertyValueFactory<PatientRegister,String>("doctorName"));
		    
		    TableColumn<PatientRegister,String> date = new TableColumn<PatientRegister,String>("date");
		    date.setCellValueFactory(
		        new PropertyValueFactory<PatientRegister,String>("date")); 
		    		
	
		    try{
		    	Class.forName("com.mysql.jdbc.Driver");

		    	 Connection con = null;

		    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
		        buildData();
		    }
		    catch(ClassNotFoundException ce){
		        System.out.println("Error1");  
		    }
		    catch(SQLException ce){
		        System.out.println("Error2");  
		    }
	}
}