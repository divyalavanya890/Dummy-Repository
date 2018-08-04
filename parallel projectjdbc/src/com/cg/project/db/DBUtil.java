package com.cg.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.project.exception.ProjectException;

public class DBUtil {
	public static Connection getConnection() throws ProjectException{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url,"system","root");
		}catch(ClassNotFoundException e){
		throw new ProjectException(e.getMessage());
		}catch(SQLException e1){
		throw new ProjectException(e1.getMessage());
		}
		 
		 
		}
		}

