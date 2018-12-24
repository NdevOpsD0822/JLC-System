package com.ndevopssolution.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ndevopssolution.model.DBConnect;

/**
 * 
 * @FileName MemberUtil.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/16/2018
 */
public class MemberUtil {
	
	private static Connection conn;
	private static Statement stmt;
	
	public MemberUtil() {
		
	}
	
	public static int saveMember(String memberID, String firstName, String lastName, String gender, String status, String birthDate,
								  String address1, String address2, String city, String state, String postalCode, String country,
								  String phone, String email, String memo) throws SQLException {
		
		
		String sql = "INSERT INTO members(MemberID,FirstName,LastName,Gender,Status,DateOfBirth," +
								  		"Address1,Address2,City,State,Zip,Country," +
								  		"Phone,Email,Memo) " +
								  		"VALUES('" + memberID + "','" + firstName + "','" + lastName + "','" + gender + "','" + status + "',#" + birthDate + "#," +
								  			    "'" + address1 + "','" + address2 + "','" + city + "','" + state + "','" + postalCode + "','" + country + "'," +
								  			    "'" + phone + "','" + email + "', '" + memo + "')";
		conn = DBConnect.connect("", "");
		
		if(conn != null) {
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		}
		
		return 0;
	}
	
	public static int saveMember(String memberID, String firstName, String lastName, String gender, String status, 
								 String address1, String address2, String city, String state, String postalCode, String country,
								 String phone, String email, String memo) throws SQLException {
		String sql = "INSERT INTO members(MemberID,FirstName,LastName,Gender,Status,Address1,Address2,City,State,Zip,Country,Phone,Email,Memo) " +
					"VALUES('" + memberID +"','" + firstName + "','" + lastName + "','" + gender + "','" + status + "'," +
					         "'" + address1 + "','" + address2 + "','" + city + "','" + state + "','" + postalCode + "','" + country + "'," +
					         "'" + phone + "','" + email + "','" + memo + "')";
		
		conn = DBConnect.connect("", "");
		
		if(conn != null) {
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);

		}
		
		return 0;
	}
	
	public static ResultSet getMembersList() {
		
		ResultSet rs = null;
		
		String sql = "SELECT MemberID,FirstName, LastName,Phone,Email, Gender, Status, DateOfBirth, Address1, Address2, City, State, Zip, Country, Memo from Members";
		
		conn = DBConnect.connect("", "");
		
		try {
			stmt = conn.createStatement();
			return rs = stmt.executeQuery(sql);
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return rs;
		
	}

}
