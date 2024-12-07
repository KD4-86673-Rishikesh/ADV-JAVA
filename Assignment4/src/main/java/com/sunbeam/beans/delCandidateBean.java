package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class delCandidateBean {
	private int candId;
	private int delStatus;
	
	
	public int getCandId() {
		return candId;
	}


	public void setCandId(int candId) {
		this.candId = candId;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelstatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public void deleteCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			this.delStatus = candDao.deleteById(candId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
