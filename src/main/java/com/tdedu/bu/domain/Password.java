package com.tdedu.bu.domain;

import java.util.Date;
	/*
	 * 学习平台帐号密码表
	 */
public class Password {
	private String userId;
	private String userName;
	private String password;
	private Date startDate;
	private Date endDate;
	
	
	
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Password(String userId, String userName, String password,
			Date startDate, Date endDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
