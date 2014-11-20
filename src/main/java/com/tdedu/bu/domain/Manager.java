package com.tdedu.bu.domain;

public class Manager {
	/*
	 * 学习平台管理员表
	 */
	private String managerId;
	private int managerStatus;
	private String managerRole;
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String managerId, int managerStatus, String managerRole) {
		super();
		this.managerId = managerId;
		this.managerStatus = managerStatus;
		this.managerRole = managerRole;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public int getManagerStatus() {
		return managerStatus;
	}
	public void setManagerStatus(int managerStatus) {
		this.managerStatus = managerStatus;
	}
	public String getManagerRole() {
		return managerRole;
	}
	public void setManagerRole(String managerRole) {
		this.managerRole = managerRole;
	}
	
	
}
