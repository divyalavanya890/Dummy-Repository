package com.cg.service;

import com.cg.bean.Account;
import com.cg.dao.IProjectDao;
import com.cg.dao.ProjectDaoImpl;
import com.cg.exception.ProjectException;

public class ProjectServiceImpl implements IProjectService{
	IProjectDao walletDao = new ProjectDaoImpl();
	@Override
	public String createAccount(Account account) throws ProjectException {
		// TODO Auto-generated method stub
		if (!account.getPhoneNum().matches("\\d{10}")) {
			throw new ProjectException("Mobile number should be 10 digits");
		}
		if (account.getCustName().isEmpty()
				|| account.getCustName() == null) {
			throw new ProjectException("Name cannot be empty");
		}
		 else {
			
			if (!account.getCustName().matches("[A-Z][A-Za-z]{2,}")) {
				throw new ProjectException(
						"Name should start with a Capital Letter and must contain alphabets only !");
			}
		}
		if (!account.getEmail().matches("[a-z0-9]{2,}+@{1}+[a-z]{2,}+\\.com")) {
			throw new ProjectException(
					"Email Id is Not Valid");
		}
		if (account.getBalanceAmount() <= 0) {
			throw new ProjectException("Balance cannot be less than zero");
		}
		return walletDao.createAccount(account);
		
	}

	@Override
	public double showBalance(String mobileNo) throws ProjectException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should be 10 digits");
		}
		return walletDao.showBalance(mobileNo);
	}

	@Override
	public Account deposit(String mobileNo, double depositAmount) throws ProjectException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should be 10 digits");
		}
		if (depositAmount <= 0) {
			throw new ProjectException("Deposit amount must be greater than zero");
		}
		Account account = walletDao.deposit(mobileNo,depositAmount);
			
		return account;
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmount) throws ProjectException {

		Account account=new Account() ;
		if (!mobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should be 10 digits");
		}
		/*
		if (withdrawAmount >= account.getBalanceAmount()) {
			throw new BankException(
					"Withdraw amount cannot be more than available balance");
		}*/
		account = walletDao.withdraw(mobileNo,withdrawAmount);
		return account;
	}

	@Override
	public Account printTransactionDetails(String mobileNo) throws ProjectException {
		return walletDao.printTransactionDetails(mobileNo);
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo, double transferAmount)
			throws ProjectException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should be 10 digits");
		}
		if (!destMobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should be 10 digits");
		}
		IProjectService walletService = new ProjectServiceImpl();
		Account acc1 = walletService.withdraw(sourceMobileNo,
				transferAmount);
		Account acc2 = walletService.deposit(destMobileNo,
				transferAmount);
		return true;
	}

}
