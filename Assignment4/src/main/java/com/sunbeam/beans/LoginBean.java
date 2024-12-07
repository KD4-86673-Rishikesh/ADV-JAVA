package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {

private String email;
private String pass;
private User user=null;

   public LoginBean()
  {
	
  }

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
 public void authenticate()
{
	try(UserDao udao=new UserDaoImpl())
	{
		User u=udao.findByEmail(email);
		if(u.getPassword().equals(pass))
		 user=u;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
