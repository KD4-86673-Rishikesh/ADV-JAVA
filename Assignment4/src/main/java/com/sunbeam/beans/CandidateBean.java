package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class CandidateBean 
{
  List<Candidate> list;
  
  public CandidateBean() {
	  this.list = new ArrayList<Candidate>();
  }

public List<Candidate> getList() {
	return list;
}

public void setList(List<Candidate> list) {
	this.list = list;
}
  public void loadCandidates()
  
  {
       System.out.println("Inside method");	     
	   try(CandidateDao candao =new CandidateDaoImpl())
	   { 
		  list=candao.findAll();
		  System.out.println(list);
		  
		   
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	   }
  }
}
