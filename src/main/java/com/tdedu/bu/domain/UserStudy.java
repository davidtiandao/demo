package com.tdedu.bu.domain;

public class UserStudy {
	/*
	 *学习进度表
	 */
	private String id;
	private String userId;
	private String sectionId;
	private long sectionTime;
	private String courseId;
	
	
	
	public UserStudy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserStudy(String id, String userId, String sectionId,
			long sectionTime, String courseId) {
		super();
		this.id = id;
		this.userId = userId;
		this.sectionId = sectionId;
		this.sectionTime = sectionTime;
		this.courseId = courseId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public long getSectionTime() {
		return sectionTime;
	}
	public void setSectionTime(long sectionTime) {
		this.sectionTime = sectionTime;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
}
