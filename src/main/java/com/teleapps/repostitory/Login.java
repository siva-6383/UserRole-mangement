package com.teleapps.repostitory;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teleapps.model.Bean;
import com.teleapps.model.User;
import com.teleapps.model.ModalPer;


public class Login {
	
		private String jdbcURL = "jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022";
		private String jdbcUsername = "NewJoinee2022";
		private String jdbcPassword = "P@ssw0rd";
		
		private static final String ROLLPERMISSION = "exec Rollpermission_Sp @role=?,@username=?";
		private static final String SELECT_USER_BY_NAME = "select Role from JSP_LoginForm where username =?";
		private static final String SELECT_USER_BY_ROLE = "select * from USERROLE";
		private static final String SELECT_ALL_USERS = "exec Sp_edit_profile @username=?";
		private static final String SELECT_ALL_PER = "select * from modalpermission ";
		private static final String Update_per = "exec Modelpermissin_sp @role=?,@modal=?";
		private static final String Sp_All_List = "exec Sp_All_List @username=?";
		private static final String Update_profile = "exec editprofilr_sp @username=?,@email=?,@password=?,@id=?";
		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
		
		
	
	public boolean LoginData(Bean pj ) {

		 boolean status = false;
		try {
			String query = "select * from JSP_LoginForm where username='"+pj.getUsername()+"' and password='"+pj.getPassword()+"'";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				System.out.println(rs.getRow());
				//if(pj.getUsername().equals(rs.getString("username"))&&(pj.getPassword().equals(rs.getString("password")))) {
				System.out.println(rs.getString("username"));
			//pojplist.add(new Bean(rs.getString("username"), rs.getString("email"), rs.getString("password")));
				status = true;
			}			
			
		}

		catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// log.info(status);
		return status;

	}
	
	public ArrayList<Bean> UsersData( ) {

		 ArrayList<Bean> pojplist = new ArrayList<Bean>();
		try {
			String query = "select * from JSP_LoginForm";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				//if(pj.getUsername().equals(rs.getString("username"))&&(pj.getPassword().equals(rs.getString("password")))) {
				System.out.println(rs.getString("username"));
			pojplist.add(new Bean(rs.getString("username"), rs.getString("email"), rs.getString("password")));
					
			}	
//				else {
//					return null;
//			}
	
		}

		catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// log.info(status);
		return pojplist;	
	}
	
	public ArrayList<Bean> RolePermission( ) {

		 ArrayList<Bean> pojplist = new ArrayList<Bean>();
		//Array[] Result=new Array[4] ;
		try {
			String query = "select * from JSP_LoginForm";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				//if(pj.getUsername().equals(rs.getString("username"))&&(pj.getPassword().equals(rs.getString("password")))) {
				System.out.println(rs.getString("username"));
		pojplist.add(new Bean(rs.getString("username"), rs.getString("email"), rs.getString("password"),rs.getString("role")));
					
			}	
//				else {
//					return null;
//			}
		}

		catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// log.info(status);
		return pojplist;	
	}
	public ArrayList<Bean> Dropdown() {

		 ArrayList<Bean> droplist = new ArrayList<Bean>();
		try {
			String query = "select * from JSP_LoginForm";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				//if(pj.getUsername().equals(rs.getString("username"))&&(pj.getPassword().equals(rs.getString("password")))) {
				//System.out.println(rs.getString("role"));
			droplist.add(new Bean(rs.getString("role")));
					
			}	
//				else {
//					return null;
//			}
		}

		catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// log.info(status);
		System.out.println(droplist);
		return droplist;	
	}

	
	 public List<User> RoleList() {
		 
		 List<User> users = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ROLE);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id=rs.getInt("Id");
					String Role = rs.getString("Role");
					
					users.add(new User(id,Role));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return users;
		}
	
	public boolean updateUsers(Bean user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ROLLPERMISSION);) {
			
			statement.setString(1, user.getRole());
			statement.setString(2, user.getUsername());
			
	

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public List<ModalPer>modalpermission(){
		List<ModalPer> permission = new ArrayList<>();
		
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				 int id = rs.getInt("role_id");
				 System.out.println("Role id:"+id);
				 String modal=rs.getString("modal");
				 String role = rs.getString("Role");
				
				permission.add(new ModalPer(id,modal,role,RoleList()));
				//permission.add(new User(role));
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return permission;
	}
	public boolean modalupdate(ModalPer user ) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(Update_per);) {
			statement.setString(1, user.getRole());
			statement.setString(2, user.getModal());
			
			
	

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	public List<Object> AllData(String username2){
		List<Object> permission = new ArrayList<>();
		
		try (Connection connection = getConnection();

	    	// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(Sp_All_List);) {
			preparedStatement.setString(1, username2);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String  modal=rs.getString("modal");
				System.out.println(modal);
				permission.add(modal);
				//permission.add(new User(role));
				//System.out.println(permission+" "+"values");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return permission;
	}

	public List<Bean> Profiles(String username){
		
			 
			 List<Bean> Editpro = new ArrayList<>();
				// Step 1: Establishing a Connection
				try (Connection connection = getConnection();

						// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
					System.out.println(preparedStatement);
					preparedStatement.setString(1,username);
					// Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();

					// Step 4: Process the ResultSet object.
					while (rs.next()) {
						Editpro.add(new Bean(rs.getInt("id"),rs.getString("username"), rs.getString("email"), rs.getString("password")));
					
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				return Editpro;
			}
	public boolean editupdate(Bean profile ) throws SQLException {
		boolean editupdate = false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(Update_profile);)
		{
			
			statement.setString(1, profile.getUsername());
			statement.setString(2, profile.getEmail());
			statement.setString(3, profile.getPassword());
			statement.setInt(4, profile.getId());
			statement.executeUpdate();
			editupdate = true;
		}
		return editupdate;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}	}	
}
