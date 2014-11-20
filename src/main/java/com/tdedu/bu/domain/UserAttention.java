package com.tdedu.bu.domain;

import java.util.Date;

public class UserAttention {
	/*
	 * 用户关注期待表
	 */
	private String id;
	private String userId;
	private String shootingId;
	private Date shootingDate;
	private String courseId;
	private int shootingAttentionStatus;
	
	
	
	public UserAttention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAttention(String id, String userId, String shootingId,
			Date shootingDate, String courseId, int shootingAttentionStatus) {
		super();
		this.id = id;
		this.userId = userId;
		this.shootingId = shootingId;
		this.shootingDate = shootingDate;
		this.courseId = courseId;
		this.shootingAttentionStatus = shootingAttentionStatus;
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
	public String getShootingId() {
		return shootingId;
	}
	public void setShootingId(String shootingId) {
		this.shootingId = shootingId;
	}
	public Date getShootingDate() {
		return shootingDate;
	}
	public void setShootingDate(Date shootingDate) {
		this.shootingDate = shootingDate;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getShootingAttentionStatus() {
		return shootingAttentionStatus;
	}
	public void setShootingAttentionStatus(int shootingAttentionStatus) {
		this.shootingAttentionStatus = shootingAttentionStatus;
	}
	
	
}
