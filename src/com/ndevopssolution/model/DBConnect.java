package com.ndevopssolution.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @FileName DBConnection.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/16/2018
 */
public class DBConnect {
	
	private static String dbLoc;
	private static String dbDriver;
	
	public static Connection connect(String username, String password) {
		Connection conn = null;
		try {
			BufferedReader input = new BufferedReader(new FileReader("logs/db.loc"));
			dbLoc = input.readLine();
			input.close();
			dbDriver = "jdbc:ucanaccess://" + dbLoc;
			conn = DriverManager.getConnection(dbDriver);
			
		} catch(IOException fe) {
			fe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return conn;
	}
	
}
