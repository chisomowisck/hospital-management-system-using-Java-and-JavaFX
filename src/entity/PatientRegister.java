package entity;

import javafx.beans.property.SimpleStringProperty;

public class PatientRegister {

	public PatientRegister() {}
	
	public SimpleStringProperty firstName = new SimpleStringProperty();
	 public SimpleStringProperty lastName = new SimpleStringProperty(); 
	 public SimpleStringProperty doctorName = new SimpleStringProperty();
	 public SimpleStringProperty date = new SimpleStringProperty();
	 
	public String getFirstName() {
		return firstName.get();
	}

	public String getLastName() {
		return lastName.get();
	}



	public String getDate() {
		return date.get();
	}

	public void setDate(String pDate) {
		date.set(pDate);
		  }
	 public void setFirstName(String pName) {
		firstName.set(pName);
		  }
	 
	 public void setLastName(String lName) {
		lastName.set(lName);
		  }
	 
	 public String getDoctorName() {
			return lastName.get();
		}

	 public void setDoctortName(String pdoc) {
			doctorName.set(pdoc);
			  }
	 
}
