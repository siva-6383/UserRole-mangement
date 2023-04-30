package com.teleapps.model;

public class Bean {
	private int id;
	private String username;
	private String email;
	private String password;
	private String role;
	private String modal;

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bean(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		
	}
	public Bean(int id, String username, String email,String password) {
		this.id=id;
		this.username = username;
		this.email = email;
		this.password = password;
		
	}

	public Bean() {
		// TODO Auto-generated constructor stub
	}

	public Bean(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Bean(String role) {
		// TODO Auto-generated constructor stub
	}

	public Bean(String username1, String role2) {
		this.username = username1;
		this.role = role2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
