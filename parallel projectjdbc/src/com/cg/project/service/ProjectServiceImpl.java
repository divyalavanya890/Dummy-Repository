package com.cg.project.service;

import java.time.LocalDateTime;

import com.cg.project.beans.Account;
import com.cg.project.dao.IProjectDao;
import com.cg.project.dao.ProjectDaoImpl;
import com.cg.project.exception.ProjectException;

public class ProjectServiceImpl implements IProjectService {
	IProjectDao dao = new ProjectDaoImpl();
	

	@Override
	public String createAccount(Account acc) throws ProjectException {
		if (!acc.getMobileNo().matches("\\d{10}")) {
			throw new ProjectException("Mobile number should contain 10 digits");
			}
			if (acc.getName().isEmpty() || acc.getName() == null) {
			throw new ProjectException("Name cannot be empty");
			} else {
			if (!acc.getName().matches("[A-Z][A-Za-z]{3,}")) {
			throw new ProjectException(
			"Name should start with capital letter and should contain only alphabets");
			}
			}
			if (acc.getBalance() < 0) {
			throw new ProjectException("Balance should be greater than zero");
			}
			if (!acc.getEmail().matches("[a-z]+@[a-z]+\\.com")) {
			throw new ProjectException("Enter valid emailid");
			}

			return dao.createAccount(acc);
			}
	@Override
	public double showBalance(String mobileNo) throws ProjectException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should contain 10 digits");
			}
			return dao.showBalance(mobileNo);
			}

		
		
		
		
		
		
		
	@Override
	public Account deposite(String mobileNo, double depositeAmt)
			throws ProjectException {
		
		if (!mobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should contain 10 digits");
			}
			//Account acc=dao.findOne(mobileNo);
			if (depositeAmt <= 0) {
			throw new ProjectException(
			"Deposit amount must be greater than zero");
			}
			 
			return dao.deposite(mobileNo,depositeAmt);
			//acc1.getBalance();
			}
	@Override
	public Account withdraw(String mobileNo, double withdrawAmt)
			throws ProjectException {
		
		if (!mobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should contain 10 digits");
			}
			//Account acc=dao.findOne(mobileNo);
			//if (withdrawAmt > acc.getBalance() || withdrawAmt <= 0) {
			if ( withdrawAmt <= 0) {
			throw new ProjectException(
			"The amount to be withdrawn should be greater than zero");
			}
			//acc.setBalance(acc.getBalance() - withdrawAmt);
			// acc.setDate(LocalDateTime.now());
			Account acc1 = dao.withdraw(mobileNo,withdrawAmt);
			return acc1;
			}
	

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double TransferAmt) throws ProjectException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should contain 10 digits");
			}
			if (!destMobileNo.matches("\\d{10}")) {
			throw new ProjectException("Mobile number should contain 10 digits");
			}
			IProjectService service = new ProjectServiceImpl();
			Account acc1 = service.withdraw(sourceMobileNo, TransferAmt);
			Account d2 = service.deposite(destMobileNo, TransferAmt);
			return true;
			}

	@Override
	public Account printTranscationDetails(String mobileNo)
			throws ProjectException {
		return dao.printTranscation(mobileNo);

	
	}

		
		
	}



