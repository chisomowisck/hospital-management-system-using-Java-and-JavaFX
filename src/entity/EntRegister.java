package entity;
import javafx.beans.property.SimpleStringProperty;
public class EntRegister {
 public EntRegister() {}
	
 
 
 public SimpleStringProperty firstName = new SimpleStringProperty();
 public SimpleStringProperty lastName = new SimpleStringProperty(); 
 public SimpleStringProperty age = new SimpleStringProperty();
 public SimpleStringProperty phoneNum   = new SimpleStringProperty();

public SimpleStringProperty date = new SimpleStringProperty();
 
public String getFirstName() {
	return firstName.get();
}

public String getLastName() {
	return lastName.get();
}

public String getAge() {
	return age.get();
}

public String getPhoneNum() {
	return phoneNum.get();
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
 
 
 public void setAge(String pAge) {
	 age.set(pAge);
	  }
 
 public void setPhoneNum(String pNum) {
	 phoneNum.set(pNum);
	  }
 
}
