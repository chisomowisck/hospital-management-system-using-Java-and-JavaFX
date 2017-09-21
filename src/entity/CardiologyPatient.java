package entity;

import javafx.beans.property.SimpleStringProperty;

public class CardiologyPatient {

	public CardiologyPatient()
	{}
	
	public SimpleStringProperty patientName = new SimpleStringProperty();
	public SimpleStringProperty doctorName= new SimpleStringProperty();
	public SimpleStringProperty patientAge = new SimpleStringProperty();
	public SimpleStringProperty patientDiagnosis = new SimpleStringProperty();
	public SimpleStringProperty diagnosisTreatment = new SimpleStringProperty();
	public SimpleStringProperty nextDate = new SimpleStringProperty();
	
	public String getPatientName() {
		return patientName.get();
	}

	public String getDoctorName() {
		return doctorName.get();
	}
	
	public String getPatientAge() {
		return patientAge.get();
	}
	
	public String getPatientDiagnosis() {
		return patientDiagnosis.get();
	}
	
	public String getDiagnosisTreatment() {
		return diagnosisTreatment.get();
	}
	
	 public void setPatientName(String pName) {
		 patientName.set(pName);
		  }
	 
	 public void setDoctorName(String dName) {
		 doctorName.set(dName);
		  }
	 public void setPatientDiagnosis(String pDiag) {
		 patientDiagnosis.set(pDiag);
		  }
	 
	 public void setPatientAge(String pAge) {
		 patientAge.set(pAge);
		  }
	 
	 public void setDiagnosisTreatment(String diagT) {
		 diagnosisTreatment.set(diagT);
		  }

	 
	 public String getNextDate() {
			return nextDate.get();
		}
	 public void setNextDate(String nDate) {
			nextDate.set(nDate);
		}
	
}


