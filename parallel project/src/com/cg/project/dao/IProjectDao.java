package com.cg.project.dao;

import com.cg.project.beans.Account;
import com.cg.project.exception.ProjectException;


public interface IProjectDao {
	String createAccount(Account acc) throws ProjectException;
	double showBalance(String mobileNo) throws ProjectException;
	Account deposite(String mobileNo) throws ProjectException;
	Account withdraw(String mobileNo) throws ProjectException;
	//Account fundTransfer(String mobileNo) throws ProjectException;
	Account printTranscation(String mobileNo) throws ProjectException;
	
	

}
