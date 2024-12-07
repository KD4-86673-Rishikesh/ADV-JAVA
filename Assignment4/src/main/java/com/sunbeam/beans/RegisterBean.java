package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegisterBean {
  String fname;
  String lname;
  String email;
  String password;
  String dob;
  int save;
 
  public RegisterBean() {
		
	}
public int getSave() {
	return save;
}
public void setSave(int save) {
	this.save = save;
}
public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}


  
   public void register()
   {
	   try(UserDao udao=new UserDaoImpl())
	   {
		   Date date=Date.valueOf(dob);
		   User user=new User(0, lname, fname, email, password, date, 0, "voter");
		   int count=udao.save(user);
		   save=count;
	   }
	   catch (Exception e) {
	      e.printStackTrace();
	  }
   }
  
}
