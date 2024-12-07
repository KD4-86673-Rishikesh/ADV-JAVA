package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
 private int canId;
 private boolean success;
 private int userId;
 
public VoteBean() {
	
}

public int getCanId() {
	return canId;
}

public void setCanId(int canId) {
	this.canId = canId;
}

public boolean getSuccess() {
	return success;
}

public void setSuccess(boolean success) {
	this.success = success;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public void vote()
{
	this.success=false;
	
	try(CandidateDao candao=new CandidateDaoImpl())
	{
		int count=candao.incrVote(canId);
		if(count==1)
		{
			try(UserDao udao=new UserDaoImpl())
			{
				User user= udao.findById(userId);
				
				if(user != null) {
				user.setStatus(1);
				count = udao.update(user);
				if(count == 1)
					this.success = true;
			 }
			}
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}














}
