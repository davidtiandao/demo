package com.tdedu.bu.domain;

import java.util.Date;

public class Course {
	/*
	 *课程表
	 */
	private String id;
	private String courseTitle;
	private String courseNo;
	private String courseVersion;
	private Date courseCreateDate;
	private String courseContent;
	private String courseResource;;
	private String courseIntroduction;
	private Date courseUpdateDate;
	private int seeNumber;
	private int courseStatus;
	private String categoryNo;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(String id, String courseTitle, String courseNo,
			String courseVersion, Date courseCreateDate, String courseContent,
			String courseResource, String courseIntroduction,
			Date courseUpdateDate, int seeNumber, int courseStatus,String categoryNo) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.courseNo = courseNo;
		this.courseVersion = courseVersion;
		this.courseCreateDate = courseCreateDate;
		this.courseContent = courseContent;
		this.courseResource = courseResource;
		this.courseIntroduction = courseIntroduction;
		this.courseUpdateDate = courseUpdateDate;
		this.seeNumber = seeNumber;
		this.courseStatus = courseStatus;
		this.categoryNo=categoryNo;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseVersion() {
		return courseVersion;
	}
	public void setCourseVersion(String courseVersion) {
		this.courseVersion = courseVersion;
	}
	public Date getCourseCreateDate() {
		return courseCreateDate;
	}
	public void setCourseCreateDate(Date courseCreateDate) {
		this.courseCreateDate = courseCreateDate;
	}
	public String getCourseContent() {
		return courseContent;
	}
	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}
	public String getCourseResource() {
		return courseResource;
	}
	public void setCourseResource(String courseResource) {
		this.courseResource = courseResource;
	}
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	public Date getCourseUpdateDate() {
		return courseUpdateDate;
	}
	public void setCourseUpdateDate(Date courseUpdateDate) {
		this.courseUpdateDate = courseUpdateDate;
	}
	public int getSeeNumber() {
		return seeNumber;
	}
	public void setSeeNumber(int seeNumber) {
		this.seeNumber = seeNumber;
	}
	public int getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(int courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	
	
}
