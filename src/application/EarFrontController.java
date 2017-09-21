package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;





import entity.DentalPatient;
import entity.EarPatient;

public class EarFrontController implements Initializable{

	public EarFrontController()
	{}
	
	@FXML
	  private AnchorPane rootpane;

@FXML
Label insertbox;

@FXML
private JFXButton gobackid,addid,delete1,edit1;



@FXML
private JFXTextField patientBox;

@FXML
private JFXTextField doctorBox;

@FXML
private JFXTextField diagBox;

@FXML
private JFXTextField treatBox,ageBox;
@FXML
private JFXDatePicker nextDateBox;
@FXML
private ObservableList<EarPatient> data;
@FXML
   private TableView<EarPatient> tableview1;


////////////////////////////////////retourrrrr/////////////////////////////
@FXML
private void backhundle(javafx.event.ActionEvent event) throws IOException
{
	Stage stage1 = (Stage) gobackid.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("mainViewFx.fxml"));

	AnchorPane pane = (AnchorPane) loader.load();
	
	AdminHomeController controller = loader.<AdminHomeController > getController();
	if (controller==null)
		System.out.println("controlleur login null");
	Scene scene = new Scene(pane);

	stage1.setScene(scene);
	stage1.show();
}

/////////////////////////////////update///////////////////////////////////////////////
@FXML
private void edit1hundle(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException
{
	 tableview1.setEditable(true);
	Class.forName("com.mysql.jdbc.Driver");
	   
	 Connection con = null;
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			int selectedIndex = tableview1.getSelectionModel().getSelectedIndex();
			EarPatient ep  = tableview1.getSelectionModel().getSelectedItem();
			if (ep != null) {
				
				  patientBox.setText(ep .getPatientName());
			  	     doctorBox.setText(ep .getDoctorName());
			  	     ageBox.setText(ep .getPatientAge());
			  	     diagBox.setText(ep .getPatientDiagnosis());
			  	     treatBox.setText(ep .getDiagnosisTreatment());
			  	   nextDateBox.setPromptText(ep.getNextDate());
			  	   
			  	   String sql = "DELETE FROM t_ear_patient WHERE patientName=? AND doctorName=?";
		    	   java.sql.PreparedStatement statement = con.prepareStatement(sql);
		    	   statement.setString(1, ep.getPatientName());
		    	   statement.setString(2, ep.getDoctorName());
		    	    statement.executeUpdate();
				
			   }
			tableview1.setEditable(true);
			tableview1.getItems().remove(selectedIndex);
					
			
con.close();			
}



/////////////////////////delete//////////////////////////
@FXML
private void delete1hundle(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException
{
	 
    
	
			Class.forName("com.mysql.jdbc.Driver");
	   
	 Connection con = null;
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			
			
			int selectedIndex = tableview1.getSelectionModel().getSelectedIndex();
			EarPatient ep  = tableview1.getSelectionModel().getSelectedItem();
	     if (ep != null) {
	    	
	    	 String sql = "DELETE FROM t_ear_patient WHERE patientName=? AND doctorName=?";
	    	   java.sql.PreparedStatement statement = con.prepareStatement(sql);
	    	   statement.setString(1, ep.getPatientName());
	    	   statement.setString(2, ep.getDoctorName());
	    	    statement.executeUpdate();
	    	 }
	          
	     
	    	tableview1.setEditable(true);
			tableview1.getItems().remove(selectedIndex);
	   
	    	    con.close();
	     }




///////////////////////////////////insertion ////////////////////////////

@FXML
private void addButton(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException

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
	     
	     String patient = patientBox.getText();
	     String doctor = doctorBox.getText();
	   String age = ageBox.getText();
           String diagnosis = diagBox.getText();
	     String treatment = treatBox.getText();
	    
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	     String nextDate = (nextDateBox.getValue()).format(formatter);
	     
	     String sql = "INSERT INTO t_ear_patient(patientName,doctorName,patientAge,patientDiagnosis,diagnosisTreatment,nextDate) values (?,?,?,?,?,?)";

	     try {
	         java.sql.PreparedStatement pdt = con.prepareStatement(sql);
	         pdt.setString(1, patient);
	         pdt.setString(2, doctor);
	        pdt.setString(3, age);
	         pdt.setString(4, diagnosis);
	         pdt.setString(5,treatment);
	         pdt.setString(6,nextDate);
	
	        
	         int n1=pdt.executeUpdate();
	       if(n1>0)
	       {
	    	   insertbox.setText("patient inserted");
	    	   patientBox.clear();
	  	     doctorBox.clear();
	  	     ageBox.clear();
	  	     diagBox.clear();
	  	     treatBox.clear();
	  	   nextDateBox.getEditor().clear();
	  	   buildData();
	       }
	      

	       }catch (SQLException ex) {
	    	   System.out.println("erreurrr");
	    	   
	
	       }
	
	     con.close();
}
// /////////////////////////////////////////ADDDDDDDDDDDDDDDDDDD DATA TO TABLE  /////////////////////////////  	   
	  

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
        String SQL = "Select * from t_ear_patient";            
        ResultSet rs = con.createStatement().executeQuery(SQL);  
        while(rs.next()){
        	EarPatient ep = new EarPatient();
           ep.patientName.set(rs.getString("patientName"));                       
           ep.doctorName.set(rs.getString("doctorName"));
           ep.patientAge.set(rs.getString("patientAge"));
           ep.patientDiagnosis.set(rs.getString("patientDiagnosis"));
           ep.diagnosisTreatment.set(rs.getString("diagnosisTreatment"));
           ep.nextDate.set(rs.getDate("nextDate").toString());
           data.add(ep);                  
        }
        tableview1.setItems(data);
    }
    catch(Exception e){
          e.printStackTrace();
          System.out.println("Error on Building Data");            
    }
    con.close();
}
	     
