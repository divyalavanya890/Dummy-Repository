package com.cg.project.testcases;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.project.beans.Account;
import com.cg.project.exception.ProjectException;
import com.cg.project.service.IProjectService;
import com.cg.project.service.ProjectServiceImpl;

public class TestCases {
	private IProjectService service;
	@Before
	public void init()  {
		service = new ProjectServiceImpl();
	}
	@Test
	public void testCreateAccountForMobile() {
		Account ac = new Account();
		ac.setMobileNo("1234");
		ac.setName("Divya");
		ac.setEmail("divya@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (ProjectException e) {
		Assert.assertEquals("Mobile number should contain 10 digits", e.getMessage());
		}
	}
	
		@Test
		public void testCreatAccountForName() {
			Account ac = new Account();
			ac.setMobileNo("1234567890");
			ac.setName("Divya1");
			ac.setEmail("divya1@gmail.com");
			ac.setBalance(500.0);
			try {
				service.createAccount(ac);
			} catch (ProjectException e) {
			assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
			}
		}
		 
		@Test
		public void testCreatAccountForIsEmpty() {
			Account ac = new Account();
			ac.setMobileNo("1234567890");
			ac.setName("");
			ac.setEmail("divya1@gmail.com");
			ac.setBalance(200.0);
			try {
				service.createAccount(ac);
			} catch (ProjectException e) {
			Assert.assertEquals("Name cannot be empty", e.getMessage());
			}
		}
		
		@Test
		public void testCreatAccountForEmailId() {
			Account ac = new Account();
			ac.setMobileNo("1234567890");
			ac.setName("Roopa");
			ac.setEmail("divya1@gmail.com");
			ac.setBalance(200.0);
			try {
				service.createAccount(ac);
			} catch (ProjectException e) {
			assertEquals("Enter valid emailid", e.getMessage());
			}
		}
		@Test
		public void testCreatAccountForEmailId1() {
			Account ac = new Account();
			ac.setMobileNo("1234567890");
			ac.setName("Roopa");
			ac.setEmail("divya1@gma3142l.com");
			ac.setBalance(200.0);
			try {
				service.createAccount(ac);
			} catch (ProjectException e) {
			assertEquals("Enter valid emailid", e.getMessage());
			}
		}
		@Test
		public void testCreateAccount() {
			Account ac = new Account();
			ac.setMobileNo("1234567890");
			ac.setName("Sravani");
			ac.setEmail("Sravani@gmail.com");
			ac.setBalance(200.0);
			try {
				String s=service.createAccount(ac);
				assertNotNull(s);
			} catch (ProjectException e) {
			assertEquals("Enter valid emailid", e.getMessage());
			}
		}
		@Test
		public void testShowBalanceForMobileNo() {
			/*Account ac = new Account();
			ac.setMobileNo("1234");*/
			
			try {
				service.showBalance("99999");
			} catch (ProjectException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}
		@Test
		public void testShowBalanceForMobileNo1() {
			/*Account ac = new Account();
			ac.setMobileNo("1234");*/
			
			try {
				service.showBalance("bgfhgj");
			} catch (ProjectException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}
	
		@Test
		public void testShowBalanceForName() {
			Account ac = new Account();
			ac.setMobileNo("8888888888");
			
			try {
				service.showBalance(ac.getMobileNo());
				//assertEquals("Roopa", ac.getName());
			} catch (ProjectException e) {
			assertEquals("Exhausted Resultset", e.getMessage());
			}
		}
		@Test
		public void testShowDepositeForMobileNo() {
			Account ac = new Account();
			ac.setMobileNo("7777777777");
			
			try {
				service.deposite(ac.getMobileNo(),230);
			} catch (ProjectException e) {
			assertEquals("Exhausted Resultset", e.getMessage());
			}
		}
		
		@Test
		public void testDepositeForDepositeAmt1() {
			Account ac = new Account();
			ac.setMobileNo("7777777777");
			
			try {
				service.deposite(ac.getMobileNo(), -230);
			} catch (ProjectException e) {
			assertEquals("Deposit amount must be greater than zero", e.getMessage());
			}
		}
		@Test
		public void testDeposite() {
			Account ac = new Account();
			ac.setMobileNo("7777777777");
			
			try {
				Account ac1=service.deposite(ac.getMobileNo(),230);
				assertNotNull(ac1);
			} catch (ProjectException e) {
				assert (e.getMessage()) != null;
			}
		}
		@Test
		public void testWithDrawForMobileNo() {
			Account ac = new Account();
			ac.setMobileNo("7777777");
			
			try {
				service.withdraw(ac.getMobileNo(), 230);
			} catch (ProjectException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}
		public void testWithdrawForMobileNoDoesNotExist() {
			Account ac = new Account();
			ac.setMobileNo("888888888");
			
			try {
				service.withdraw(ac.getMobileNo(),230);
			} catch (ProjectException e) {
			assertEquals("The mobile number does not exist", e.getMessage());
			}
		}
		@Test
		public void testWithdrawAmt() {
			Account ac = new Account();
			ac.setMobileNo("7777777777");
			
			try {
				service.withdraw(ac.getMobileNo(), -230);
			} catch (ProjectException e) {
			assertEquals("The amount to be withdrawn should be greater than zero", e.getMessage());
			}
		}
		@Test
		public void testFundTransferForMobileNo() {
			Account ac = new Account();
			Account ac2 = new Account();
			ac.setMobileNo("777777777");
			ac2.setMobileNo("9999");
			
			try {
				service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
			} catch (ProjectException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}
		public void testFundTransferForMobileNoDoesNotExist() {
			Account ac = new Account();
			Account ac2 = new Account();
			ac.setMobileNo("6666666666");
			ac2.setMobileNo("9999999999");
			
			try {
				service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
			} catch (ProjectException e) {
			assertEquals("The mobile number does not exist", e.getMessage());
			}
		}
		@Test
		public void testFundTransferForAmt() {
				try {
				service.fundTransfer("6666666666","8888888888", -230);
			} catch (ProjectException e) {
			assertEquals("The amount to be withdrawn should be greater than zero", e.getMessage());
			}
		}
		@Test
		public void testFundTransfer() {
			Account ac = new Account();
			Account ac2 = new Account();
			ac.setMobileNo("6666666666");
			ac2.setMobileNo("8888888888");
			
			try {
				assertTrue(service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230));
			} catch (ProjectException e) {
			assert (e.getMessage()) != null;
			}
		}
		@Test
		public void testPrinttranscationDetails() {
			Account ac = new Account();
			ac.setMobileNo("6666666666");
			
			try {
				Account acc=service.printTranscationDetails(ac.getMobileNo());
				assertNotNull(acc);
			} catch (ProjectException e) {
				assert (e.getMessage()) != null;
			}
		}
		@Test
		public void testPrinttranscationDetails1() {
			Account ac = new Account();
			ac.setMobileNo("666666");
			
			try {
				Account acc=service.printTranscationDetails(ac.getMobileNo());
				assertNotNull(acc);
			} catch (ProjectException e) {
				assert (e.getMessage()) != null;
			}
		}
	}
	


