package com.tdedu.bu.domain;

import java.util.Date;

public class Shooting {
	/*
	 * 直播表
	 */
	private String id;
	private String shootingCourseId;
	private String teacherId;
	private Date onlineDate;
	private int lookNumber;
	private String photoUrl;
	private String categoryId;
	
	
	
	public Shooting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Shooting(String id, String shootingCourseId, String teacherId,
			Date onlineDate, int lookNumber, String photoUrl,
			String categoryId) {
		super();
		this.id = id;
		this.shootingCourseId = shootingCourseId;
		this.teacherId = teacherId;
		this.onlineDate = onlineDate;
		this.lookNumber = lookNumber;
		this.photoUrl = photoUrl;
		this.categoryId = categoryId;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShootingCourseId() {
		return shootingCourseId;
	}
	public void setShootingCourseId(String shootingCourseId) {
		this.shootingCourseId = shootingCourseId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}


	public int getLookNumber() {
		return lookNumber;
	}
	public void setLookNumber(int lookNumber) {
		this.lookNumber = lookNumber;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
}
