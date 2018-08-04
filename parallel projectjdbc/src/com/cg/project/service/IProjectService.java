package com.cg.project.service;

import com.cg.project.beans.Account;
import com.cg.project.exception.ProjectException;

public interface IProjectService {
	String createAccount(Account acc) throws ProjectException;
	double showBalance(String mobileNo) throws ProjectException;
	Account deposite(String mobileNo,double depositeAmt) throws ProjectException;
	Account withdraw(String mobileNo,double withdrawAmt) throws ProjectException;
	boolean fundTransfer(String sourcemobileNo,String destMobilNo,double fundTransferAmt) throws ProjectException;
	Account printTranscationDetails(String mobileNo) throws ProjectException;
	
}
