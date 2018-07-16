package com.cg.project.dao;

import java.util.HashMap;

import com.cg.project.beans.Account;
import com.cg.project.db.ProjectDb;
import com.cg.project.exception.ProjectException;

public class ProjectDaoImpl implements IProjectDao {
	private static HashMap<String, Account> 
	ProjectMap=ProjectDb.getProjectMap();

	@Override
	public String createAccount(Account acc) throws ProjectException{
	ProjectMap.put(acc.getMobileNo(),acc);
		return acc.getMobileNo();
	}

	@Override
	public double showBalance(String mobileNo) throws ProjectException {
		Account acc = ProjectMap.get(mobileNo);
		if (acc == null) {
			throw new ProjectException("The mobile number does not exist");
		}
		return acc.getBalance();
	}

	@Override
	public Account deposite(String mobileNo) throws ProjectException {
		Account acc = ProjectMap.get(mobileNo);
		if (acc == null) {
			throw new ProjectException("The mobile number does not exist");
		}
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo) throws ProjectException {
		Account acc = ProjectMap.get(mobileNo);
		if (acc == null) {
			throw new ProjectException("The mobile number does not exist");
		}
		return acc;
	}

//	@Override
//	public Account fundTransfer(String mobileNo) throws ProjectException {
//		// TODO Auto-generated method stub
//		Account acc = ProjectMap.get(mobileNo);
//		if (acc == null) {
//			throw new ProjectException("The amount to be withdraw should be greater than available balance and greater than zero");
//		}
//		return acc;
//	}

	@Override
	public Account printTranscation(String mobileNo) throws ProjectException {
		// TODO Auto-generated method stub
		Account acc = ProjectMap.get(mobileNo);
		if (acc == null) {
			throw new ProjectException("The mobile number does not exist");
		}
		return acc;
	}
	}