@FXML
private void requestAccess(javafx.event.ActionEvent event) throws IOException 
{
	 AnchorPane pane = FXMLLoader.load(getClass().getResource("AppointmentEarFront.fxml"));
	    rootpane.getChildren().setAll(pane);
}   

@Override
public void initialize(URL location, ResourceBundle resources) {
	
	  assert tableview1 != null : "fx:id=\"tableview\" was not injected: check your FXML file 'EarFrontController.fxml'.";
	  
	  TableColumn<EarPatient,String> patientName = new TableColumn<EarPatient,String>("patientName");
	  patientName.setCellValueFactory(
	        new PropertyValueFactory<EarPatient,String>("patientName"));
	  
	  TableColumn<EarPatient,String> doctorName = new TableColumn<EarPatient,String>("doctorName");
	  doctorName.setCellValueFactory(                
	        new PropertyValueFactory<EarPatient,String>("doctorName"));
	    
	    TableColumn<EarPatient,String> patientAge = new TableColumn<EarPatient,String>("patientAge");
	    patientAge.setCellValueFactory(
	        new PropertyValueFactory<EarPatient,String>("patientAge")); 
	    
	    TableColumn<EarPatient,String> patientDiagnosis = new TableColumn<EarPatient,String>("patientDiagnosis");
	    patientDiagnosis.setCellValueFactory(
	        new PropertyValueFactory<EarPatient,String>("patientDiagnosis")); 
	    
	    TableColumn<EarPatient,String> diagnosisTreatment = new TableColumn<EarPatient,String>("diagnosisTreatment");
	    diagnosisTreatment.setCellValueFactory(
	        new PropertyValueFactory<EarPatient,String>("diagnosisTreatment")); 
	    TableColumn<DentalPatient,String> nextDate = new TableColumn<DentalPatient,String>("nextDate");
	    nextDate.setCellValueFactory(
	        new PropertyValueFactory<DentalPatient,String>("nextDate")); 

	  
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