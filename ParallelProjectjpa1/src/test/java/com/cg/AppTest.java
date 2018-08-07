package com.cg;

import static org.junit.Assert.*;

import com.cg.bean.Account;
import com.cg.exception.ProjectException;
import com.cg.service.IProjectService;
import com.cg.service.ProjectServiceImpl;

import org.junit.Test;
import org.junit.Before;


public class AppTest 
    
{
    
    private IProjectService service;

	@Before
	public void init() {
		service = new ProjectServiceImpl();
	}

	@Test
	public void testCreateAccountForPhoneNum() {
		Account account = new Account();
		account.setPhoneNum("55555");
		account.setCustName("Divu");
		account.setEmail("divu@gmail.com");
		account.setBalanceAmount(2345.67);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
		assertEquals("Mobile number should be 10 digits",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForCustName() {
		Account account = new Account();
		account.setPhoneNum("7245612890");
		account.setCustName("898");
		account.setEmail("vineela@gmail.com");
		account.setBalanceAmount(52345.67);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Name should start with a Capital Letter and must contain alphabets only !",
					e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccountForCustName2() {
		Account account = new Account();
		account.setPhoneNum("7245612890");
		account.setCustName("Divya");
		account.setEmail("divya@gmail.com");
		account.setBalanceAmount(52345.67);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Name should start with a Capital Letter and must contain alphabets only !",
					e.getMessage());
		}
	}
	@Test
	public void testCreateAccountForCustName3() {
		Account account = new Account();
		account.setPhoneNum("7245612890");
		account.setCustName("div_ya");
		account.setEmail("divya@gmail.com");
		account.setBalanceAmount(52345.67);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Name should start with a Capital Letter and must contain alphabets only !",
					e.getMessage());
		}
	}


	
	@Test
	public void testCreateAccountForCustNameIsEmpty() {
		Account account = new Account();
		account.setPhoneNum("7245612890");
		account.setCustName("");
		account.setEmail("karunya@gmail.com");
		account.setBalanceAmount(52345.67);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
	assertEquals("Name cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForEmail() {
		Account account = new Account();
		account.setPhoneNum("7245634598");
		account.setCustName("Harika");
		account.setEmail("harika@gmail.co.in");
		account.setBalanceAmount(237);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Email Id is Not Valid", e.getMessage());
		}
	}


	@Test
	public void testCreateAccountForEmailWithNumbers() {
		Account account = new Account();
		account.setPhoneNum("7245634598");
		account.setCustName("Harika");
		account.setEmail("1238790@gmail.co.in");
		account.setBalanceAmount(237);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Email Id is Not Valid", e.getMessage());
		}
	}
	@Test
	public void testCreateAccountForEmailWithSpecialCharecters() {
		Account account = new Account();
		account.setPhoneNum("7245634598");
		account.setCustName("Harika");
		account.setEmail("!^&$*&@gmail.co.in");
		account.setBalanceAmount(237);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Email Id is Not Valid", e.getMessage());
		}
	}
	@Test
	public void testCreateAccountForEmailWithCapitals() {
		Account account = new Account();
		account.setPhoneNum("7245634598");
		account.setCustName("Harika");
		account.setEmail("VINNY@gmail.co.in");
		account.setBalanceAmount(237);
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			assertEquals("Email Id is Not Valid", e.getMessage());
		}
	}
	@Test
	public void testCreateAccountForBalanceAmount() {
		Account account = new Account();
		account.setPhoneNum("7245634598");
		account.setCustName("Harika");
		account.setEmail("harika@gmail.com");
		account.setBalanceAmount(-10);
		System.out.println(account);
		
		try {
			service.createAccount(account);
		} catch (ProjectException e) {
			e.printStackTrace();
			assertEquals("Balance cannot be less than zero", e.getMessage());
		}
	}

	@Test
	public void testCreateAccount() {
		Account account = new Account();
		account.setPhoneNum("9326379347");
		account.setCustName("Sindhu");
		account.setEmail("sindhu@gmail.com");
		account.setBalanceAmount(345);
		try {
			String s = service.createAccount(account);
			assertNotNull(s);
		} catch (ProjectException e) {
			assert (e.getMessage()) != null;
		}
	}

	@Test
	public void testDepositForPhoneNum() {
		Account account = new Account();
		account.setPhoneNum("9999340");
		try {
			service.deposit(account.getPhoneNum(), 500);
		} catch (ProjectException e) {
			assertEquals("Mobile number should be 10 digits",
					e.getMessage());
		}
	}

	@Test
	public void testDepositForDepositAmount() {
		
		
		try {
			service.deposit("9966303099", -1);
		} catch (ProjectException e) {
			assertEquals("Deposit amount must be greater than zero",
					e.getMessage());
		}
	}

	@Test
	public void testWithdrawForMobile() {
		Account account = new Account();
		account.setPhoneNum("87873408");
		try {
			service.withdraw(account.getPhoneNum(), 500);
		} catch (ProjectException e) {
			assertEquals("Mobile number should be 10 digits",
					e.getMessage());
		}
	}


}
