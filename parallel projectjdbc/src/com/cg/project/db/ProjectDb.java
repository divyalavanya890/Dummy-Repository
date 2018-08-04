package com.cg.project.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.project.beans.Account;

public class ProjectDb {
	private static HashMap<String,Account> ProjectDb=new
			HashMap<String,Account>();

	public static HashMap<String, Account> getProjectMap() {
		// TODO Auto-generated method stub
		return ProjectDb;
	}
	Account obj=new Account();
	static{
		ProjectDb.put("9999999999",new Account
				("9999999999","Divya","divya@gmail.com",2000.0,LocalDateTime.now()));
		ProjectDb.put("8888888888",new Account
				("8888888888","Roopa","roopa@gmail.com",3000.0,LocalDateTime.now()));
		ProjectDb.put("7777777777",new Account
				("7777777777","Sravani","sravani@gmail.com",4000.0,LocalDateTime.now()));
		ProjectDb.put("666666666",new Account
				("6666666666","Nikki","nikki@gmail.com",5000.0,LocalDateTime.now()));
	}

}
