package com.tdedu.bu.domain;

import java.util.Date;

public class Section {
	/*
	 * 课件表
	 */
	private String id;
	private String sectionName;
	private String sectionVersion;
	private Date sectionCreateDate;
	private Date sectionUpdateDate;
	private String sectionTypeId;
	private int sectionStatus;
	private String teacherId;
	
	
	
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Section(String id, String sectionName, String sectionVersion,
			Date sectionCreateDate, Date sectionUpdateDate,
			String sectionTypeId, int sectionStatus, String teacherId) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.sectionVersion = sectionVersion;
		this.sectionCreateDate = sectionCreateDate;
		this.sectionUpdateDate = sectionUpdateDate;
		this.sectionTypeId = sectionTypeId;
		this.sectionStatus = sectionStatus;
		this.teacherId = teacherId;
	}


	public void setSectionCreateDate(Date sectionCreateDate) {
		this.sectionCreateDate = sectionCreateDate;
	}


	public void setSectionUpdateDate(Date sectionUpdateDate) {
		this.sectionUpdateDate = sectionUpdateDate;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSectionVersion() {
		return sectionVersion;
	}
	public void setSectionVersion(String sectionVersion) {
		this.sectionVersion = sectionVersion;
	}
	public String getSectionTypeId() {
		return sectionTypeId;
	}
	public void setSectionTypeId(String sectionTypeId) {
		this.sectionTypeId = sectionTypeId;
	}
	
	public int getSectionStatus() {
		return sectionStatus;
	}

	public void setSectionStatus(int sectionStatus) {
		this.sectionStatus = sectionStatus;
	}

	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	
}
