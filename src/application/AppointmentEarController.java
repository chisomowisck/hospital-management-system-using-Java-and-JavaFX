package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import entity.CardiologyRegister;
import entity.EntRegister;
public class AppointmentEarController implements Initializable  {

	public AppointmentEarController () {}
	@FXML
	  private AnchorPane childpane;
	@FXML
	  private JFXDatePicker dateBox;
	@FXML
	private ObservableList<EntRegister> data;
	@FXML
	   private TableView<EntRegister> tableview1;

   @FXML
   private JFXTextField doctorBox;
	
	
	/////////////////retour//////////////
	@FXML
	private void goBack(ActionEvent event) throws IOException
	{
		 
		 AnchorPane pane = FXMLLoader.load(getClass().getResource("CardiologyFront.fxml"));
	    childpane.getChildren().setAll(pane);
		}
	
	
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
	        String SQL = "Select * from t_ear_register";            
	        ResultSet rs = con.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	           EntRegister dr = new EntRegister();
	            dr.firstName.set(rs.getString("firstName"));                       
	            dr.lastName.set(rs.getString("lastName"));
	            dr.age.set(rs.getString("age"));
	            dr.phoneNum.set(rs.getString("phoneNum"));
	             dr.date.set(rs.getDate("date").toString());
	               
	         data.add(dr);                  
	        }
	        tableview1.setItems(data);
	    }
	    catch(Exception e){
	          e.printStackTrace();
	          System.out.println("Error on Building Data");            
	    }
	    con.close();
	}
		     
//////////////////////approve//////////////////
@FXML
private void approvehundle(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException

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


 EntRegister en  = tableview1.getSelectionModel().getSelectedItem();
if (en!= null) {
String name= en.getFirstName();
String lastname= en.getLastName();


String doctor = doctorBox.getText();


DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

String date = (dateBox.getValue()).format(formatter);

String sql = "INSERT INTO t_patient_Register(firstName,lastName,doctorName,date) values (?,?,?,?)";

try {
java.sql.PreparedStatement pdt = con.prepareStatement(sql);

pdt.setString(1, name);
pdt.setString(2,lastname);
pdt.setString(3, doctor);
pdt.setString(4,date);

int n1=pdt.executeUpdate();
if(n1>0)
{

 doctorBox.clear();
 dateBox.getEditor().clear();
	 dateBox.setValue(null);
}     

}catch (SQLException ex) {
 System.out.println("erreurrr");
 

}
}
con.close();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	
	  assert tableview1 != null : "fx:id=\"tableview\" was not injected: check your FXML file 'AppointmentEarFront.fxml'.";
	  TableView<EntRegister> tableview1 = new TableView<EntRegister>(data);
	  TableColumn<EntRegister,String> firstName = new TableColumn<EntRegister,String>("firstName");
	  firstName.setCellValueFactory(
	        new PropertyValueFactory<EntRegister,String>("firstName"));
	  
	  
	  TableColumn<EntRegister,String> lastName = new TableColumn<EntRegister,String>("lastName");
	 lastName.setCellValueFactory(                
	        new PropertyValueFactory<EntRegister,String>("lastName"));
	    
	    TableColumn<EntRegister,String> age = new TableColumn<EntRegister,String>("age");
	    age.setCellValueFactory(
	        new PropertyValueFactory<EntRegister,String>("age")); 
	    
	    TableColumn<EntRegister,String> phoneNum = new TableColumn<EntRegister,String>("phoneNum");
	    phoneNum.setCellValueFactory(
	        new PropertyValueFactory<EntRegister,String>("phoneNum")); 
	    
	    TableColumn<EntRegister,String> date = new TableColumn<EntRegister,String>("date");
	    date.setCellValueFactory(
	        new PropertyValueFactory<EntRegister,String>("date")); 
	  
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

	    	



