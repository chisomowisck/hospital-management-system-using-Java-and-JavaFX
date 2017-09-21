package entity;

import java.io.IOException;


import java.sql.*;

public class User {
   String userName;
   String password;
  
  
   public User()
   {}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassord(String password) {
	this.password = password;
}

}
