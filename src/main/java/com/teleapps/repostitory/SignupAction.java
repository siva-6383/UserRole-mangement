package com.teleapps.repostitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teleapps.model.Bean;

public class SignupAction {
	public  ArrayList<Bean> signupDetails(Bean b) {
		//String status="";
		 ArrayList<Bean> pojplist = new ArrayList<Bean>();
		String username=b.getUsername();
		String email=b.getEmail();
		String password=b.getPassword();
		
		
		
		String query="exec Sp_JSP_LoginForm_insert @username =?,@email=?,@password=?";
		try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

          Connection con = DriverManager.getConnection(
                  "jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");

          PreparedStatement stmt = con.prepareStatement(query);
          stmt.setString(1, username);
          stmt.setString(2, email);
          stmt.setString(3, password);
          
          int rs=stmt.executeUpdate();
 
         if(rs>0) {
        	
        	 pojplist.add(b);
         }
             		
 		}
 		catch(ClassNotFoundException e) {
 			e.printStackTrace();
 			}
 		catch(SQLException e) {
 			e.printStackTrace();
 		}
 		return pojplist;
 		
 	}
 
 }
		
		