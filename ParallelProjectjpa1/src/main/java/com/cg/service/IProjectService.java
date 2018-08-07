package com.cg.service;

import com.cg.bean.Account;
import com.cg.exception.ProjectException;

public interface IProjectService {

	public String createAccount(Account account) throws ProjectException;

	public double showBalance(String mobileNo) throws ProjectException;

	public Account deposit(String mobileNo, double depositAmount)
			throws ProjectException;

	public Account withdraw(String mobileNo, double withdrawAmount)
			throws ProjectException;

	public Account printTransactionDetails(String mobileNo)
			throws ProjectException;

	boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmount) throws ProjectException;
}
