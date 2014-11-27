package com.tdedu.bu.domain;

import java.util.Date;
	/*
	 * 用户意见表
	 */
public class CourseSuggest {
	private String courseSuggestId;
	private String userId;
	private String userName;
	private String courseSuggest;
	private Date createDate;
	
	
	public CourseSuggest(String courseSuggestId, String userId,
			String userName, String courseSuggest,Date createDate) {
		super();
		this.courseSuggestId = courseSuggestId;
		this.userId = userId;
		this.userName = userName;
		this.courseSuggest = courseSuggest;
		this.createDate=createDate;
	}


	public CourseSuggest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCourseSuggestId() {
		return courseSuggestId;
	}


	public void setCourseSuggestId(String courseSuggestId) {
		this.courseSuggestId = courseSuggestId;
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


	public String getCourseSuggest() {
		return courseSuggest;
	}


	public void setCourseSuggest(String courseSuggest) {
		this.courseSuggest = courseSuggest;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}
