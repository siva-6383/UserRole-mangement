package com.teleapps.model;

public class User {
	protected int id;
	protected String role;
	
	
	public User() {
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public User(String role) {
		super();
		this.role = role;
	}


	public User(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}


	

	
}