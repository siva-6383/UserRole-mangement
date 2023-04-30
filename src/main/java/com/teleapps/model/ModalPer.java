package com.teleapps.model;

import java.util.List;

public class ModalPer {
	private int role_id;
	private String modal;
	private String role;
	private List<User> roleList;
	
	public ModalPer(String modal, String role,List<User> roleList) {
		this.modal = modal;
		this.role = role;
		this.roleList=roleList;
		
	}
	

	public ModalPer(String modal, String role) {
		
		this.modal = modal;
		this.role = role;
	}


	public ModalPer(String modal) {
		this.modal = modal;
	}

	public ModalPer(int id, String modal2, String role2, List<User> roleList2) {
		this.role_id=id;
		this.modal = modal2;
		this.role = role2;
		this.roleList=roleList2;
		
	}


	public ModalPer(String modal, List<User> roleList) {
		this.modal = modal;
		this.roleList = roleList;
	}


	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<User> roleList) {
		this.roleList = roleList;
	}
	
	
}
