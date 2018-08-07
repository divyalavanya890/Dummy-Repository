package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.bean.Account;
import com.cg.exception.ProjectException;

public class ProjectDaoImpl implements IProjectDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
	private EntityManager em = emf.createEntityManager();
	@Override
	public String createAccount(Account account) throws ProjectException {

		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		System.out.println("Done!!");
		return account.getPhoneNum();
	}

	@Override
	public double showBalance(String mobileNo) throws ProjectException {
		String string = "select a from BankWalletAccount a where a.phoneNum=?";
		TypedQuery<Account> query = em.createQuery(string, Account.class);
		query.setParameter(1, mobileNo);
		Account ac = query.getSingleResult();
		if (mobileNo.equals(ac.getPhoneNum())) {
			return ac.getBalanceAmount();
		} else {
			throw new ProjectException("number doesnot exists");
		}
	}

	@Override
	public Account deposit(String mobileNo, double depositAmount) throws ProjectException {
		em.getTransaction().begin();
		String str = "select a from BankWalletAccount a where a.phoneNum=?";
		TypedQuery<Account> query = em.createQuery(str, Account.class);
		query.setParameter(1, mobileNo);
		Account acc = query.getSingleResult();
		if (acc == null) {
			throw new ProjectException("Account does not exists");
		}
		double d = acc.getBalanceAmount() + depositAmount;
		acc.setBalanceAmount(d);
		// ac.setDate(Date.valueOf(LocalDate.now()));
		em.merge(acc);

		em.getTransaction().commit();
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo, double depositAmount) throws ProjectException {
		em.getTransaction().begin();
		String str = "select a from BankWalletAccount a where a.phoneNum=?";
		TypedQuery<Account> query = em.createQuery(str, Account.class);
		query.setParameter(1, mobileNo);
		Account ac = query.getSingleResult();
		if (ac == null) {
			throw new ProjectException("does not exists");
		}
		double d = ac.getBalanceAmount() - depositAmount;
		ac.setBalanceAmount(d);
		// ac.setDate(Date.valueOf(LocalDate.now()));
		em.merge(ac);

		em.getTransaction().commit();
		return ac;
	}

	@Override
	public Account printTransactionDetails(String mobileNo) throws ProjectException {
		String str = "select a from BankWalletAccount a where a.phoneNum=?";
		TypedQuery<Account> query = em.createQuery(str, Account.class);
		query.setParameter(1, mobileNo);
		Account ac = query.getSingleResult();
		if (ac == null) {
			return ac;
		} else {
			throw new ProjectException("number doesnot exists");
		}
	}

}
