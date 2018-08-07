package com.cg.dao;

import com.cg.bean.Account;
import com.cg.exception.ProjectException;

public interface IProjectDao {
	public String createAccount(Account account) throws ProjectException;

	public double showBalance(String mobileNo) throws ProjectException;

	public Account deposit(String mobileNo,double depositAmount)
	throws ProjectException;

	public Account withdraw(String mobileNo,double depositAmount) throws ProjectException;
	 
	//public boolean fundTransfer(String mobile1, String mobile2, double amount) throws BankException;

	public Account printTransactionDetails(String mobileNo)
	throws ProjectException;
	 
	//public BankWalletAccount getAccountDetails(String mobileNo) throws BankException;
}
