package com.tdedu.bu.domain;

public class Status {
	/*
	 */
	private int statusNo;
	private String statusName;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Status(int statusNo, String statusName) {
		super();
		this.statusNo = statusNo;
		this.statusName = statusName;
	}

	public int getStatusNo() {
		return statusNo;
	}

	public void setStatusNo(int statusNo) {
		this.statusNo = statusNo;
	}

	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}	
